package com.inflearn.S03;

import java.util.Scanner;

public class S03_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = stringToint(str);
        int ea = divisor(n);
        System.out.println(n);
        System.out.println(ea);
    }

    public static int stringToint(String str){
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (48 <= tmp&&tmp <= 57){
                num += tmp;
            }
        }
        return Integer.parseInt(num);
    }

    private static int divisor(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            if (n%i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
