package com.programmers.level01;

import java.util.Arrays;

public class No003_Kth_Number {

  public static void main(String[] args) {
    int[] array = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    int[] and = solution(array, commands);
    for (int a : and) {
      System.out.println(a);
    }
  }

  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int size = (commands[i][1] - commands[i][0]) + 1;
      int start = commands[i][0] - 1;
      int[] tmp = new int[size];
      for (int j = 0; j < size; j++) {
        tmp[j] = array[start++];
      }
      Arrays.sort(tmp);
      answer[i] = tmp[commands[i][2] - 1];
    }
    return answer;
  }
}
