/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.CourseService;
import com.local.model.Course;
import com.local.util.ContextManager;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Roudhentel
 */
@Controller
public class SectionController {

    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public String showManagementSection(Model model) {
         CourseService courseService = (CourseService)
         ContextManager.getApplicationContext().getBean("courseService");
         List<Course> courses = courseService.viewAllCourses();
         model.addAttribute("courses", courses);
        return "management-section";
    }
}
