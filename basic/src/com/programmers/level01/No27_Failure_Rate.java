package com.programmers.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 실패율
 * link : https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class No27_Failure_Rate {

  public static void main(String[] args) {
    final int N = 4;
    int[] stages = {4, 4, 4, 4};

    System.out.println(Arrays.toString(solution(N, stages)));
  }

  public static int[] solution(int N, int[] stages) {
    int[] answer = new int[N];

    int total = stages.length;
    Map<Integer, Double> failVal = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      int num = 0;
      for (int j = 0; j < stages.length; j++) {
        if (stages[j] == i) {
          num++;
        }
      }
      if (total != 0) {
        failVal.put(i, (double) num / total);
      } else {
        failVal.put(i, 0.0);
      }
      total = total - num;
    }
    Iterator it = sortByValue(failVal).iterator();

    int i = 0;
    while (it.hasNext()) {
      answer[i] = (int) it.next();
      i++;
    }
    return answer;
  }

  private static List sortByValue(final Map map) {
    List<String> list = new ArrayList<>();
    list.addAll(map.keySet());
    Collections.sort(list, new Comparator() {
      public int compare(Object o1, Object o2) {
        Object v1 = map.get(o1);
        Object v2 = map.get(o2);
        return ((Comparable) v2).compareTo(v1);
      }
    });
    return list;
  }
}
