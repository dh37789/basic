package com.backjoon;

import java.util.Scanner;

/**
 *  음계
 */
public class No02920 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 음계가 들어갈 배열을 만들어준다.
    int[] scale = new int[8];
    // 음계를 넣어준다.
    for (int i = 0; i < scale.length; i++) {
      scale[i] = sc.nextInt();
    }
    // score는 i번째와 i-1의 음계 차이를 저장한다.
    int score = 0;
    // chk는 음계의 상태를 저장한다.
    // chk = 0, ascending
    // chk = 1, descending
    // chk = 2, mixed
    int chk = 0;
    for (int i = 1; i < scale.length; i++) {
      score = scale[i-1] - scale[i];
      if (score == -1)
        chk = 0;
      else if(score == 1)
        chk = 1;
      else{
        chk = 2;
        break;
      }
    }
    // 출력한다.
    if (chk == 0)
      System.out.println("ascending");
    else if(chk == 1)
      System.out.println("descending");
    else if(chk == 2)
      System.out.println("mixed");
  }
}
