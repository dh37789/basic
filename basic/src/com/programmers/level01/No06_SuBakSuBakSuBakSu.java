package com.programmers.level01;

/**
 * 수박수박수박수박수?
 * link : https://programmers.co.kr/learn/courses/30/lessons/12922
 */
public class No06_SuBakSuBakSuBakSu {

  public static void main(String[] args) {
    int n = 10;

    System.out.println(solution(n));
  }

  public static String solution(int n) {
    String answer = "";
    for(int i = 0; i < n; i++){
      if(i%2 == 0){
        answer = answer + "수";
      }else if(i%2 == 1){
        answer = answer + "박";
      }
    }
    return answer;
  }
}
