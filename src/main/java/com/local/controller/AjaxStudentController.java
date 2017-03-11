/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.StudentService;
import com.local.model.StudentDetail;
import com.local.util.ContextManager;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author All
 */
@RestController
@RequestMapping(value = "/api/")
public class AjaxStudentController {
    
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public HashMap studentDetails(HttpServletRequest request){
        HashMap map = new HashMap();
        String[] ids = {
            "%"+request.getParameter("course_id")+"%",
            "%"+request.getParameter("year_id")+"%",
            "%"+request.getParameter("section_id")+"%"
//                ,
//            "%"+request.getParameter("semester")+"%"
        };
        List<StudentDetail> list = getStudentService().filter(ids);
        map.put("items", list);
        map.put("total", list.size());
        return map;
    }
    
    private StudentService getStudentService() {
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        return service;
    }
}
