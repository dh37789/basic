package com.programmers.level01;

/**
 * 자릿수 더하기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class No23_Add_Digits {

  public static void main(String[] args) {
    int n = 256;

    System.out.println(solution(n));
  }

  public static int solution(int n) {
    int answer = 0;

    while (n != 0) {
      answer += n % 10;
      n = n / 10;
    }

    return answer;
  }
}
