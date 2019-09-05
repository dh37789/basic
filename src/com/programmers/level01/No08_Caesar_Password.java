package com.programmers.level01;

/**
 * 시저암호
 * link : https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class No08_Caesar_Password {

  public static void main(String[] args) {
    String s = "AB";
    int n = 1;

    System.out.println(solution(s, n));
  }

  public static String solution(String s, int n) {
    String answer = "";
    String tempStr = s;
    for (int i = 0; i < tempStr.length(); i++) {
      int temp = (int)tempStr.charAt(i);
      if (65<=temp&&temp<=90) {
        temp += n%26;
        if (temp>90) {
          temp -= 26;
        }
      }else if(97<=temp&temp<=122) {
        temp += n%26;
        if (temp>122) {
          temp -= 26;
        }
      }
      answer += (char)temp;
    }
    return answer;
  }
}
