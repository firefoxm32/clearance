/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.dao.impl;

import com.local.model.Student;
import com.local.dao.StudentDao;
import com.local.model.StudentDetail;
import com.local.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roudhentel
 */
@Repository("studentDao")
public class StudentDaoImpl extends CustomHibernateDaoSupport implements StudentDao {

    public void save(Student student) {
        getHibernateTemplate().save(student);
    }

    public void update(Student student) {
        Object[] objects1 = new Object[]{
            student.getName(), student.getGender(),
            student.getBirthday(), student.getContactNo(),
            student.getEmail(), student.getAddress(),
            student.getStudentId()
        };
        String query = "UPDATE Student "
                + "SET name = ?, gender = ?, birthday = ?, "
                + "contact_no = ?, email = ?, address = ? "
                + "WHERE student_id = ?";

        int i = getHibernateTemplate().bulkUpdate(query, objects1);

        if (i == 1) {
            Object[] objects2 = new Object[]{
                student.getStudentDetails().get(0).getSemester(),
                student.getStudentDetails().get(0).getCourseId(),
                student.getStudentDetails().get(0).getCourseYearId(),
                student.getStudentDetails().get(0).getSectionId(),
                student.getStudentId(),
                student.getStudentDetails().get(0).getStudentDetailId()
            };
            String query1 = "UPDATE StudentDetail "
                    + "SET semester = ?, course_id = ?, "
                    + "course_year_id = ?, section_id = ?"
                    + "WHERE student_id = ? AND student_detail_id = ? ";
            getHibernateTemplate().bulkUpdate(query1, objects2);
        }
    }

    public Student findByStudentId(String id) {
        List list = getHibernateTemplate().findByNamedParam("FROM Student WHERE student_id = :sid", "sid", id);
        return (Student) list.get(0);
    }

    public List<StudentDetail> filter(String[] ids) {
        String[] paramNames = {"cd", "cyd", "sd"};
        String queryString = "FROM StudentDetail WHERE course_id LIKE :cd AND course_year_id LIKE :cyd AND section_id LIKE :sd GROUP BY student_id ORDER BY student_id DESC";
        List<StudentDetail> list = (List<StudentDetail>) getHibernateTemplate().findByNamedParam(queryString, paramNames, ids);
        return list;
    }
}
