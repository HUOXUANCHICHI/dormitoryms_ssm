package com.ablaze.controller;

import com.ablaze.entity.Student;
import com.ablaze.service.DormitoryService;
import com.ablaze.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:16
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DormitoryService dormitoryService;


    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", studentService.list());
        modelAndView.addObject("dormitoryList", dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", studentService.search(key, value));
        modelAndView.addObject("dormitoryList", dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }

    @PostMapping("/update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student/list";
    }

    @PostMapping("/delete")
    public String delete(Student student){
        studentService.delete(student);
        return "redirect:/student/list";
    }

    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<Student> findByDormitoryId(Integer dormitoryId) {
         return studentService.findByDormitoryId(dormitoryId);
    }
}