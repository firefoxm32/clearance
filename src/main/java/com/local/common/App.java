/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.common;

import com.local.bo.StudentService;
import com.local.model.Student;
import com.local.model.StudentDetail;
import com.local.util.ContextManager;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public class App {

    public static void main(String[] args) throws ParseException {
//        new App().sort();
//        new App().getStudentDetails();
//        new App().getStudent();
//        new App().test();
//        new App().test2();
//        new App().update();
        new App().test3();
    }

    private void update() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        Student student = new Student();
        student.setStudentId("2013000969");
        student.setName("Erick V. Laxamana");
        student.setGender("M");
        student.setBirthday(sdf.parse("1996-10-03"));
        student.setContactNo("09268458369");
        student.setEmail("erick.laxamana03@gmail.com");
        student.setAddress("Lagundi Mexico");
        List<StudentDetail> list = new ArrayList<>();
        StudentDetail sd = new StudentDetail();
        sd.setStudentDetailId(1);
        sd.setSemester("1st Sem");
        sd.setCourseId(1);
        sd.setCourseYearId(1);
        sd.setSectionId(1);
        list.add(sd);
        student.setStudentDetails(list);
        service.update(student);
    }

    private void test() {
        String str1 = "1111111111111111111"; //19 digits
        String str2 = "11111111111111111111"; //20 digits
        BigInteger bi = new BigInteger(str2);
        System.out.println(Long.valueOf(str1));
        System.out.println(bi);
    }

    private void test2() {
        String str = "2234";
        for (int i = 0; i < str.toCharArray().length; i++) {
//            System.out.print(str.charAt(i));
            System.out.print(Integer.valueOf(String.valueOf(str.charAt(i))) + 1);
        }
        System.out.println();
        for (String x : str.split("")) {
            System.out.print(Integer.valueOf(x) + 1);
        }
    }

    private void test3() {
        int[] idx1 = new int[]{1, 1, 2, 3, 4};
        for (int i : idx1) {
            for (int x = 0; x <= i; x++) {
                if (i != 4) {
                    System.out.print((x != 0) ? " *" : " ");
                } else {
                    System.out.print((x != 4) ? "* " : "");
                }
            }
            System.out.println("");
        }
//        System.out.println(" *");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(" *");
//            }
//            System.out.println(" ");
//        }
//        System.out.println("* * * * *");
    }

    private void getStudent() {
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        Student student = service.findByStudentId("2013000969");

        System.out.println("STUD ID: " + student.getStudentId());
        System.out.println("NAME: " + student.getName());
        System.out.println("EMAIL: " + student.getEmail());
        System.out.println("SEM: " + student.getStudentDetails().get(0).getSemester());
    }

    private void getStudentDetails() {
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        String[] ids = new String[]{"%1%", "%1%", "%1%"};
        List<StudentDetail> list = service.filter(ids);
        System.out.println("SIZE: " + list.size());
        for (StudentDetail sd : list) {
            System.out.println("SEM: " + sd.getSemester());
            System.out.println("NAME: " + sd.getStudent().getName());
            System.out.println("ID: " + sd.getStudent().getStudentId());
        }
    }

    private int[] nums = new int[]{5, 1, -8, 4, 2};

    private void sort() {
        for (int i = 0; i < nums.length; i++) {
            secondLoop(nums.length);
        }

        display();
    }

    private void secondLoop(int length) {
        for (int x = 0; x < length - 1; x++) {
            condition(x);
        }
    }

    private void condition(int x) {
        int temp;
        if (nums[x] > nums[x + 1]) {
            temp = nums[x];
            nums[x] = nums[x + 1];
            nums[x + 1] = temp;
        }
    }

    private void display() {
        for (int b : nums) {
            System.out.print(b + " ");
        }
    }
}
