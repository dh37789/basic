package com.beakjoon;

import java.util.Scanner;

/**
 * X보다 작은수
 */
public class No10871 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arrNum = sc.nextInt();
    int num = sc.nextInt();
    int[] nums = new int[arrNum];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = sc.nextInt();
    }
    for (int i = 0; i < nums.length; i++) {
      if (num > nums[i]) {
        System.out.print(nums[i] + " ");
      }
    }
    sc.close();
  }
}
