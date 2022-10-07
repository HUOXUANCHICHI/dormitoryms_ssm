package com.ablaze.service;

import com.ablaze.entity.Dormitory;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/10/0:01
 */
public interface DormitoryService {

    /**
     * 可使用宿舍查询全部
     * @return
     */
    List<Dormitory> availableList();

    /**
     * 宿舍查询全部
     * @return
     */
    List<Dormitory> list(int page, int size);

    /**
     * 宿舍条件查询
     * @param key
     * @param value
     * @return
     */
    List<Dormitory> search(String key, String value, int page, int size);

    /**
     * 根据楼宇id查询宿舍id,name
     * @param buildingId
     * @return
     */
    List<Dormitory> findByBuildingId(Integer buildingId);

    /**
     * 宿舍增加
     * @param dormitory
     */
    void save(Dormitory dormitory);

    /**
     * 宿舍更新
     * @param dormitory
     */
    void update(Dormitory dormitory);

    /**
     * 宿舍根据id删除
     * @param id
     */
    void delete(Integer id);
}
