package com.programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 모의고사
 * link : https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class No04_Mock_Test {

  public static void main(String[] args) {
    int[] answers = {4};

    System.out.println(Arrays.toString(solution(answers)));
  }

  public static int[] solution(int[] answers) {
    int[] supo1 = {1, 2, 3, 4, 5};
    int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int[] score = new int[3];

    for (int i = 0; i < answers.length; i++) {
      if (supo1[i % supo1.length] == answers[i]) {
        score[0]++;
      }
      if (supo2[i % supo2.length] == answers[i]) {
        score[1]++;
      }
      if (supo3[i % supo3.length] == answers[i]) {
        score[2]++;
      }
    }

    int max = 0;
    for (int i = 1; i < score.length; i++) {
      if (score[max] < score[i]) {
        max = i;
      }
    }

    List<Integer> pass = new ArrayList<>();
    for (int i = 0; i < score.length; i++) {
      if (score[max] == score[i]) {
        pass.add(i + 1);
      }
    }
    pass.sort(Comparator.naturalOrder());
    int[] answer = new int[pass.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = pass.get(i);
    }
    return answer;
  }
}
