package com.ablaze.service.impl;

import com.ablaze.entity.DormitoryAdmin;
import com.ablaze.mapper.DormitoryAdminMapper;
import com.ablaze.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/16:21
 */
@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;


    @Override
    public List<DormitoryAdmin> list() {
        return dormitoryAdminMapper.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if ("".equals(key)) {
            return dormitoryAdminMapper.list();
        }

        List<DormitoryAdmin> list = null;
        switch (key) {
            case "username":
                list = dormitoryAdminMapper.searchByUsername(value);
                break;
            case "name":
                list = dormitoryAdminMapper.searchByName(value);
                break;
            case "telephone":
                list = dormitoryAdminMapper.searchByTelephone(value);
                break;
            default:
        }
        return list;

    }


    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        try {
            dormitoryAdminMapper.update(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        try {
            dormitoryAdminMapper.save(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            dormitoryAdminMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
