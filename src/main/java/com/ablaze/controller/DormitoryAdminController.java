package com.ablaze.controller;

import com.ablaze.entity.DormitoryAdmin;
import com.ablaze.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/16:04
 */
@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {

    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",dormitoryAdminService.list());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",dormitoryAdminService.search(key, value));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin) {
        dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin) {
        dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id){
        dormitoryAdminService.delete(id);
        return "redirect:/dormitoryAdmin/list";
    }
}
