/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Course;
import com.local.dao.CourseDao;
import com.local.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("courseDao")
public class CourseDaoImpl extends CustomHibernateDaoSupport implements CourseDao {

    public void save(Course course) {
        getHibernateTemplate().save(course);
    }

    public void update(Course course, int id) {
        getHibernateTemplate().update(course);
    }

    public Course findByCourseId(int id) {
        // TODO Auto-generated method stub
        List list = getHibernateTemplate().findByNamedParam("FROM Course WHERE course_id=:id", "id", id);
        return (Course) list.get(0);
    }

    public List<Course> viewAllCourses() {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        List<Course> list = (List<Course>) getHibernateTemplate().find("FROM Course");
        return list;
    }
}
