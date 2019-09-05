package com.programmers.level01;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * link : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class No01_An_Incomplete_Player {

  public static void main(String[] args) {
    String[] arr = {"mislav", "stanko", "mislav", "ana"};
    String[] com = {"stanko", "ana", "mislav"};
    System.out.println(solution(arr, com));
  }

  public static String solution(String[] arr, String[] com) {

    HashMap<String, Integer> hm = new HashMap<>();
    for (String player : arr) {
      hm.put(player, hm.getOrDefault(player, 0) + 1);
    }
    for (String player : com) {
      hm.put(player, hm.get(player) - 1);
    }

    String answer = "";
    for (Map.Entry<String, Integer> key : hm.entrySet()) {
      if (key.getValue() != 0) {
        answer = key.getKey();
      }
    }
    return answer;
  }
}
