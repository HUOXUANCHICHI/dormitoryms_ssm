package com.ablaze.controller;

import com.ablaze.entity.MoveOut;
import com.ablaze.service.MoveOutService;
import com.ablaze.service.StudentService;
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
    @GetMapping("/listPage")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        PageInfo pageInfos = new PageInfo(studentService.moveOutList(page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        return modelAndView;
    }

    /**
     * 迁出学生登记查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/search")
    public ModelAndView search(String key, String value, @RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutregister");
        PageInfo pageInfos = new PageInfo(studentService.searchForMoveOutList(key,value,page,size));
        modelAndView.addObject("pageInfos",pageInfos);
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
        return "redirect:/moveOut/listPage";
    }

    /**
     * 迁出学生记录列表展示
     * @return
     */
    @GetMapping("/record")
    public ModelAndView record(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        PageInfo pageInfos = new PageInfo(moveOutList.list(page,size));
        modelAndView.addObject("pageInfos",pageInfos);
        return modelAndView;
    }

    /**
     * 迁出学生记录查询
     * @param key
     * @param value
     * @return
     */
    @PostMapping("/recordSearch")
    public ModelAndView recordSearch(String key, String value, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moveoutrecord");
        PageInfo pageInfos = new PageInfo(moveOutList.search(key,value, page, size));
        modelAndView.addObject("pageInfos", pageInfos);
        return modelAndView;
    }
}
