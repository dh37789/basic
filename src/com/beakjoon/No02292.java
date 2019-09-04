package com.beakjoon;

import java.util.Scanner;

/**
 * 벌집
 */
public class No02292 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // 방의 숫자를 입력받는다.
    int honey = sc.nextInt();
    sc.close();
    // 6의 배수로 증가시키기 위한 수
    int hexa = 1;
    // 지나간 방의 수
    int i = 1;
    // 입력받은 방의 숫자가 해당하는 6의 배수보다 적어질경우 종료
    while (honey >= hexa) {
      // 입력받은 수에서 6의 배수만큼 증가시킨 숫자를 뺴준다.
      honey = honey - hexa;
      // 위의 뺄샘이 완벽하게 떨어질경우 아래 수식 생략
      if (honey != 0) {
        // 6의 배수씩 증가시킨다 1 - 6 - 12...
        hexa = i*6;
        // 지나가는 방의 수를 증가
        i++;
      }
    }
    System.out.println(i);
  }
}
