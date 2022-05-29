package com.inflearn.S03;

import java.util.Arrays;
import java.util.Scanner;

public class S03_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i ++){
            String num = sc.nextLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(num.split(" ")[j]);
            }
        }

        int ans = solution(arr);
        System.out.println(ans);
    }

    private static int solution(int[][] arr) {
        int max = 0;
        // 가로
        for (int i = 0; i < arr.length; i++){
            int hsum = 0;
            int lsum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                hsum += arr[i][j];
                lsum += arr[j][i];
            }
            int tmp = hsum > lsum ? hsum : lsum;
            if (max < tmp){
                max = tmp;
            }
        }
        
        // 대각선
        int lcsum = 0;
        int rcsum = 0;
        for (int i = 0; i < arr.length; i++){
            lcsum += arr[i][i];
            rcsum += arr[i][arr.length-i-1];
        }
        int tmp = lcsum > rcsum ? lcsum : rcsum;
        if (max < tmp){
            max = tmp;
        }
        return max;
    }
}
