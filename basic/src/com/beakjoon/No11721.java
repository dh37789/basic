package com.beakjoon;

import java.util.Scanner;

/**
 * 열 개씩 끊어 출력하기
 */
public class No11721 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    int j = 10;
    String str = "";
    for (int i = 0; i < input.length(); i+=10) {
      if (input.length() > j) {
        str = input.substring(i,j);
      }else{
        j -= (j-input.length());
        str = input.substring(i,j);
      }
      j += 10;
      System.out.println(str);
    }
  }
}
