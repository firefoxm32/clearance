/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo;

import com.local.model.Subject;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public interface SubjectService {

	void save(Subject subject);

	List<Subject> findByCourseYearOrSubjectId(String field, int id);
}
