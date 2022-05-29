package com.inflearn.S02;

import java.util.Scanner;

public class S02_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();

        String ans = solution(nm);
        System.out.println(ans);
    }

    private static String solution(String nm) {
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);
        int[] arr = new int[n*m];

        for (int i = 1; i <= n;i++ ){
            for (int j = 1; j <= m; j++) {
                arr[i+j] = ++arr[i+j];
            }
        }

        int max = 0;
        String answer = "";
        for (int i = 0; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
                answer = String.valueOf(i);
            } else if (max == arr[i]) {
                answer += " " + i;
            }
        }

        return answer;
    }
}
