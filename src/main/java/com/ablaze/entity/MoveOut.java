package com.ablaze.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: ablaze
 * @Date: 2022/09/24/21:15
 */

@Data
public class MoveOut {

    /**
     * 学生迁出记录id
     */
    private Integer id;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryId;
    private String dormitoryName;
    /**
     * 迁出理由
     */
    private String reason;
    private String createDate;

}
