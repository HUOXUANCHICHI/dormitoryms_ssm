package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/26/10:03
 */

@Data
public class Absent {

    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private Integer dormitoryId;
    private String dormitoryName;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryAdminId;
    private String dormitoryAdminName;
    private String createDate;
    private String reason;

}


