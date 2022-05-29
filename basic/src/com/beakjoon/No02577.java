package com.beakjoon;

import java.util.Scanner;

/**
 *  숫자의 개수
 */
public class No02577 {
  public static void main(String args[]){
    // 0 부터 9까지 몇번사용했는지 저장공간
    int[] num = {0,0,0,0,0,0,0,0,0,0};
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(); // 첫번째 수 입력
    int b = sc.nextInt(); // 두번째 수 입력
    int c = sc.nextInt(); // 세번째 수 입력
    // 세 수를 곱한 뒤 String으로 변환
    String total = String.valueOf(a * b * c);
    // 결과값의 길이만큼 반복문을 돌린다.
    // charAt()을 이용해서 i번째 위치한 값의 문자를 알아낸다.
    // 알아낸 값의 문자를 배열에서 찾아 1씩 증가
    for (int i = 0; i < total.length(); i++) {
      String temp = String.valueOf(total.charAt(i));
      num[Integer.parseInt(temp)]++;
    }
    // 배열값 출력
    for (int i = 0; i < num.length; i++) {
      System.out.println(num[i]);
    }
    sc.close();
  }
}
