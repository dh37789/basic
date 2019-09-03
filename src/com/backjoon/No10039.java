package com.backjoon;

import java.util.Scanner;

/**
 * 평균점수
 */
public class No10039 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 점수가 들어갈 배열생성
    int[] score = new int[5];
    // 점수가 40미만일경우에는 40을 넣는다.
    for (int i = 0; i < score.length; i++) {
      int temp = sc.nextInt();
      if (temp < 40) {
        score[i] = 40;
      }else{
        score[i] = temp;
      }
    }
    // 점수의 총합
    int totalScore = 0;
    for (int i = 0; i < score.length; i++) {
      totalScore += score[i];
    }
    System.out.println(totalScore/5);
  }
}
