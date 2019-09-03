package com.backjoon;

import java.util.Scanner;

/**
 *  더하기 사이클
 */
public class No01110 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 초기값 입력
    int num = sc.nextInt();
    // 초기값을 자르거나 바꾸기위해 String으로 변환
    String numStr = "";
    // 초기값이 10이하일 경우에는 앞에 0을 붙여준다.
    if (num < 10) {
      numStr = "0" + num;
    } else {
      numStr = String.valueOf(num);
    }
    // 사이클 값 초기화
    int i = 1;
    // 조건이 같을 때까지 무한 반복문을 돌린다.
    while (true) {
      // A + B = C
      // A의 변수
      int num1 = 0;
      // B의 변수
      int num2 = 0;
      // 연산 결과 값이 10보다 작을경우에는 num2에 바로 넣어준다.
      if (Integer.parseInt(numStr) < 10) {
        num2 = Integer.parseInt(numStr);
        // 연산 결과 값이 10보다 클 경우에는 num1와 num2에 각각 잘라 넣어준다.
      } else {
        num1 = Integer.parseInt(numStr.substring(0, numStr.length() - 1));
        num2 = Integer.parseInt(numStr.substring(numStr.length() - 1, numStr.length()));
      }
      // C의 결과값
      int sumNum = num1 + num2;
      // 결과값을 numStr에 넣어준다.
      numStr = String.valueOf(sumNum);
      // 1의 자리 숫자만 잘라서 다시 넣는다.
      numStr = numStr.substring(numStr.length() - 1, numStr.length());
      // B와 C(1의 자리)의 문자열을 더해준다
      numStr = num2 + numStr;
      // 문자열을 더한값이 초기값과 같은경우에는 break
      if (Integer.parseInt(numStr) == num) {
        System.out.println(i);
        break;
      }
      i++;
    }
  }
}
