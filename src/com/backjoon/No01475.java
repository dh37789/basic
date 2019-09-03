package com.backjoon;

import java.util.Scanner;

/**
 * 방번호
 */
public class No01475 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // 사용값 셋팅
    double[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    String n = sc.next();
    // 문자열의 길이만큼 반복문을 돌린다.
    for (int i = 0; i < n.length(); i++) {
      // 6과 9는 교체되서 사용 할 수 있기 때문에 조건문 체크
      if (n.charAt(i)== '9'||n.charAt(i) == '6'){
        // 6이나 9인 경우에 0.5만 증가시킨다.
        arr[Integer.parseInt(String.valueOf(n.charAt(i)))] += 0.5;
      }else{
        // 그외의 숫자는 셋트를 1개씩 증가시킨다.
        arr[Integer.parseInt(String.valueOf(n.charAt(i)))]++;
      }
    }
    // 6번 카드와 9번 카드를 한 카드에 몰빵한다.
    arr[6] += arr[9];
    arr[9] = 0;
    // 최댓값을 구해준다.
    double max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    // 최대값을 올림하여 정답을 구한다.
    System.out.println((int)Math.ceil(max));
  }
}
