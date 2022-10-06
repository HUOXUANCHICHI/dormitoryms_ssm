package com.ablaze.mapper;

import com.ablaze.entity.Absent;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/12:30
 */
public interface AbsentMapper {

    /**
     * 学生缺寝记录查询全部
     * @return
     */
    List<Absent> list();

    /**
     * 学生缺寝记录根据楼宇名称查询
     * @param value
     * @return
     */
    List<Absent> searchByBuildingName(String value);

    /**
     * 学生缺勤记录根据宿舍名称查询
     * @param value
     * @return
     */
    List<Absent> searchByDormitoryName(String value);

    /**
     * 学生缺勤记录根据学生名称查询
     * @param value
     * @return
     */
    List<Absent> searchByStudentName(String value);

    /**
     * 缺寝记录增加
     * @param absent
     */
    void save(Absent absent);
}
