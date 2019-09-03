package com.backjoon;

import java.util.Scanner;

/**
 *  문자열 반복
 */
public class No02975 {
  // T는 테스트 케이스의 갯수, R은 반복 횟수
  static int T, R;
  // S는 입력받은 문자열
  static String S;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    // T만큼 테스트 케이스를 돌린다.
    for (int i = 0; i < T; i++) {
      R = sc.nextInt();
      S = sc.next();
      // S의 문자열만큼 반복하되, R만큼 글자수를 반복하여 출력
      for (int k = 0; k < S.length(); k++)
        for (int j = 0; j < R; j++)
          System.out.print(S.charAt(k));

      sc.close();
      System.out.println();
    }
  }
}
