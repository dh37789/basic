package com.algorithm.b_search;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    String s = "3people unFollowed me";
//    String s = "for the last week";
//    char s = ' ';

    System.out.println(solution(s));
//    System.out.println((int)s);
  }
  public static String solution(String s) {
    char[] arr;
    arr = s.toCharArray();

    for (int i = 1; i < arr.length; i++) {
      char a = arr[i-1];
      char b = arr[i];
      if (i-1 == 0 && ('a' <= a&&a <= 'z')) {
        a -= 32;
        arr[i-1] = a;
      }
      if ((int)a == 32 && ('a' <= b&&b <= 'z')) {
        b -= 32;
        arr[i] = b;
      } else if ((int)a != 32 && ('A' <= b&&b <= 'Z')) {
        b += 32;
        arr[i] = b;
      }
    }
    return new String(arr, 0, arr.length);
  }
}
