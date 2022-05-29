package com.programmers.level01;

/**
 * 가운데 글자 가져오기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class No05_Get_Center_Character {

  public static void main(String[] args) {
    String s = "abcde";

    System.out.println(solution(s));
  }

  public static String solution(String s) {
    String answer = "";
    int i = s.length();
    if (i % 2 == 0) {
      char a = s.charAt(i / 2 - 1);
      char b = s.charAt(i / 2);
      answer = "" + a + b;
    } else if (i % 2 == 1) {
      char c = s.charAt(i / 2);
      answer = "" + c;
    }
    return answer;
  }
}
