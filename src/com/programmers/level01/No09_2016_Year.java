package com.programmers.level01;

/**
 * 2016년
 * link : https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class No09_2016_Year {

  public static void main(String[] args) {
    int a = 5;
    int b = 24;

    System.out.println(solution(a, b));
  }

  public static String solution(int a, int b) {

    int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int days = 0;

    for (int i = 0; i < a - 1; i++) {
      days += month[i];
    }
    days += b;

    String answer = day[days % 7];
    return answer;
  }

}
