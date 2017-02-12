/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.CourseService;
import com.local.bo.SectionService;
import com.local.model.Course;
import com.local.model.Section;
import com.local.util.ContextManager;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roudhentel
 */
@RestController
@RequestMapping("/api")
public class AjaxController {

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public Course getCourses(@PathVariable("id") int id) {
        CourseService courseBo = (CourseService) ContextManager.getApplicationContext().getBean("courseService");
        Course c = courseBo.findByCourseId(id);
        return c;
    }

    @RequestMapping(value = "/sections/{id}", method = RequestMethod.GET)
    public List<Section> sections(@PathVariable("id") int id) {
        SectionService ss = (SectionService) ContextManager.getApplicationContext().getBean("sectionService");
        List<Section> list = ss.findByCourseYearId(id);
        return list;
    }

    @RequestMapping(value = "/save-section", method = RequestMethod.POST)
    public String addSection(HttpServletRequest request) {
        int yearId = Integer.valueOf(request.getParameter("year_id"));
        String sectionName = request.getParameter("section_name");
        int sId = Integer.valueOf(request.getParameter("section_id"));
        SectionService ss = (SectionService) ContextManager.getApplicationContext().getBean("sectionService");
        Section s = new Section();

        if (sId == 0) {
            s.setCourseYearId(yearId);
            s.setSectionName(sectionName);
            ss.save(s);
            return "Added!";
        }
        s.setCourseYearId(yearId);
        s.setSectionId(sId);
        s.setSectionName(sectionName);
        ss.update(s);
        return "Updated!";
    }
}
