package com.beakjoon;

import java.util.Scanner;

/**
 *  평균
 */
public class No01546 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 배열의 수를 받아온다
    int arrNum = sc.nextInt();
    // 배열 생성
    int[] nums = new int[arrNum];
    // 배열 안에 점수를 넣어준다.
    for (int i = 0; i < nums.length; i++)
      nums[i] = sc.nextInt();
    // 배열값을 비교해서 Max값 추출
    int maxNum = nums[0];
    for (int i = 0; i < nums.length; i++)
      if (maxNum < nums[i])
        maxNum = nums[i];
    // 각 점수의 가짜점수로 만들어 배열에 넣어준다. 2자리에 반올림
    double[] avgs = new double[arrNum];
    for (int i = 0; i < avgs.length; i++){
      avgs[i] = (double)nums[i]/maxNum;
      avgs[i] = Double.parseDouble(String.format("%.2f", avgs[i])) * 100;
    }
    // 가짜점수들을 더해서 평균을 구해준다.
    double avg = 0;
    for (int i = 0; i < avgs.length; i++) {
      avg += avgs[i];
      if (i == avgs.length-1) {
        avg = avg/arrNum;
      }
    }
    // 4자리까지 반올림
    avg = Double.parseDouble(String.format("%.4f", avg));
    System.out.println(avg);
    sc.close();
  }
}
