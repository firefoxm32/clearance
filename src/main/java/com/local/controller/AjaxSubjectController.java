package com.local.controller;

import com.local.bo.SubjectService;
import com.local.model.Subject;
import com.local.util.ContextManager;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author All
 */
@RestController
@RequestMapping(value = "/api/")
public class AjaxSubjectController {

    @RequestMapping(value = "subjects/{id}", method = RequestMethod.GET)
    public HashMap subjects(@PathVariable("id") int id) {
        HashMap map = new HashMap();
        List<Subject> list = getSubjectService().findByCourseYearOrSubjectId("course_year_id", id);
        map.put("items", list);
        map.put("total", list.size());
        return map;
    }

    @RequestMapping(value = "save-subject", method = RequestMethod.POST)
    public String saveSubject(HttpServletRequest request) {
        System.out.println("D: "+request.getParameter("year_id"));
        int sId = Integer.valueOf(request.getParameter("subject_id"));
        int yId = Integer.valueOf(request.getParameter("year_id"));
        String sName = request.getParameter("subject_name");
        
        Subject subject = new Subject(sName, yId);
        
        if(sId == 0) {
            save(subject);
            return "Added!!";
        }
        return "Updated!!";
    }

    private SubjectService getSubjectService() {
        SubjectService service = (SubjectService) ContextManager.getApplicationContext().getBean("subjectService");
        return service;
    }

    private void save(Subject subject) {
        getSubjectService().save(subject);
    }
    
    private void update(Subject subject){
    }
}
