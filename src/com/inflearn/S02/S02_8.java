package com.inflearn.S02;

import java.util.Arrays;
import java.util.Scanner;

public class S02_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String nums = sc.nextLine();

        String ans = "";
        for(int i = 0; i < n; i++) {
            int num = reverse(nums.split(" ")[i]);
            String tmp = isPrime(num);
            if (tmp != ""){
                ans += tmp + " ";
            }
        }

        System.out.println(ans);
    }

    public static int reverse(String num) {
        String str = "";
        for (int i = num.length()-1; i >= 0; i--) {
            str += num.charAt(i);
        }
        return Integer.parseInt(str);
    }

    public static String isPrime(int num) {
        String ans = "";
        if (num == 1){
            return ans;
        }

        int[] arr = new int[num];

        for (int i = 2; i <= arr.length; i++ ){
            if(arr[i-1] == 0){
                for (int j = i+1; j <= arr.length; j++) {
                    if (j%i == 0){
                        arr[j-1] = ++arr[j-1];
                    }
                }
            }
        }

        if (arr[num-1] == 0){
            ans = String.valueOf(num);
        }
        return ans;
    }
}
