/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Section;
import com.local.dao.SectionDao;
import com.local.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("sectionDao")
public class SectionDaoImpl extends CustomHibernateDaoSupport implements SectionDao {

    public void save(Section section) {
        getHibernateTemplate().save(section);
    }

    public void update(Section section) {
        getHibernateTemplate().update(section);
    }

    public List<Section> findByCourseYearId(int id) {
//        List<Section> list = (List<Section>) getHibernateTemplate().find("FROM Section WHERE course_year_id=?", id);
        List<Section> list = (List<Section>) getHibernateTemplate().findByNamedParam("FROM Section WHERE course_year_id=:year_id", "year_id", id);
        return list;
    }
}
