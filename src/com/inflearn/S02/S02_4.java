package com.inflearn.S02;

import java.util.*;

public class S02_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String scores = sc.nextLine();

        String ans = solution(n, scores);
        System.out.println(ans);
    }

    private static String solution(int n, String scores) {
        Map<Integer, Integer> scoreMap = new HashMap<Integer, Integer>();
        int scoreSum = 0;
        int scoreAvr = 0;
        for (int i = 0; i < n; i++){
            int score = Integer.parseInt(scores.split(" ")[i]);
            scoreSum += score;
        }

        scoreAvr = Math.round((float)scoreSum/n);

        int standDef = 100;
        int ansNum = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(scores.split(" ")[i]);
            int def = Math.abs(score - scoreAvr);
            if (standDef > def){
                ansNum = i+1;
                standDef = def;
            }
        }

        return scoreAvr + " " + ansNum;
    }
}
