package com.ablaze.mapper;

import com.ablaze.entity.DormitoryAdmin;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/16:11
 */
public interface DormitoryAdminMapper {

    /**
     * 宿舍管理员信息查询全部
     * @return
     */
    List<DormitoryAdmin> list();

    /**
     * 宿舍管理员根据用户名查询
     * @param value
     * @return
     */
    List<DormitoryAdmin> searchByUsername(String value);

    /**
     * 宿舍管理员根据真实姓名查询
     * @param value
     * @return
     */
    List<DormitoryAdmin> searchByName(String value);

    /**
     * 宿舍管理员根据电话查询
     * @param value
     * @return
     */
    List<DormitoryAdmin> searchByTelephone(String value);

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
     * @param id 宿舍管理员id
     */
    void delete(Integer id);

    DormitoryAdmin findByUserName(String username);
}
