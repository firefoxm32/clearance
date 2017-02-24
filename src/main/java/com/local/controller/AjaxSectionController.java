/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.controller;

import com.local.bo.SectionService;
import com.local.model.Section;
import com.local.util.ContextManager;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author All
 */
@RestController
@RequestMapping(value = "/api/")
public class AjaxSectionController {

    @RequestMapping(value = "sections/{id}", method = RequestMethod.GET)
    public HashMap sections(@PathVariable("id") int id) {
        HashMap map = new HashMap();
        List<Section> list = getSectionService().findByCourseYearId(id);
        map.put("items", list);
        map.put("total", list.size());
        return map;
    }

    @RequestMapping(value = "save-section", method = RequestMethod.POST)
    public String saveSection(HttpServletRequest request) {
        int yearId = Integer.valueOf(request.getParameter("year_id"));
        String sectionName = request.getParameter("section_name");
        int sId = Integer.valueOf(request.getParameter("section_id"));

        Section section = new Section(sectionName, yearId);

        if (sId == 0) {
            save(section);
            return "Added!";
        }
        section.setSectionId(sId);
        update(section);
        return "Updated!";
    }

    private SectionService getSectionService() {
        SectionService service = (SectionService) ContextManager.getApplicationContext().getBean("sectionService");
        return service;
    }

    private void save(Section section) {
        getSectionService().save(section);
    }

    private void update(Section section) {
        getSectionService().update(section);
    }
}
