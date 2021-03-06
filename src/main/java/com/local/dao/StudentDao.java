/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao;

import com.local.model.Student;
import com.local.model.StudentDetail;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public interface StudentDao {

	void save(Student student);
        
        void update(Student student);
        
        Student findByStudentId(String id);
        
        List<StudentDetail> filter(String[] ids);
}

