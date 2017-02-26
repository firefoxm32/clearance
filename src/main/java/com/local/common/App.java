/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.common;

import com.local.bo.StudentService;
import com.local.model.StudentDetail;
import com.local.util.ContextManager;
import java.util.List;

/**
 *
 * @author Roudhentel
 */
public class App {

    public static void main(String[] args) {
//        new App().sort();
        new App().getStudentDetails();
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
