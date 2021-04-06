package com.inflearn.S02;

/*
    N 개의 숫자로 이루어진 숫자열이 주어지면 해당 숫자열중에서 s번째부터 e번째 까지의 수를 오름 차순 정렬했을 때 k번째로 나타나는 숫자를 출력하는 프로그램을 작성하세요.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class S02_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String Nsek = "";
        String num = "";

        sc.nextLine();

        for (int i = 0; i < T; i++) {
            Nsek = sc.nextLine();
            num = sc.nextLine();

            int ans = solution(Nsek, num);
            System.out.println(ans);
        }
    }

    private static int solution (String Nsek, String num) {
        int N = Integer.parseInt(Nsek.split(" ")[0]);
        int s = Integer.parseInt(Nsek.split(" ")[1]);
        int e = Integer.parseInt(Nsek.split(" ")[2]);
        int k = Integer.parseInt(Nsek.split(" ")[3]);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (i >= s-1 && i <= e-1)
                list.add(Integer.parseInt(num.split(" ")[i]));
        }

        list.sort(null);

        return list.get(k-1);
    }
}
