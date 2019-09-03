package com.backjoon;

import java.util.Scanner;

/**
 *  그룹 단어 체커
 */
public class No01316 {
  static int N;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 그룹단어의 갯수
    int score = 0;
    N = sc.nextInt();
    // N만큼 반복문을 돌린다.
    for (int i = 0; i < N; i++) {
      String gr = sc.next();
      // a ~ z 까지 사용되었는지 체크할 배열
      int[] arr = new int[26];
      // 그룹단어 일경우 true 아닐경우 false
      boolean grChk = true;
      // 첫번째 글자부터 j번째 글자까지 비교한다.
      for (int j = 0; j < gr.length(); j++) {
        if (arr[(int)(gr.charAt(j)-97)] != 0) {
          if (gr.charAt(j) == gr.charAt(j-1)) continue;
          else grChk = false;
        }else arr[(int)(gr.charAt(j)-97)]++;
      }
      if (grChk) score++;
    }
    sc.close();
    System.out.println(score);
  }
}
