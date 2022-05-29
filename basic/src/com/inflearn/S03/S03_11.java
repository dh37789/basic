package com.inflearn.S03;

import java.util.Scanner;

public class S03_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int ans = solution(arr);
        System.out.println(ans);
    }

    private static int solution(int[][] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j< arr[i].length; j++){
                if (i > 1&&i < arr.length-2){
                    if (arr[i-1][j]==arr[i+1][j]&&arr[i-2][j]==arr[i+2][j]){
                        cnt++;
                    }
                }
                if (j > 1&&j < arr.length-2){
                    if (arr[i][j-1]==arr[i][j+1]&&arr[i][j-2]==arr[i][j+2]){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
