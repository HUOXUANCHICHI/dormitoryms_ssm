package com.ablaze.controller;

import com.ablaze.entity.Dormitory;
import com.ablaze.entity.Student;
import com.ablaze.service.BuildingService;
import com.ablaze.service.DormitoryService;
import com.ablaze.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ablaze
 * @Date: 2022/09/15/23:52
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/listPage")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        PageInfo pageInfos = new PageInfo(dormitoryService.list(page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        modelAndView.addObject("buildingList",buildingService.list(page,size));
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dormitorymanager");
        PageInfo pageInfos = new PageInfo(dormitoryService.search(key, value, page, size));
        modelAndView.addObject("pageInfos",pageInfos);
        modelAndView.addObject("buildingList",buildingService.list(page,size));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Dormitory dormitory) {
        dormitoryService.save(dormitory);
        return "redirect:/dormitory/listPage";
    }

    @PostMapping("/update")
    public String update(Dormitory dormitory) {
        dormitoryService.update(dormitory);
        return "redirect:/dormitory/listPage";
    }

    @PostMapping("/delete")
    public String delete(Integer id) {
        dormitoryService.delete(id);
        return "redirect:/dormitory/listPage";
    }

    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId) {
        List<Dormitory> dormitoryList = dormitoryService.findByBuildingId(buildingId);
        List list = new ArrayList();
        if (dormitoryList.size() > 0) {
            List<Student> studentList = studentService.findByDormitoryId(dormitoryList.get(0).getId());
            list.add(dormitoryList);
            list.add(studentList);
        } else {
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        return list;
    }
}
