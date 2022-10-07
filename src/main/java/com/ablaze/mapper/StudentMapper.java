package com.ablaze.mapper;

import com.ablaze.entity.MoveOut;
import com.ablaze.entity.Student;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:20
 */
public interface StudentMapper {
    /**
     * 全部搜索
     * @return
     */
    List<Student> list();


    /**
     * 根据学号查询
     * @param value
     * @return
     */
    List<Student> searchByNumber(String value);

    /**
     * 根据姓名查询
     * @param value
     * @return
     */
    List<Student> searchByName(String value);
    /**
     * 学生增加
     * @param student
     */
    void save(Student student);

    /**
     * 学生更新
     * @param student
     */
    void update(Student student);

    /**
     * 学生删除根据id
     * @param id
     */
    int delete(Integer id);

    /**
     * 学生查询id根据宿舍id
     * @param dormitoryId
     * @return
     */
    List<Integer> findStudentIdByDormitoryId(Integer dormitoryId);

    /**
     * 根据没有宿舍的学生id和可用宿舍id更新学生宿舍至可用宿舍
     * @param studentId 遍历出的没有楼或宿舍的学生id集合中的id
     * @param dormitoryId 查出的可用的宿舍的id
     */
    void resetDormitoryId(Integer studentId,Integer dormitoryId);

    /**
     * 学生迁出列表展示
     * @return
     */
    List<Student> moveOutList();

    /**
     * 根据学号查询学生迁出记录列表
     * @param value
     * @return
     */
    List<Student> searchForMoveOutByNumber(String value);

    /**
     * 根据姓名查询学生迁出记录列表
     * @param value
     * @return
     */
    List<Student> searchForMoveOutByName(String value);

    /**
     * 根据宿舍id查询学生id,name
     * @param dormitoryId
     * @return
     */
    List<Student> findByDormitoryId(Integer dormitoryId);

    /**
     * 更改学生入住状态
     * @param id
     */
    void updateStateById(Integer id);

    /**
     * 迁出学生记录增加
     * @param moveOut
     */
    void moveOut(MoveOut moveOut);


}
