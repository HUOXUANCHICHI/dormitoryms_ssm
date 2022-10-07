package com.ablaze.controller;

import com.ablaze.entity.DormitoryAdmin;
import com.ablaze.service.DormitoryAdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*@GetMapping("/list")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list",dormitoryAdminService.list(page,size));
        return modelAndView;
    }*/

    @GetMapping("/listPage")
    public ModelAndView listPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        PageInfo pageInfos = new PageInfo(dormitoryAdminService.list(page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        PageInfo pageInfos = new PageInfo(dormitoryAdminService.search(key, value,page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin) {
        dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/listPage";
    }

    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin) {
        dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/listPage";
    }

    @PostMapping("/delete")
    public String delete(Integer id){
        dormitoryAdminService.delete(id);
        return "redirect:/dormitoryAdmin/listPage";
    }
}
