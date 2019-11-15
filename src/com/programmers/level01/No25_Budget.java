package com.programmers.level01;

import java.util.Arrays;

/**
 * 예산
 * link : https://programmers.co.kr/learn/courses/30/lessons/12982
 */
public class No25_Budget {

  public static void main(String[] args) {
    int[] d = {2, 2, 3, 3};

    int budget = 10;

    System.out.println(solution(d, budget));
  }

  public static int solution(int[] d, int budget) {
    Arrays.sort(d);
    int answer = 0;
    int sum = 0;
    while (budget >= sum && d.length > answer) {
      sum += d[answer];
      if (budget >= sum) {
        answer++;
      }
    }

    return answer;
  }
}
