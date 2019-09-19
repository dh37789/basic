package com.programmers.level01;

/**
 * 문자열 내림차순으로 정렬하기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12917
 */
public class No16_Arrange_Strings_In_Descending_Order {

  public static void main(String[] args) {
    String s = "Zbcdefg";

    System.out.println(solution(s));
  }

  public static String solution(String s) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      char ch = ' ';
      for (int j = 1; j < chars.length - i; j++) {
        if (chars[j - 1] < chars[j]) {
          ch = chars[j - 1];
          chars[j - 1] = chars[j];
          chars[j] = ch;
        }
      }
    }
    return String.valueOf(chars);
  }
}
