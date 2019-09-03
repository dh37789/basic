package com.backjoon;

import java.util.Scanner;

/**
 *  숫자의 합
 */
public class No11720 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    String y = sc.next();
    int num = 0;
    // x의 값만큼 for문을 돌린다.
    for (int i = 0; i < x; i++) {
      // y의 값을 substring으로 한글자씩 잘라준다.
      String z = y.substring(i,i+1);
      // int로 변환하여 더해준다.
      num += Integer.parseInt(z);
    }
    System.out.println(num);
    sc.close();
  }
}
