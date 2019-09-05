package com.programmers.level01;

/**
 * 문자열을 숫자로 바꾸기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12925
 */
public class No07_Replace_String_With_Integer {

  public static void main(String[] args) {
    String s = "1234";

    System.out.println(solution(s));
  }

  public static int solution(String s) {
    int sum = 0;
    int sign = 1;
    int i = 0;
    if (s.charAt(0) == '-') {
      sign *= -1;
      i = 1;
    } else if (s.charAt(0) == '+') {
      i = 1;
    }
    for (int j = i; j < s.length(); j++) {
      sum += Math.pow(10, (s.length() - j - 1)) * (s.charAt(j) - 48);
    }
    sum *= sign;
    return sum;
  }
}
