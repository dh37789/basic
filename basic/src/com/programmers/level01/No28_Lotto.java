package com.programmers.level01;

import java.util.Arrays;
import java.util.Scanner;

    /**
     * 입출력 예
     * lottos	win_nums	result
     * [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
     * [0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
     * [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
     */
public class No28_Lotto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] in = new int[6];
        int[] out = new int[6];

        for (int i = 0; i < in.length; i++){
            in[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < out.length; i++){
            out[i] = sc.nextInt();
        }

        int[] answer = solution(in, out);

        System.out.println(answer);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        return answer;
    }
}
