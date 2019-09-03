package com.backjoon;

import java.util.Scanner;

/**
 * 부녀회장이 될테야
 */
public class No02775 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    // 아파트 건설
    int[][] arr = new int[15][15];
    // 아파트 배열에 초기설정을 해준다.
    for (int i = 0; i < arr.length-1; i++) {
      arr[i][1] = 1;
      arr[0][i+1] = i+1;
    }
    // 배열의 해당 값을 일정한 규칙을 구해서 더해준다.
    for (int i = 0; i < t; i++) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      for (int j = 1; j <= k; j++) {
        for (int l = 1 ; l <= n; l++) {
          arr[j][l] = arr[j][l-1] + arr[j-1][l];
        }
      }
      System.out.println(arr[k][n]);
    }
    sc.close();
  }
}
