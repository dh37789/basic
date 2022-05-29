package com.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(sToken.nextToken());
        int b = Integer.parseInt(sToken.nextToken());

        int count = 1;
        while(b > a){
            if (b%2 == 0){
                b = b/2;
                count++;
            } else if (b%10 == 1) {
                b = b/10;
                count++;
            } else {
                break;
            }
        }

        System.out.println(a == b ? count : -1);
    }
}
