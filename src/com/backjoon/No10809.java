package com.backjoon;

import java.util.Scanner;

/**
 *  알파벳 찾기
 */
public class No10809 {
  static String S;
  static int[] arr;

  public static void main(String[] args) {
    arr = new int[26];
    // arr의 배열에 기본값 -1을 넣어준다.
    for (int i = 0; i < arr.length; i++)
      arr[i] = -1;
    // 문자를 입력받는다.
    Scanner sc = new Scanner(System.in);
    S = sc.next();
    sc.close();
    // 문자의 길이만큼 반복문을 돌려서 일치하는 char값에 i값을 넣어준다.
    for (int i = 0; i < S.length(); i++){
      int alNum = (int)S.charAt(i) - 97;
      if (arr[alNum] == -1) arr[alNum] = i;
    }
    // 배열을 출력한다.
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }
}
