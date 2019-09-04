package com.beakjoon;

import java.util.Scanner;

/**
 *  그대로 출력하기
 */
public class No11718 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Scanner 선언
    while(sc.hasNextLine()){
      // 입력값이 몇 줄인지 모르기때문에 입력값이 있을경우에만 출력
      String in = sc.nextLine(); // 입력값을 받는다.
      System.out.println(in); // 입력값 출력
    }
    sc.close(); // Scanner close
  }
}
