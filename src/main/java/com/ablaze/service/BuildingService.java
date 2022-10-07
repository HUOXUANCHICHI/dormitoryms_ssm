package com.ablaze.service;

import com.ablaze.entity.Building;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/14/17:35
 */
public interface BuildingService {

    /**
     * 楼宇查询全部
     * @return
     */
    List<Building> list(int page,int size);

    /**
     * 楼宇条件查询
     * @param key
     * @param value
     * @return
     */
    List<Building> search(String key,String value,int page,int size);

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
