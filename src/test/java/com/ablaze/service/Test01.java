package com.ablaze.service;

import com.ablaze.entity.Student;
import com.ablaze.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/20:44
 */
@Service
public class Test01 {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectTest(){
        List<Student> students = studentMapper.list();
        System.out.println(students);

    }

}
