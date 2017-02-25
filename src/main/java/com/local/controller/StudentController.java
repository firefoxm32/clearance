/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.CourseService;
import com.local.bo.StudentService;
import com.local.model.Course;
import com.local.model.Student;
import com.local.model.StudentDetail;
import com.local.util.ContextManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author All
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showStudentManagement(Model model){
        model.addAttribute("courses", courses()); 
        return "management-student";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("coursesAttribute", courses());
        model.addAttribute("studentAttribute", student);
        return "form-student";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("studentAttribute") Student student, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bdate = null;
        try {
            bdate = sdf.parse(request.getParameter("birthdate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setBirthday(bdate);
        List<StudentDetail> studentDetails = new ArrayList<>();
        StudentDetail sd = new StudentDetail();
        sd.setCourseId(Integer.valueOf(request.getParameter("select-course")));
        sd.setCourseYearId(Integer.valueOf(request.getParameter("select-year")));
        sd.setSectionId(Integer.valueOf(request.getParameter("select-section")));
        sd.setSemester(request.getParameter("select-sem"));
        sd.setStudent(student);
        studentDetails.add(sd);
        student.setStudentDetails(studentDetails);
        
        StudentService studentService = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        studentService.save(student);
        return "redirect:/student/index";
    }
    
    private List<Course> courses() {
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        List<Course> courses = courseService.viewAllCourses();
        return courses;
    }
}
