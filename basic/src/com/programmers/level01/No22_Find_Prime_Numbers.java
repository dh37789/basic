package com.programmers.level01;

/**
 * 소수 찾기
 * link : https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class No22_Find_Prime_Numbers {

  public static void main(String[] args) {

    int n = 10;

    System.out.println(solution(n));
  }

  /**
   * 아리스토텔레스의 체
   *
   * @param n
   * @return
   */
  public static int solution(int n) {

    boolean[] arr = new boolean[n + 1];
    arr[0] = false;
    arr[1] = false;
    for (int i = 2; i < n + 1; i++) {
      arr[i] = true;
    }

    int sqrt = (int) Math.sqrt(n);
    for (int i = 2; i <= sqrt; i++) {
      for (int j = i; i * j <= n; j++) {
        arr[i * j] = false;
      }
    }

    int answer = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == true) {
        answer++;
      }
    }

    return answer;
  }
}
