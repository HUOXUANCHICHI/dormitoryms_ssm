package com.ablaze.service;

import com.ablaze.entity.MoveOut;
import com.ablaze.entity.Student;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/21:07
 */
public interface StudentService {

    /**
     * 学生查询全部
     * @return
     */
    List<Student> list();

    /**
     * 学生条件查询
     * @param key
     * @param value
     * @return
     */
    List<Student> search(String key,String value);

    /**
     * 学生增加 对应宿舍减一
     * @param student
     */
    void save(Student student);

    /**
     * 学生更新 若改变宿舍（原宿舍减一新宿舍加一）
     * @param student
     */
    void update(Student student);

    /**
     * 学生删除（用实体类接收应删除学生id和对应宿舍id）并且对应宿舍可用人数增加
     * @param student
     */
    void delete(Student student);

    /**
     * 学生迁出宿舍记录查询全部
     * @return
     */
    List<Student> moveOutList();

    /**
     * 学生迁出列表条件查询
     * @param key
     * @param value
     * @return
     */
    List<Student> searchForMoveOutList(String key,String value);

    /**
     * 根据宿舍id查询学生id,name
     * @param dormitoryId
     * @return
     */
    List<Student> findByDormitoryId(Integer dormitoryId);
    /**
     * 学生迁出
     * @param moveOut
     */
    void moveOut(MoveOut moveOut);

}
