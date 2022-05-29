package com.inflearn.S03;

import java.util.Arrays;
import java.util.Scanner;

public class S03_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String arr1 = sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        String arr2 =sc.nextLine();

        String answer = solution(n,arr1,m,arr2);

        System.out.println(answer);
    }

    private static String solution(int n, String arr1, int m, String arr2) {
        int[] arr = new int[n+m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt((arr1 + " " + arr2).split(" ")[i]);
        }
        Arrays.sort(arr);

        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i] + " ";
        }
        return ans.trim();
    }
}
