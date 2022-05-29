package com.inflearn.S02;

import java.util.Arrays;
import java.util.Scanner;

public class S02_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String score = sc.nextLine();
            int money = solution(score);
            arr[i] = money;
        }

        Arrays.sort(arr);

        System.out.println(arr[n-1]);
    }

    public static int solution (String score) {
        int[] dice = new int[6];
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(score.split(" ")[i]);
            dice[num-1] = ++dice[num-1];
        }

        int cash = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == 3){
                cash = 10000 + (i+1) * 1000;
                break;
            } else if (dice[i] == 2){
                cash = 1000 + (i+1) * 100;
                break;
            } else if (dice[i] == 1){
                cash = (i+1) * 100;
            }
        }
        return cash;
    }
}
