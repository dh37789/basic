package com.inflearn.S02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
public class S02_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int idx = sc.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= num; i++) {
            if (num%i == 0)
                list.add(i);
        }

        if (list.size() < idx) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(idx-1));
        }
    }
}
