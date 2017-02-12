/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Subject;
import com.local.dao.SubjectDao;
import com.local.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("subjectDao")
public class SubjectDaoImpl extends CustomHibernateDaoSupport implements SubjectDao {

	public void save(Subject subject) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(subject);
	}

	public Subject findByCourseYearOrSubjectId(String field, int id) {
		// TODO Auto-generated method stub
		List list = getHibernateTemplate().find("FROM Subject WHERE " + field + " =?", id);
		return (Subject) list.get(0);
	}

}
