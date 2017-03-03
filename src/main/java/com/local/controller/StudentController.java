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
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showStudentManagement(Model model) {
        model.addAttribute("courses", courses());
        return "management-student";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("coursesAttribute", courses());
        model.addAttribute("studentAttribute", student);
        model.addAttribute("action", "add");
        return "form-student";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showStudentForm(Model model, @PathVariable("id") String id) {
        Student student = getStudentService().findByStudentId(id);
        model.addAttribute("coursesAttribute", courses());
        model.addAttribute("studentAttribute", student);
        model.addAttribute("birthdate", student.getBirthday());
        model.addAttribute("studentDetail", student.getStudentDetails().get(0));
        model.addAttribute("action", "update");
        return "form-student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("studentAttribute") Student student, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bdate = null;
        if ("".equals(student.getStudentId())) {
            return "form-student";
        }
        if (getStudentService().filter(new String[]{"", "", "", ""}).size() > 0) {
            if (getStudentService().findByStudentId(student.getStudentId()) != null && "add".equals(request.getParameter("save"))) {
                System.out.println("Student ID already exist!!");
                return "form-student";
            }
        }
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
        if ("add".equals(request.getParameter("save"))) {
            addStudent(student);
            return "redirect:/student/index";
        }
//        sd.setStudent(null);
//        sd.setStudent(student);
//        studentDetails.add(sd);
//        student.setStudentDetails(studentDetails);
        String[] ids = {
            "%"+request.getParameter("select-course")+"%",
            "%"+request.getParameter("select-year")+"%",
            "%"+request.getParameter("select-section")+"%",
            "%"+request.getParameter("select-sem")+"%"
        };
        for(String id : ids) {
            System.out.println("ID: "+id);
        }
        if (isExist(ids)) {
            updateStudent(student);
        }
        return "redirect:/student/index";
    }

    private StudentService getStudentService() {
        StudentService studentService = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        return studentService;
    }

    private List<Course> courses() {
        CourseService courseService = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        List<Course> courses = courseService.viewAllCourses();
        return courses;
    }
    
    private boolean isExist(String[] ids) {
        boolean isExist = false;
        System.out.println("SIZE: "+getStudentService().filter(ids).size());
        if (getStudentService().filter(ids).isEmpty()) {
            isExist = true;
        }
        return isExist;
    }
    
    private void addStudent(Student student) {
        getStudentService().save(student);
    }

    private void updateStudent(Student student) {
        getStudentService().update(student);
    }
}
