package com.ablaze.service.impl;

import com.ablaze.entity.Dormitory;
import com.ablaze.mapper.DormitoryMapper;
import com.ablaze.mapper.StudentMapper;
import com.ablaze.service.DormitoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/10/0:01
 */

@Service
public class DormitoryServiceImpl implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Dormitory> availableList() {
        return dormitoryMapper.availableList();
    }

    @Override
    public List<Dormitory> list(int page, int size) {
        PageHelper.startPage(page,size);
        return dormitoryMapper.list();
    }

    @Override
    public List<Dormitory> search(String key, String value,int page, int size) {
        PageHelper.startPage(page,size);
        if ("".equals(value)) {
            return dormitoryMapper.list();
        }

        List<Dormitory> list = null;
        switch (key) {
            case "name":
                list = dormitoryMapper.searchByName(value);
                break;
            case "telephone":
                list = dormitoryMapper.searchByTelephone(value);
                break;
            default:
        }

        return list;
    }

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return dormitoryMapper.findByBuildingId(buildingId);
    }

    @Override
    public void save(Dormitory dormitory) {
        try {
            dormitoryMapper.save(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Dormitory dormitory) {
        try {
            dormitoryMapper.update(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            List<Integer> studentIdList = studentMapper.findStudentIdByDormitoryId(id);
            for (Integer studentId : studentIdList) {
                Integer availableDormitoryId = dormitoryMapper.findAvailableDormitoryId();
                studentMapper.resetDormitoryId(studentId,availableDormitoryId);
                dormitoryMapper.subAvailable(availableDormitoryId);
            }
            dormitoryMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
