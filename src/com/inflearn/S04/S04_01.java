package com.inflearn.S04;

import org.omg.CORBA.SystemException;

import java.util.Arrays;
import java.util.Scanner;

// 이분법
public class S04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String arr = sc.nextLine();
        int answer = soluion(nm, arr);
        if (answer == -1){
            System.out.println("해당 하는 index를 찾을 수 없습니다.");
        } else {
            System.out.println(answer);
        }
    }

    private static int soluion(String nm, String arr) {
        int n = Integer.parseInt(nm.split(" ")[0]);
        int m = Integer.parseInt(nm.split(" ")[1]);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr.split(" ")[i]);
        }

        Arrays.sort(nums);

        int lp = 0;
        int rp = n - 1;
        while (lp <= rp){
            int mid = (lp + rp)/2;
            if (nums[mid] == m){
                return mid+1;
            } else if (nums[mid] > m) {
                rp = mid-1;
            } else if (nums[mid] < m) {
                lp = mid-1;
            }
        }

        return -1;
    }
}
