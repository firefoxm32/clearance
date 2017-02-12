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

/**
 *
 * @author Roudhentel
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void save(Course course) {
		courseDao.save(course);
	}

	public void update(Course course, int id) {
		courseDao.update(course, id);
	}

	public Course findByCourseId(int id) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseId(id);
	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.viewAllCourses();
	}
}   