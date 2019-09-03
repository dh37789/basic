package com.backjoon;

import java.util.Scanner;

/**
 * 분수찾기
 */
public class No01193 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int X = sc.nextInt();
    sc.close();
    // 몇번째 줄의 분수인지 판별
    int num = 1;
    // 초기값 셋팅
    int up = 2;
    int down = 0;
    // for문을 돌려서 num값으로 증감을 판별해준다.
    for (int i = 1; i <= X; i++) {
      if (num%2 == 0) {
        // down이 1일때 감소하면 0이되어버리므로 막아준다.
        if (down != 1)
          down--;
        up++;
        if (num < up)
          num++;
      }else if(num%2 == 1){
        // 위와 마찬가지로 up이 1일때 감소하면 0이 되어버리므로 막아준다.
        if (up != 1)
          up--;
        down++;
        if (num < down)
          num++;
      }
    }
    System.out.println(up + "/" + down);
  }
}
