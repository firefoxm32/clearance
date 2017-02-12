/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.local.common;

/**
 *
 * @author Roudhentel
 */
public class App {

    public static void main(String[] args) {
        new App().sort();
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
