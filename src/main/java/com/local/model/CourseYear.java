/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Roudhentel
 */
@Entity
@Table(name = "course_year")
public class CourseYear implements Serializable {

	private Integer id;
	private String yearName;
	private Course course;

	public CourseYear() {
		// TODO Auto-generated constructor stub
	}

	public CourseYear(String yearName) {
		// TODO Auto-generated constructor stub
		this.yearName = yearName;
	}

	@ManyToOne
	@JoinColumn(name = "course_id", insertable = true, updatable = true, nullable = true)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_year_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "year_name", nullable = true)
	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
}
