package com.backjoon;

import java.util.Scanner;

/**
 *  2007년
 */
public class No01924 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 각 월의 일자 수
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] day = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
    int x = sc.nextInt(); // x 입력
    int y = sc.nextInt(); // y 입력
    int totalday = y; // 총 일값에 현재 날짜(일)값을 넣어준다.
    // 나머지 지나간 월들의 날짜들을 넣어준다.
    for (int i = 0; i < x; i++) {
      if (i < x-1)
        totalday += days[i];
    }
    // 총 일수를 7로 나눈후에 나머지값으로 요일을 찾는다.
    System.out.println(day[totalday%7]);
    sc.close();
  }
}
