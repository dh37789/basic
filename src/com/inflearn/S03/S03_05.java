package com.inflearn.S03;

import java.util.Scanner;

public class S03_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String num = sc.nextLine();
        int ans = solution(nm, num);
        System.out.println(ans);
    }

    private static int solution(String nm, String num) {
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(num.split(" ")[i]);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > m) {
                    break;
                } else if (sum == m){
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
