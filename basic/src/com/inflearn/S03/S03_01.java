package com.inflearn.S03;

import java.util.Scanner;

public class S03_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String ans = solution(str);
            System.out.println(ans);
        }
    }

    public static String solution(String str) {
        str = str.toLowerCase();
        int len = str.length();
        for (int i = 1; i <= len/2; i++){
            if (str.charAt(i-1) != str.charAt(len-i)){
                return "NO";
            }
        }
        return "YES";
    }
}
