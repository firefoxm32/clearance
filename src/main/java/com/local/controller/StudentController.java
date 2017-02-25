/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.CourseService;
import com.local.model.Course;
import com.local.model.Student;
import com.local.util.ContextManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author All
 */
@Controller
public class StudentController {
    
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudentManagement(Model model){
        List<StudentController> list = new ArrayList<>();
        model.addAttribute("students", list);
        return "management-student";
    }
    
    @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String showStudentForm(Model model){
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        Student student = new Student();
        List<Course> courses = courseService.viewAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("student", student);
        return "form-student";
    }
}
