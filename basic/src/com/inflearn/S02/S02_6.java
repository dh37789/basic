package com.inflearn.S02;

import java.util.Scanner;

public class S02_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String m = sc.nextLine();

        String ans = solution(n, m);
        System.out.println(ans);
    }

    private static String solution(int n, String m) {
        String answer = "";
        int max = 0;
        for (int i = 0; i < n; i++){
            String str = m.split(" ")[i];
            int sum = 0;
            int num = 10;
            int tmpNum = Integer.parseInt(str);
            for (int j = 1; j <= str.length(); j++) {
                int k = tmpNum%num;
                tmpNum = tmpNum/num;
                sum += k;
            }
            if (sum > max){
                max = sum;
                answer = str;
            }
        }
        return answer;
    }
}
