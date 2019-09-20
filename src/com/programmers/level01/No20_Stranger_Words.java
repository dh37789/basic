package com.programmers.level01;

/**
 * 이상한 문자 만들기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12930
 */
public class No20_Stranger_Words {

  public static void main(String[] args) {
    String s = "try hello world";

    System.out.println(solution(s));
  }

  public static String solution(String s) {
    String[] strings = s.split(" ", -1);

    for (int i = 0; i < strings.length; i++) {
      char[] arr = strings[i].toCharArray();
      for (int j = 0; j < arr.length; j++) {
        if (j % 2 == 0) {
          arr[j] = Character.toUpperCase(arr[j]);
        } else {
          arr[j] = Character.toLowerCase(arr[j]);
        }
      }
      strings[i] = String.valueOf(arr);
    }

    String answer = "";
    for (int i = 0; i < strings.length; i++) {
      answer += strings[i];
      if (i != strings.length - 1) {
        answer += " ";
      }
    }
    return answer;
  }
}
