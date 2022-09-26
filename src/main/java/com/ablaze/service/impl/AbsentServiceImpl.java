package com.ablaze.service.impl;

import com.ablaze.entity.Absent;
import com.ablaze.mapper.AbsentMapper;
import com.ablaze.service.AbsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/9:59
 */

@Service
public class AbsentServiceImpl implements AbsentService {

    @Autowired
    private AbsentMapper absentMapper;

    @Override
    public List<Absent> list() {
        return absentMapper.list();
    }

    @Override
    public List<Absent> search(String key, String value) {
        if ("".equals(value)) {
            return absentMapper.list();
        }
        List<Absent> list = null;
        switch (key){
            case "buildingName":
                list = absentMapper.searchByBuildingName(value);
                break;
            case "dormitoryName":
                list = absentMapper.searchByDormitoryName(value);
                break;
            default:
        }
        return list;
    }

    @Override
    public void save(Absent absent) {
        try {
            absentMapper.save(absent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
