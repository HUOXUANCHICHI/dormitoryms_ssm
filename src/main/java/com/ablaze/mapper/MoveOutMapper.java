package com.ablaze.mapper;

import com.ablaze.entity.MoveOut;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/24/22:57
 */
public interface MoveOutMapper {

    /**
     * 登出记录查询全部
     * @return
     */
    List<MoveOut> list();

    /**
     * 根据学生姓名查询登出记录
     * @param value
     * @return
     */
    List<MoveOut> searchByStudentName(String value);

    /**
     * 根据宿舍名称查询登出记录
     * @param value
     * @return
     */
    List<MoveOut> searchByDormitoryName(String value);
}
