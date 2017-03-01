/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.model.Course;
import com.local.model.CourseYear;
import com.local.bo.CourseService;
import com.local.util.ContextManager;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Roudhentel
 */
@Controller
public class CourseController {

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showManagementCourse(Model model) {
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        List<Course> courses = courseService.viewAllCourses();
        model.addAttribute("courses", courses);
        return "management-course";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.GET)
    public String showCourseFormAdd(Model model) {
        Course course = new Course();
        model.addAttribute("courseAttribute", course);
        model.addAttribute("action", "add");
        return "form-course";
    }

    @RequestMapping(value = "/course/{course_id}", method = RequestMethod.GET)
    public String showCourseFormByCourseId(Model model, @PathVariable("course_id") int id) {
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        Course course = courseService.findByCourseId(id);
        model.addAttribute("courseAttribute", course);
        model.addAttribute("action", "view");
        return "form-course";
    }

    @RequestMapping(value = "/course/update/{course_id}", method = RequestMethod.GET)
    public String showCourseFormUpdate(Model model, @PathVariable("course_id") int id) {
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        Course course = courseService.findByCourseId(id);
        model.addAttribute("courseAttribute", course);
        model.addAttribute("action", "update");
        return "form-course";
    }

    @RequestMapping(value = "/save-course", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("courseAttribute") Course course, HttpServletRequest request) {
        int years = Integer.valueOf(request.getParameter("years"));
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        List<CourseYear> list = new ArrayList<>();

        if (course.getCourseId() == null) {
            for (int i = 0; i < years; i++) {
                CourseYear courseYear = new CourseYear("" + (i + 1));
                courseYear.setCourse(course);
                list.add(courseYear);
            }
            course.setCourseYears(list);
            courseService.save(course);
            return "redirect:/";
        }
        Course courses1 = course = courseService.findByCourseId(course.getCourseId());

        for (CourseYear courseYear : courses1.getCourseYears()) {
            courseYear.setCourse(null);
            list.add(courseYear);
        }

        for (int i = 0; i < years; i++) {
            CourseYear courseYear = new CourseYear("" + (i + 1));
            courseYear.setCourse(course);
            list.add(courseYear);
        }

        course.setCourseYears(list);
        courseService.update(course, 3);
        return "redirect:/";
    }

    // -----ADD
}
