package com.programmers.level01;

/**
 * 문자열 다루기 기본
 * link : https://programmers.co.kr/learn/courses/30/lessons/12918
 */
public class No21_Basic_Use_Of_Strings {

  public static void main(String[] args) {
    String s = "s110";

    System.out.println(solution(s));
  }

  public static boolean solution(String s) {
    boolean answer = false;
    if (s.length() >= 4 || s.length() <= 6) {
      try {
        Integer.parseInt(s);
        answer = true;
      } catch (Exception e) {
      }
    }
    return answer;
  }
}
