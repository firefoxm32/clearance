/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo.impl;

import com.local.dao.SectionDao;
import com.local.model.Section;
import com.local.bo.SectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roudhentel
 */
@Service("sectionService")
@Transactional
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionDao sectionDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Section section) {
        sectionDao.save(section);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void update(Section section) {
        sectionDao.update(section);
    }

    public List<Section> findByCourseYearId(int id) {
        return sectionDao.findByCourseYearId(id);
    }
}
