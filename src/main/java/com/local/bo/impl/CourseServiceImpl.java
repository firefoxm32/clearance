/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo.impl;

import com.local.dao.CourseDao;
import com.local.model.Course;
import com.local.bo.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roudhentel
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
        
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
        @Transactional(readOnly = false, rollbackFor = Exception.class)
	public void save(Course course) {
		courseDao.save(course);
	}
        @Transactional(readOnly = false, rollbackFor = Exception.class)
	public void update(Course course, int id) {
		courseDao.update(course, id);
	}
        @Transactional(readOnly = false, rollbackFor = Exception.class)
	public Course findByCourseId(int id) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseId(id);
	}
        @Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.viewAllCourses();
	}
}   