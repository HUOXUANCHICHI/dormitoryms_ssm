package com.ablaze.service;

import com.ablaze.entity.Absent;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/9:59
 */
public interface AbsentService {


    /**
     * 学生缺寝记录查询全部
     * @return
     */
    List<Absent> list(int page, int size);

    /**
     * 学生缺勤记录条件查询
     * @param key
     * @param value
     * @return
     */
    List<Absent> search(String key, String value, int page, int size);

    /**
     * 学生缺寝记录增加
     * @param absent
     */
    void save(Absent absent);

}
