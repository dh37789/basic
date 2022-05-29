package com.programmers.level01;

import java.util.Arrays;

/**
 * 같은 숫자는 싫어
 * link : https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class No02_No_Same_Number {

  public static void main(String[] args) {
     int[] arr = {1, 1, 3, 3, 0, 1, 1};

    System.out.println(Arrays.toString(solution(arr)));
  }
  public static int[] solution(int []arr) {
    int[] answer = {};
    int[] tempArr = new int[arr.length];
    int chkNum = arr[0];
    int cnt = 0;
    tempArr[0] = chkNum;
    for (int i = 1; i < arr.length; i++) {
      if (chkNum == arr[i]) {
        continue;
      }else {
        cnt++;
        chkNum = arr[i];
        tempArr[cnt] = chkNum;
      }
    }
    answer = new int[cnt+1];
    for (int i = 0; i < cnt+1; i++) {
      answer[i] = tempArr[i];
    }
    return answer;
  }
}
