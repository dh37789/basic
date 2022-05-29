package com.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sToken.nextToken());
        int m = Integer.parseInt(sToken.nextToken());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        String checkWords;
        int check = 0;
        for (int i = 0; i < m; i++) {
            checkWords = br.readLine();
            for (int j = 0; j < n; j++) {
                if (checkWords.equals(words[j])){
                    check++;
                    break;
                }
            }
        }

        System.out.println(check);
    }
}
