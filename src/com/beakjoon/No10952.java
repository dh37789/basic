package com.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer sToken = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(sToken.nextToken()) + Integer.parseInt(sToken.nextToken());
            if (answer == 0) {
                break;
            }
            bw.write("Case #" + (i + 1) + ": " + String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
