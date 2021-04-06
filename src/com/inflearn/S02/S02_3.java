package com.inflearn.S02;

import java.util.*;

public class S02_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nk = sc.nextLine();
        String num = sc.nextLine();

        int ans = solution(nk, num);
        System.out.println(ans);
    }

    private static int solution (String nk, String num) {
        int n = Integer.parseInt(nk.split(" ")[0]);
        int k = Integer.parseInt(nk.split(" ")[1]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(num.split(" ")[i]);
        }

        Set<Integer> setNum = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int m = j+1; m < arr.length; m++) {
                    int sum = arr[i] + arr[j] + arr[m];
                    setNum.add(sum);
                }
            }
        }

        List<Integer> listNum = new ArrayList<Integer>(setNum);
        Collections.sort(listNum, Comparator.reverseOrder());

        return listNum.get(k-1);
    }
}
