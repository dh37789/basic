package com.beakjoon;

import java.util.Scanner;

/**
 *  단어 공부
 */
public class No01157 {
  // S는 입력받은 문자열
  static String S;
  static int[] arr;

  public static void main(String[] args) {
    arr = new int[26];
    Scanner sc = new Scanner(System.in);
    // 입력받은 문자를 전부 대문자로 치환한다.
    S = sc.nextLine().toUpperCase();
    sc.close();
    // 사용된 알파벳의 배열에 1씩 증가시킨다.
    for (int i = 0; i < S.length(); i++)
      arr[(int) S.charAt(i) - 65]++;
    // 배열의 최대값을 구해준다.
    // 만약 중복일경우에는 ?를 출력한다.
    int maxNum = arr[0];
    char out = 'A';
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxNum) {
        maxNum = arr[i];
        out = (char) (i + 65);
      } else if (arr[i] == maxNum && arr[i] != 0)
        out = '?';
    }
    System.out.println(out);
  }
}
