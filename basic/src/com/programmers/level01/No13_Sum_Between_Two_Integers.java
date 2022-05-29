package com.programmers.level01;

/**
 * 두 정수 사이의 합
 * link : https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class No13_Sum_Between_Two_Integers {

  public static void main(String[] args) {
    int a = 3;
    int b = 5;
    System.out.println(solution(a, b));
  }

  public static long solution(int a, int b) {
    long answer = 0;
    int min = 0;
    int max = 0;
    if (a <= b) {
      min = a;
      max = b;
    } else {
      min = b;
      max = a;
    }
    for (int i = min; i <= max; i++) {
      answer += (long) i;
    }
    return answer;
  }

}
