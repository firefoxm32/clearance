/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Student;
import com.local.dao.StudentDao;
import com.local.model.StudentDetail;
import com.local.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("studentDao")
public class StudentDaoImpl extends CustomHibernateDaoSupport implements StudentDao {

    public void save(Student student) {
        // TODO Auto-generated method stub
        getHibernateTemplate().save(student);
    }

    public List<StudentDetail> filter(Object[] ids) {
        String[] paramNames = {"cd","cyd","sd"};
        String queryString = "FROM StudentDetail WHERE course_id LIKE %:cd% AND course_year_id LIKE %cyd% AND section_id LIKE %sd%";
        List<StudentDetail> list = (List<StudentDetail>) 
                getHibernateTemplate().findByNamedParam(queryString, paramNames, ids);
        return list;
    }

}
