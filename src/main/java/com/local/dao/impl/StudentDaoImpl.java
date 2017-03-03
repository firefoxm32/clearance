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
        getHibernateTemplate().save(student);
    }

    public void update(Student student) {
        getHibernateTemplate().saveOrUpdate(student);
    }
    
    public Student findByStudentId(String id) {
        List list = getHibernateTemplate().findByNamedParam("FROM Student WHERE student_id = :sid", "sid", id);
        return (Student) list.get(0) ;
    }

    public List<StudentDetail> filter(String[] ids) {
        String[] paramNames = {"cd","cyd","sd","sem"};
        String queryString = "FROM StudentDetail WHERE course_id LIKE :cd AND course_year_id LIKE :cyd AND section_id LIKE :sd AND semester LIKE :sem";
        List<StudentDetail> list = (List<StudentDetail>) 
                getHibernateTemplate().findByNamedParam(queryString, paramNames, ids);
        return list;
    }
}
