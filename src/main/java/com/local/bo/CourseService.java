/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo;

import com.local.model.Course;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public interface CourseService {
	void save(Course course);

	void update(Course course, int id);

	Course findByCourseId(int id);

	List<Course> viewAllCourses();
}

