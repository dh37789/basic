package com.programmers.level02;

import java.util.Arrays;

/**
 * 최대값과 최소값
 * link : https://programmers.co.kr/learn/courses/30/lessons/12939
 */
public class No01_Max_And_Min_Values {

  public static void main(String[] args) {
    String s = "-1 -2 -3 -4";
    System.out.println(solution(s));
  }

  public static String solution(String s) {
    String answer = "";
    int max, min;
    int size = s.split(" ").length;
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = Integer.parseInt(s.split(" ")[i]);
    }

    Arrays.sort(arr);

    answer = arr[0] + " " + arr[size - 1];

    return answer;
  }
}
