package com.beakjoon;

import java.util.Scanner;

/**
 *  평균은 넘겠지
 */
public class No04344 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 학생 수를 받는다.
    int num = sc.nextInt();
    // 학생 수만큼 for문을 돌린다.
    for (int i = 0; i < num; i++) {
      // 점수 초기화
      int score = 0;
      // 과목 수를 받는다.
      int stuNum = sc.nextInt();
      // n은 평균을 넘는 사람의 수, n 초기화
      int n = 0;
      // 과목 점수들의 배열을 받는다.
      int[] scores = new int[stuNum];
      for (int j = 0; j < stuNum; j++) {
        // 점수의 임시 데이터
        int temp = sc.nextInt();
        // 총합에 더해준다.
        score += temp;
        // 과목 배열에 점수를 넣어준다.
        scores[j] = temp;
      }
      // 점수의 평균을 낸다.
      double d = (double)score/stuNum;
      for (int j = 0; j < scores.length; j++) {
        // 점수의 평균보다 점수가 높을경우 n을 증가
        if (d < scores[j]) {
          n++;
        }
      }
      // n과 과목수의 비율을 구한다.
      System.out.printf("%.3f",(double)n/stuNum*100);
      System.out.println("%");
    }

  }
}
