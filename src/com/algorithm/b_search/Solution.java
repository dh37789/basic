package com.algorithm.b_search;

public class Solution {

  public static void main(String[] args) {
    int x = 10;

    System.out.println(solution(x));
  }

  public static boolean solution(int x) {
    String num = String.valueOf(x);
    int tmp = 0;
    for (int i = 0; i < num.length(); i++) {
      tmp += Integer.parseInt(num.charAt(i) + "");
    }
    return x%tmp == 0;
  }
}


