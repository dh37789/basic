package com.beakjoon;

import java.util.Scanner;

/**
 * 설탕배달
 */
public class No02839 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int sugar = sc.nextInt();
    int f = 0;
    int t = 0;
    while (true) {
      if (sugar % 5 == 0) {
        f = sugar / 5;
        System.out.println(f + t);
        break;
      }
      if (sugar < 3) {
        System.out.println(-1);
        break;
      }
      sugar -= 3;
      t++;
      if (sugar == 0) {
        System.out.println(t + f);
        break;
      }
    }
  }
}
