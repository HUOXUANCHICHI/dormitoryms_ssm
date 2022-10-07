package com.ablaze.controller;

import com.ablaze.entity.Student;
import com.ablaze.service.DormitoryService;
import com.ablaze.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


/*
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        modelAndView.addObject("list", studentService.list(page,size));
        modelAndView.addObject("dormitoryList", dormitoryService.availableList());
        return modelAndView;
    }
*/

    @GetMapping("/listPage")
    public ModelAndView listPage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        PageInfo pageInfos = new PageInfo(studentService.list(page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        modelAndView.addObject("dormitoryList", dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentmanager");
        PageInfo pageInfos = new PageInfo(studentService.search(key, value, page, size));
        modelAndView.addObject("pageInfos", pageInfos);
        modelAndView.addObject("dormitoryList", dormitoryService.availableList());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:/student/listPage";
    }

    @PostMapping("/update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student/listPage";
    }

    @PostMapping("/delete")
    public String delete(Student student){
        studentService.delete(student);
        return "redirect:/student/listPage";
    }

    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<Student> findByDormitoryId(Integer dormitoryId) {
         return studentService.findByDormitoryId(dormitoryId);
    }
}
