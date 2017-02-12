/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Roudhentel
 */
@Entity
@Table(name = "subjects")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Subject implements Serializable {

	private Integer subjectId;
	private String subjectName;
	private Integer courseYearId;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String subjectName, Integer courseYearId) {
		this.subjectName = subjectName;
		this.courseYearId = courseYearId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id")
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name = "subject_name")
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Column(name = "course_year_id")
	public Integer getCourseYearId() {
		return courseYearId;
	}

	public void setCourseYearId(Integer courseYearId) {
		this.courseYearId = courseYearId;
	}
}
