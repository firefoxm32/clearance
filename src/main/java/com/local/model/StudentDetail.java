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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Roudhentel
 */
@Entity()
@Table(name = "student_details")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class StudentDetail implements Serializable {
	private Integer studentDetailId;
	private Integer sectionId;
	private Integer courseId;
	private Integer courseYearId;
	private String semester;
	private Student student;

        @ManyToOne
        @JoinColumn(name = "student_id", nullable = true, insertable = true, updatable = true)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_detail_id")
	public Integer getStudentDetailId() {
		return studentDetailId;
	}

	public void setStudentDetailId(Integer studentDetailId) {
		this.studentDetailId = studentDetailId;
	}

	@Column(name = "section_id")
	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	@Column(name = "course_id")
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_year_id")
	public Integer getCourseYearId() {
		return courseYearId;
	}

	public void setCourseYearId(Integer courseYearId) {
		this.courseYearId = courseYearId;
	}

	@Column(name = "semester")
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
}
