package com.ablaze.mapper;

import com.ablaze.entity.Dormitory;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/23:56
 */
public interface DormitoryMapper {

    /**
     * 可使用宿舍查询全部
     * @return
     */
    List<Dormitory> availableList();

    /**
     * 减少课使用宿舍
     * @param id
     */
    void subAvailable(Integer id);

    /**
     * 增加可使用宿舍
     * @param id
     */
    void addAvailable(Integer id);

    /**
     * 根据楼宇id查询宿舍id
     * @param buildingId
     * @return
     */
    List<Integer> findDormitoryIdByBuildingId(Integer buildingId);

    /**
     * 查询可使用宿舍的id
     * @return
     */
    Integer findAvailableDormitoryId();

    /**
     * 根据楼宇id查询宿舍id,name
     * @param buildingId
     * @return
     */
    List<Dormitory> findByBuildingId(Integer buildingId);

    /**
     * 宿舍根据id删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 宿舍查询全部
     * @return
     */
    List<Dormitory> list();

    /**
     * 宿舍根据名称查询
     * @param value
     * @return
     */
    List<Dormitory> searchByName(String value);

    /**
     * 宿舍根据电话查询
     * @param value
     * @return
     */
    List<Dormitory> searchByTelephone(String value);

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

}
