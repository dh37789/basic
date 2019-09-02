package com.algorithm.b_search;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static void main(String[] args) {
    int[][] v = {{1, 1}, {2, 2}, {1, 2}};

    int[] answer = {};

    List<Integer> list = new ArrayList();
    List<Integer> list2 = new ArrayList();

    for (int i = 0; i < v.length; i++){
      for (int j = 0; j < v[i].length; j++){
         list.add(v[i][j]);
      }
    }

    for (int b : list){
      if (!list2.contains(b)){
        list2.add(b);
      }else{
        list2.remove((Object)b);
      }
    }

    answer = new int[]{list2.get(0), list2.get(1)};

  }
  public int[] solution(int[][] v) {
//
//    for ()

    int[] answer = {};


    return answer;
  }
}
