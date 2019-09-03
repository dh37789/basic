package com.backjoon;

import java.util.Scanner;

/**
 * 크로아티아 알파벳
 */
public class No02941 {
  public static void main(String args[]) {
    // 크로아티아 알파벳의 배열
    String[] croatia = {"c=","c-","dz=","d-","lj","nj","s=","z="};
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    sc.close();
    // 입력받은 단어중 크로아티아에 해당하는 단어를 전부 *로 바꿔준다.
    for (int i = 0; i < croatia.length; i++)
      word = word.replace(croatia[i], "*");

    // 단어의 길이를 출력
    System.out.println(word.length());
  }
}
