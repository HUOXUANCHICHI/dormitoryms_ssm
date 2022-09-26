package com.ablaze.service.impl;

import com.ablaze.entity.MoveOut;
import com.ablaze.entity.Student;
import com.ablaze.mapper.DormitoryMapper;
import com.ablaze.mapper.StudentMapper;
import com.ablaze.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/21:08
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    DormitoryMapper dormitoryMapper;

    @Override
    public List<Student> list() {
        return studentMapper.list();
    }

    @Override
    public List<Student> search(String key, String value) {
        if ("".equals(value)) {
            return studentMapper.list();
        }
        List<Student> list = null;
        switch (key) {
            case "number":
                list = studentMapper.searchByNumber(value);
                break;
            case "name":
                list = studentMapper.searchByName(value);
                break;
        }
        return list;
    }

    @Override
    public void save(Student student) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setCreateDate(format.format(date));
        try {
            studentMapper.save(student);
            dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            studentMapper.update(student);
            if (!student.getDormitoryId().equals(student.getOldDormitoryId())) {
                dormitoryMapper.subAvailable(student.getDormitoryId());
                dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        try {
            studentMapper.delete(student.getId());
            dormitoryMapper.addAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> moveOutList() {
        return studentMapper.moveOutList();
    }

    @Override
    public List<Student> searchForMoveOutList(String key, String value) {
        if ("".equals(value)) {
            return studentMapper.moveOutList();
        }
        List<Student> list = null;
        switch (key) {
            case "number":
                list = studentMapper.searchForMoveOutByNumber(value);
                break;
            case "name":
                list = studentMapper.searchForMoveOutByName(value);
                break;
        }
        return list;
    }

    @Override
    public List<Student> findByDormitoryId(Integer dormitoryId) {
        return studentMapper.findByDormitoryId(dormitoryId);
    }

    @Override
    public void moveOut(MoveOut moveOut) {
        try {
            dormitoryMapper.addAvailable(moveOut.getDormitoryId());
            studentMapper.updateStateById(moveOut.getStudentId());
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            moveOut.setCreateDate(format.format(date));
            studentMapper.moveOut(moveOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
