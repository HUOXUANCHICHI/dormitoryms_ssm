package com.ablaze.mapper;

import com.ablaze.entity.Building;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/14/17:28
 */
public interface BuildingMapper {

    /**
     * 楼宇查询全部
     * @return
     */
    List<Building> list();

    /**
     * 楼宇根据名字查询
     * @param value
     * @return
     */
    List<Building> searchByName(String value);

    /**
     * 楼宇根据介绍查询
     * @param value
     * @return
     */
    List<Building> searchByIntroduction(String value);

    /**
     * 楼宇增加
     * @param building
     */
    void save(Building building);

    /**
     * 楼宇更新
     * @param building
     */
    void update(Building building);

    /**
     * 楼宇根据id删除
     * @param id
     */
    void delete(Integer id);
}
