package com.ablaze.controller;

import com.ablaze.entity.Building;
import com.ablaze.service.BuildingService;
import com.ablaze.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: ablaze
 * @Date: 2022/09/14/17:36
 */
@Controller
@RequestMapping("/building")
public class BuildingController {


    @Autowired
    private BuildingService buildingService;

    @Autowired
    private DormitoryAdminService dormitoryAdminService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list",buildingService.list());
        modelAndView.addObject("dormitoryAdminList",dormitoryAdminService.list(page,size));
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("buildingmanager");
        modelAndView.addObject("list",buildingService.search(key, value));
        modelAndView.addObject("dormitoryAdminList",dormitoryAdminService.list(page,size));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Building building)   {
        buildingService.save(building);
        return "redirect:/building/list";
    }

    @PostMapping("/update")
    public String update(Building building)   {
        buildingService.update(building);
        return "redirect:/building/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id)   {
        buildingService.delete(id);
        return "redirect:/building/list";
    }

}
