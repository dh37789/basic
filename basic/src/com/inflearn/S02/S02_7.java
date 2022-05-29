package com.inflearn.S02;


import java.util.Scanner;

//에라토스테네스 체 ( 소수구하는 법 )
// N의 자연수가 주어지면, N만큼의 배열을 만들어냄
// idx는 0이 아닌 1부터 시작
// idx가 1 ~ N까지 값이 0일경우 두번째 반복문에서 해당 idx를 N까지 배수의 수를 구함
// 0인 값만 구하면된다.
public class S02_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = solution(n);
        System.out.println(ans);
    }

    private static int solution (int n) {
        int[] arr = new int[n];
        int answer = 0;
        for (int i = 2; i <= arr.length; i++){
            if (arr[i-1] == 0){
                answer++;
                for (int j = i+1; j <= arr.length; j++){
                    if (j%i == 0){
                        arr[j-1] = ++arr[j-1];
                    }
                }
            }

        }
        return answer;
    }
}
