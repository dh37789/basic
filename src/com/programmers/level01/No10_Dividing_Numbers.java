package com.programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 나누어 떨어지는 숫자
 * links : https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class No10_Dividing_Numbers {

  public static void main(String[] args) {
    int arr[] = {5, 9, 7, 10};
    int divisor = 52;

    System.out.println(Arrays.toString(solution(arr, divisor)));
  }

  public static int[] solution(int[] arr, int divisor) {
    List<Integer> div = new ArrayList<>();
    int n = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        n++;
      }
    }

    int[] answer;
    if (n == 0) {
      answer = new int[1];
      answer[0] = -1;
    } else {
      answer = new int[n];
      for (int i = 0; i < n; i++) {
        answer[i] = div.get(i);
      }
    }
    return answer;
  }
}
