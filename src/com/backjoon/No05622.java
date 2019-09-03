package com.backjoon;

import java.util.Scanner;

/**
 * 다이얼
 */
public class No05622 {
  public static void main(String args[]) {
    // 각 다이얼에 해당하는 문자열을 배열에 저장해 준다.
    String[] arr = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    Scanner sc = new Scanner(System.in);
    String dialog = sc.next();
    sc.close();
    // 다이얼을 걸기 위해 필요한 시간
    int time = 0;
    // 다이얼의 문자열 길이만큼 반복
    for (int i = 0; i < dialog.length(); i++)
      // 다이얼의 문자열 길이를 배열에 속해있는지 여부를 판단하고
      // 속해있을 시에는 시간에 값을 더해준다.
      for (int j = 0; j < arr.length; j++)
        if(arr[j].contains(String.valueOf(dialog.charAt(i))))
          time += j+3;
    System.out.println(time);
  }
}
