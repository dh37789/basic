package com.inflearn.S03;

import java.util.Scanner;

public class S03_09 {
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
        int cnt = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (i != 0){
                    if(arr[i][j] <= arr[i-1][j]){
                        continue;
                    }
                }
                if (i != arr.length-1) {
                    if(arr[i][j] <= arr[i+1][j]){
                        continue;
                    }
                }
                if (j != 0) {
                    if(arr[i][j] <= arr[i][j-1]){
                        continue;
                    }
                }
                if (j != arr.length-1){
                    if(arr[i][j] <= arr[i][j+1]){
                        continue;
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}
