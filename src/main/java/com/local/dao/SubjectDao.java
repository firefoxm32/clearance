/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao;

import com.local.model.Subject;

/**
 *
 * @author Roudhentel
 */
public interface SubjectDao {

	void save(Subject subject);

	Subject findByCourseYearOrSubjectId(String field, int id);
}
