package com.programmers.level01;

/**
 * 핸드폰 번호 가리기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class No17_Hide_Phone_Number {

  public static void main(String[] args) {
    String phone_number = "01048079310";

    System.out.println(solution(phone_number));
  }

  public static String solution(String phone_number) {
    String star = "";
    for (int i = 0; i < phone_number.length() - 4; i++) {
      star += "*";
    }
    return phone_number.replaceAll(phone_number.substring(0, phone_number.length() - 4), star);
  }
}
