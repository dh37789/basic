package com.inflearn.S03;

import java.util.Scanner;

public class S03_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        for (int i = 0; i < 10; i++) {
            String aibi = sc.nextLine();
            arr = solution(arr, aibi);
        }
        String answer = "";
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] + " ";
        }

        System.out.println(answer.trim());
    }

    private static int[] solution(int[] arr, String aibi) {
        int ai = Integer.parseInt(aibi.split(" ")[0])-1;
        int bi = Integer.parseInt(aibi.split(" ")[1])-1;
        while (ai < bi){
            int tmp = arr[ai];
            arr[ai] = arr[bi];
            arr[bi] = tmp;
            ai++;
            bi--;
        }
        return arr;
    }
}
