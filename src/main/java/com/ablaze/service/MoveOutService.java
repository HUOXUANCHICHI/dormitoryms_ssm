package com.ablaze.service;

import com.ablaze.entity.MoveOut;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/25/11:03
 */
public interface MoveOutService {

    /**
     * 学生迁出记录查询全部
     * @return
     */
    List<MoveOut> list(int page, int size);

    /**
     * 学生迁出记录条件查询
     * @param key
     * @param value
     * @return
     */
    List<MoveOut> search(String key, String value,int page, int size);
}
