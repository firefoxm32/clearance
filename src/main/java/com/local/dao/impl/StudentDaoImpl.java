/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Student;
import com.local.dao.StudentDao;
import com.local.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("studentDao")
public class StudentDaoImpl extends CustomHibernateDaoSupport implements StudentDao {

	public void save(Student student) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(student);
	}
}
