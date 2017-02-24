/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo.impl;

import com.local.dao.SubjectDao;
import com.local.model.Subject;
import com.local.bo.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roudhentel
 */
@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao subjectDao;
        
        @Transactional(readOnly = false, rollbackFor = Exception.class)
	public void save(Subject subject) {
		// TODO Auto-generated method stub
		subjectDao.save(subject);
	}
        @Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Subject> findByCourseYearOrSubjectId(String field, int id) {
		// TODO Auto-generated method stub
		return subjectDao.findByCourseYearOrSubjectId(field, id);
	}
}
