package com.ablaze.controller;

import com.ablaze.entity.MoveOut;
import com.ablaze.service.MoveOutService;
import com.ablaze.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: ablaze
 * @Date: 2022/09/21/18:25
 */

@Controller
@RequestMapping("/moveOut")
public class MoveOutController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MoveOutService moveOutList;

    /**
     * 迁出学生登记列表展示
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list",studentService.moveOutList());
        return modelAndView;
    }

    /**
     * 迁出学生登记查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        modelAndView.addObject("list",studentService.searchForMoveOutList(key,value));
        return modelAndView;
    }

    /**
     * 迁出学生登记
     * @param moveOut
     * @return
     */
    @PostMapping("/emigrate")
    public String emigrate(MoveOut moveOut) {
        studentService.moveOut(moveOut);
        return "redirect:/moveOut/list";
    }

    /**
     * 迁出学生记录列表展示
     * @return
     */
    @GetMapping("/record")
    public ModelAndView record() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list",moveOutList.list());
        return modelAndView;
    }

    /**
     * 迁出学生记录查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/recordSearch")
    public ModelAndView recordSearch(String key, String value) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        modelAndView.addObject("list",moveOutList.search(key,value));
        return modelAndView;
    }
}
