package com.inflearn.S04;

import java.util.Arrays;
import java.util.Scanner;

public class S04_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kn = sc.nextLine();

        int k = Integer.parseInt(kn.split(" ")[0]);
        int n = Integer.parseInt(kn.split(" ")[1]);

        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        Arrays.sort(arr);

        int max = arr[k-1];

        int answer = solution(arr, n, max);

        System.out.println(answer);
    }

    private static int solution(int[] arr, int n, int max) {
        int lp = 1;
        int rp = max;
        int tmpAns = 0;
        while (lp <= rp){
            int mid = (lp + rp)/2;
            if (count(mid, arr) >= n){
                tmpAns = mid;
                lp = mid+1;
            } else {
                rp = mid-1;
            }
        }
        return tmpAns;
    }

    private static int count(int mid, int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++){
            cnt += arr[i]/mid;
        }
        return cnt;
    }
}
