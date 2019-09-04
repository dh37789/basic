package com.algorithm.b_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
    String[] arr = {"mislav", "stanko", "mislav", "ana"};
    String[] com = {"stanko", "ana", "mislav"};
    System.out.println(solution(arr, com));
  }
  public static String solution(String[] arr, String[] com) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : arr) hm.put(player, hm.getOrDefault(player, 0) + 1);
    for (String player : com) hm.put(player, hm.get(player) - 1);

    for (Map.Entry<String, Integer> key : hm.entrySet()) {
      if (key.getValue() != 0){
        answer = key.getKey();
      }
    }
    return answer;
  }
//  public static String solution(String s) {
//    char[] arr;
//    arr = s.toCharArray();
//
//    for (int i = 1; i < arr.length; i++) {
//      char a = arr[i-1];
//      char b = arr[i];
//      if (i-1 == 0 && ('a' <= a&&a <= 'z')) {
//        a -= 32;
//        arr[i-1] = a;
//      }
//      if ((int)a == 32 && ('a' <= b&&b <= 'z')) {
//        b -= 32;
//        arr[i] = b;
//      } else if ((int)a != 32 && ('A' <= b&&b <= 'Z')) {
//        b += 32;
//        arr[i] = b;
//      }
//    }
//    return new String(arr, 0, arr.length);
//  }
}
