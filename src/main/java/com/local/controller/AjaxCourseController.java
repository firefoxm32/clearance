/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.CourseService;
import com.local.model.Course;
import com.local.util.ContextManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roudhentel
 */
@RestController
@RequestMapping(value = "/api/")
public class AjaxCourseController {
    @RequestMapping(value = "course/{id}", method = RequestMethod.GET)
    public Course getCourses(@PathVariable("id") int id) {
        CourseService courseBo = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        Course c = courseBo.findByCourseId(id);
        return c;
    }
}
