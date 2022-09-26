package com.ablaze.service;

import com.ablaze.entity.DormitoryAdmin;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/16:20
 */
public interface DormitoryAdminService {

    /**
     * 宿舍管理员信息查询全部
     * @return
     */
    List<DormitoryAdmin> list();

    /**
     * 宿舍管理员条件查询
     * @param key
     * @param value
     * @return
     */
    List<DormitoryAdmin> search(String key,String value);

    /**
     * 宿舍管理员增加
     * @param dormitoryAdmin
     */
    void save(DormitoryAdmin dormitoryAdmin);

    /**
     * 宿舍管理员更新
     * @param dormitoryAdmin
     */
    void update(DormitoryAdmin dormitoryAdmin);

    /**
     * 宿舍管理员根据id删除
     * @param id
     */
    void delete(Integer id);
}
