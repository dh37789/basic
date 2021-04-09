package com.inflearn.S02;

import java.util.Scanner;

public class S02_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String score = sc.nextLine();

        int ans = solution(n, score);

        System.out.println(ans);
    }

    private static int solution (int n, String score){
        int totalScore = 0;
        int tmpScore = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(score.split(" ")[i]);
            if (num == 1){
                tmpScore++;
                totalScore += tmpScore;
            } else if (num == 0) {
                tmpScore = 0;
            }
        }
        return totalScore;
    }
}
