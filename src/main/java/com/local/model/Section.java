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
@Table(name = "sections")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Section implements Serializable {
	private Integer sectionId;
	private String sectionName;
	private Integer courseYearId;

	public Section() {
		// TODO Auto-generated constructor stub
	}

	public Section(String sectionName, Integer courseYearId) {
		this.sectionName = sectionName;
		this.courseYearId = courseYearId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "section_id")
	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	@Column(name = "section_name")
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Column(name = "course_year_id")
	public Integer getCourseYearId() {
		return courseYearId;
	}

	public void setCourseYearId(Integer courseYearId) {
		this.courseYearId = courseYearId;
	}
}
