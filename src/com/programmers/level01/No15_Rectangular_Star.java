package com.programmers.level01;

import java.util.Scanner;

/**
 * 직사각형 별찍기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class No15_Rectangular_Star {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    for (int i = 0; i < b; i++) {
      for (int j = 0; j < a; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}
