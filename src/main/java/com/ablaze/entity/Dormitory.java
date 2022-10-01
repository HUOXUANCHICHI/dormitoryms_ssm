package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/23:46
 */
@Data
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private String name;
    private Integer type;
    /**
     * 宿舍可用人数
     */
    private Integer available;
    /**
     * 宿舍固定电话
     */
    private String telephone;
}
