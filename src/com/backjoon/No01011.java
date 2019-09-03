package com.backjoon;

import java.util.Scanner;

/**
 * Fly me to the Alpha Centauri
 */
public class No01011 {
  public static void main(String args[]){
    // 공식 참조...
    long t, x, y, n;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      x = sc.nextLong();
      y = sc.nextLong();
      n = y - x;
      long r = (long)Math.sqrt(n);
      n = n - (r*r);
      n = (long)Math.ceil((double)n/r);
      System.out.println(n+(2*r-1L));
    }
    sc.close();
  }
}
