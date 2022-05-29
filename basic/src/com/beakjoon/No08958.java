package com.beakjoon;

import java.util.Scanner;

/**
 *  OX퀴즈
 */
public class No08958 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // OX문제를 입력할 줄 갯수
    int num = sc.nextInt();
    // OX문제의 줄 수만큼 반복문
    while (num > 0) {
      // OX문제의 연속됨을 알기위해 X를 기준으로 배열생성
      String[] chk = sc.next().split("X");
      // 점수가 들어갈 변수 및 변수 초기화
      int score = 0;
      // 1. 배열만큼 반복문을 돌린다.
      // 2. 각 배열의 O의 갯수만큼 한번더 반복문을 돌려서 연속된 점수를 도출
      // 3. 점수를 score에 넣어준다.
      for (int j = 0; j < chk.length; j++) {
        for (int k = 1; k <= chk[j].length(); k++) {
          score += k;
        }
      }
      // 변수 출력
      System.out.println(score);
      // 줄 하나 감소
      num--;
    }
    sc.close();
  }
}
