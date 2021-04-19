package com.inflearn.S03;

import java.util.*;

public class S03_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i ++){
            String num = sc.nextLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(num.split(" ")[j]);
            }
        }

        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++){
            String str = sc.nextLine();
            arr = suffle(arr, str);
        }

        int ans = solution(arr);
        System.out.println(ans);
    }

    private static int[][] suffle(int[][] arr, String str) {
        int line = Integer.parseInt(str.split(" ")[0]) - 1;
        int dir = Integer.parseInt(str.split(" ")[1]);
        int num = Integer.parseInt(str.split(" ")[2]);

        Queue<Integer> queue = new LinkedList<>();

        if (dir == 0) {
            for (int i = 0; i < arr[line].length; i++) {
                queue.offer(arr[line][i]);
            }
        } else if (dir == 1){
            for (int i = arr[line].length-1; i >= 0; i--) {
                queue.offer(arr[line][i]);
            }
        }

        for (int j = 0; j < num; j++) {
            queue.offer(queue.poll());
        }

        if (dir == 0) {
            for (int i = 0; i < arr[line].length; i++){
                arr[line][i] = queue.poll();
            }
        } else if (dir == 1){
            for (int i = arr[line].length-1; i >= 0; i--) {
                arr[line][i] = queue.poll();
            }
        }

        return arr;
    }

    private static int solution(int[][] arr) {
        int stand = arr.length/2;
        int sum = 0;
        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = idx; j < arr[i].length - idx; j++){
                sum += arr[i][j];
            }
            if (i < stand){
                idx++;
            } else {
                idx--;
            }
        }

        return sum;
    }
}
