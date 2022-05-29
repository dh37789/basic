package com.programmers.level01;

/**
 * 콜라츠 추측
 * link : https://programmers.co.kr/learn/courses/30/lessons/12943
 */
public class No18_Collatz_Conjecture {

  public static void main(String[] args) {
    int num = 1;

    System.out.println(solution(num));
  }

  public static int solution(int num) {
    int i = 0;
    for (i = 1; i <= 501; i++) {
      if (i == 501) {
        i = -1;
        break;
      }
      if (num == 1) {
        i = i - 1;
        break;
      }

      if (num % 2 == 0) {
        num = num / 2;
      } else if (num % 2 == 1) {
        num = num * 3 + 1;
      }
    }
    return i;
  }
}
