package com.backjoon;

import java.util.Scanner;

/**
 *  단어의 개수
 */
public class No01152 {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    // nextLine을 이용해 공백포함 입력값을 받아오고 trim()으로 앞뒤 공백을 제거
    String str = sc.nextLine().trim();
    sc.close();
    // 입력값이 비어있을 경우에는 0 출력
    if (str.isEmpty()) {
      System.out.println("0");
      // 입력값을 split(" ")으로 공백을 기준으로 배열 생성후 배열의 길이를 구한다.
    }else{
      System.out.println((str.split(" ")).length);
    }
  }
}
