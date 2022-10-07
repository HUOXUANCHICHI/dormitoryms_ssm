package com.ablaze.service.impl;

import com.ablaze.entity.MoveOut;
import com.ablaze.mapper.MoveOutMapper;
import com.ablaze.service.MoveOutService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/25/11:04
 */
@Service
public class MoveOutServiceImpl implements MoveOutService {

    @Autowired
    private MoveOutMapper moveOutMapper;

    @Override
    public List<MoveOut> list(int page, int size) {
        PageHelper.startPage(page,size);
        return moveOutMapper.list();
    }

    @Override
    public List<MoveOut> search(String key, String value, int page, int size) {
        PageHelper.startPage(page,size);
        if ("".equals(value)) {
            return moveOutMapper.list();
        }
        List<MoveOut> list = null;
        switch (key) {
            case "studentName":
                list = moveOutMapper.searchByStudentName(value);
                break;
            case "dormitoryName":
                list = moveOutMapper.searchByDormitoryName(value);
                break;
            default:
        }
        return list;
    }
}
