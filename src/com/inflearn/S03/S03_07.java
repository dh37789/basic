package com.inflearn.S03;

import java.util.Scanner;

public class S03_07 {
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
        int start = arr.length/2;
        int end = arr.length/2;
        int apples = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = start; j <= end; j++){
                apples += arr[i][j];
            }
            if (i < arr.length/2){
                start--;
                end++;
            } else {
                start++;
                end--;
            }
        }
        return apples;
    }
}
