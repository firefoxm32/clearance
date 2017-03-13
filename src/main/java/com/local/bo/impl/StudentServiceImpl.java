/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.bo.impl;

import com.local.dao.StudentDao;
import com.local.model.Student;
import com.local.bo.StudentService;
import com.local.model.StudentDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roudhentel
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void save(Student student) {
        studentDao.save(student);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void update(Student student) {
        studentDao.update(student);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Student findByStudentId(String id) {
        return studentDao.findByStudentId(id);
    }
    
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<StudentDetail> filter(String[] ids) {
        return studentDao.filter(ids);
    }

}
