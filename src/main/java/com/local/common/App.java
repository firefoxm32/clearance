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
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public class App {

    public static void main(String[] args) {
//        new App().sort();
//        new App().getStudentDetails();
//        new App().getStudent();
//        new App().test();
        new App().test2();
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
        for (int i =0; i < str.toCharArray().length; i++){
//            System.out.print(str.charAt(i));
            System.out.print(Integer.valueOf(String.valueOf(str.charAt(i))) + 1);
        }
        System.out.println();
        for (String x : str.split("")) {
            System.out.print(Integer.valueOf(x) + 1);
        }
    }
    
    private void getStudent(){
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        Student student = service.findByStudentId("2013000969");
        
        System.out.println("STUD ID: "+student.getStudentId());
        System.out.println("NAME: "+student.getName());
        System.out.println("EMAIL: "+student.getEmail());
        System.out.println("SEM: "+student.getStudentDetails().get(0).getSemester());
    }
    
    private void getStudentDetails() {
        StudentService service = (StudentService) ContextManager.getApplicationContext().getBean("studentService");
        String[] ids = new String[]{"%2%","%%","%%"};
        List<StudentDetail> list = service.filter(ids); 
        System.out.println("SIZE: "+list.size());
        for(StudentDetail sd : list){
            System.out.println("SEM: "+sd.getSemester());
            System.out.println("NAME: "+sd.getStudent().getName());
            System.out.println("ID: "+sd.getStudent().getStudentId());
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
