package com.programmers.level01;

import java.util.Arrays;

/**
 * 서울에서 김서방 찾기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class No12_Find_Kim_Seobang_In_Seoul {

  public static void main(String[] args) {
    String[] seoul = {"Jane", "Kim"};

    System.out.println(solution(seoul));
  }

  public static String solution(String[] seoul) {
    return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
  }
}
