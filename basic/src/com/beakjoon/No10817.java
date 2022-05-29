package com.beakjoon;

import java.util.Scanner;

/**
 *  세수
 */
public class No10817 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] num = new int[3];
    num[0] = sc.nextInt();
    num[1] = sc.nextInt();
    num[2] = sc.nextInt();
    int temp;
    for (int i = 0; i < num.length; i++) {
      for (int j = 0; j < num.length; j++) {
        if (num[i] > num[j]) {
          temp = num[i];
          num[i] = num[j];
          num[j] = temp;
        }
      }
    }
    System.out.println(num[1]);
    sc.close();
  }
}
