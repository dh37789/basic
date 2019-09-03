package com.backjoon;

import java.util.Scanner;

/**
 * 상수
 */
public class No02908 {

  // 숫자 A, B를 선언해준다.
  static int A, B;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    A = sc.nextInt();
    B = sc.nextInt();
    sc.close();
    // A, B를 뒤집어주는 메서드를 만든다.
    A = changeNum(A);
    B = changeNum(B);
    if (A > B) {
      System.out.println(A);
    } else {
      System.out.println(B);
    }
  }

  // 각각의 문자열을 뒤집어서 재결합하는 메서드
  private static int changeNum(int num) {
    String str = String.valueOf(num);
    str = String.valueOf(str.charAt(2)) + String.valueOf(str.charAt(1)) +
        String.valueOf(str.charAt(0));
    return Integer.parseInt(str);
  }
}
