package com.algorithm.b_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
   String[] seoul = {"Jane", "Kim"};

    System.out.println(solution(seoul));
  }
  public static String solution(String[] seoul) {
    return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
  }
}


