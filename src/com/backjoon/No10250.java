package com.backjoon;

import java.util.Scanner;

/**
 * ACM 호텔
 */
public class No10250 {
  public static void main(String args[]) {
    // t는 반복횟수 h는 층수, w는 호실 수, n은 몇번째 손님인지 나타낸다.
    int t, h, w, n;
    // 각각 층수화 호실을 문자로 변환한 값이다.
    String strW, strH;
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      h = sc.nextInt();
      w = sc.nextInt();
      n = sc.nextInt();
      // 계산층과 호실에 기본값을 입력한다.
      int tmpH = 0;
      int tmpW = 1;
      // n을 점차 감소시켜 0이될경우 반복문 종료
      while (n > 0) {
        // 층을 증가시킨다.
        tmpH++;
        // 계산값과 최대 층수가 같거나, 손님의 수가 1명이 아닐경우에만 해당 조건문 통과
        if (tmpH == h&&n != 1) {
          tmpW++;
          tmpH = 0;
        }
        n--;
      }
      strW = String.valueOf(tmpW);
      // 10 미만일경우에는 앞에 0을 붙여준다.
      if (tmpW < 10) {
        strW = "0" + tmpW;
      }
      strH = String.valueOf(tmpH);
      System.out.println(strH + strW);
    }
    sc.close();
  }
}
