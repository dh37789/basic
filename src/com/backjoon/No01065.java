package com.backjoon;

import java.util.Scanner;

/**
 * 한수
 */
public class No01065 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 자연수 N까지의 값을 입력받는다.
    int hans = sc.nextInt();
    // 한수의 수
    int score = 0;
    // 99이하의 값은 모두 한수이다.
    if (hans < 99) {
      score = hans;
      // 100이상의 수부터 조건을 찾는다.
    }else{
      // 99까지의 기본값을 더해준다.
      score += 99;
      // 100부터 반복문을 돌려 한수를 찾는다.
      for (int i = 100; i <= hans; i++) {
        String str = String.valueOf(i);
        // 각 자리수의 차이값을 저장할 배열을 만든다.
        int[] tmArray = new int[str.length()-1];
        // 각 자리수를 빼서 차이값을 배열에 저장한다.
        for (int j = 1; j < str.length(); j++) {
          int tmp = Integer.parseInt(String.valueOf(str.charAt(j-1)))
              - Integer.parseInt(String.valueOf(str.charAt(j)));
          tmArray[j-1] = tmp;
        }
        // 한수인지 체크하는 boolean타입의 변수를 만든다.
        boolean hansChk = false;
        // 차이값이 같지 않을경우에는 break 같을경우에는 hansChk를 true로 둔다.
        for (int j = 1; j < tmArray.length; j++) {
          if (tmArray[j-1] != tmArray[j]) {
            break;
          }else{
            hansChk = true;
          }
        }
        // hasnChk가 true일 경우에는 한수의 수 증가
        if (hansChk) {
          score++;
        }
      }
    }
    System.out.println(score);
  }
}
