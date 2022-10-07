package com.ablaze.service.impl;

import com.ablaze.entity.Building;
import com.ablaze.mapper.BuildingMapper;
import com.ablaze.mapper.DormitoryMapper;
import com.ablaze.mapper.StudentMapper;
import com.ablaze.service.BuildingService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/14/17:36
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Building> list(int page,int size) {
        PageHelper.startPage(page,size);
        return buildingMapper.list();
    }

    @Override
    public List<Building> search(String key, String value,int page,int size) {
        PageHelper.startPage(page,size);
        if ("".equals(value)) {
            return buildingMapper.list();
        }
        List<Building> list = null;
        switch (key) {
            case "name":
                list = buildingMapper.searchByName(value);
                break;
            case "introduction":
                list = buildingMapper.searchByIntroduction(value);
                break;
            default:
        }

        return list;
    }

    @Override
    public void save(Building building) {
        try {
            buildingMapper.save(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Building building) {
        try {
            buildingMapper.update(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        //找到building包含的所有宿舍
        //找到宿舍包含的所有学生
        //学生调换宿舍
        //删除宿舍，删除楼宇
        try {
            List<Integer> dormitoryIdList = dormitoryMapper.findDormitoryIdByBuildingId(id);
            for (Integer dormitoryId : dormitoryIdList) {
                List<Integer> studentIdList = studentMapper.findStudentIdByDormitoryId(dormitoryId);
                for (Integer studentId : studentIdList) {
                    Integer availableDormitoryId = dormitoryMapper.findAvailableDormitoryId();
                    studentMapper.resetDormitoryId(studentId, availableDormitoryId);
                    dormitoryMapper.subAvailable(availableDormitoryId);
                }
                dormitoryMapper.delete(dormitoryId);
            }
            buildingMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
