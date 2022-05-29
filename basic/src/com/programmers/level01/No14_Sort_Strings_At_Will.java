package com.programmers.level01;

import java.util.Arrays;

/**
 * 문자열 내 마음대로 정렬하기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class No14_Sort_Strings_At_Will {

  public static void main(String[] args) {
    String[] strings = {"abce", "abcd", "cdx"};
    int n = 2;

    System.out.println(Arrays.toString(solution(strings, n)));
  }

  public static String[] solution(String[] strings, int n) {
    for (int i = 0; i < strings.length; i++) {
      for (int j = 1; j < strings.length - i; j++) {
        if (strings[j - 1].charAt(n) > strings[j].charAt(n)) {
          strings = swapString(strings, j-1, j);
        } else if (strings[j - 1].charAt(n) == strings[j].charAt(n)) {
          if (strings[j - 1].compareTo(strings[j]) > 0) {
            strings = swapString(strings, j-1, j);
          }
        }
      }
    }
    return strings;
  }

  public static String[] swapString(String strings[],int i,int j) {
    String str = "";
    str = strings[i];
    strings[i] = strings[j];
    strings[j] = str;
    return strings;
  }

}
