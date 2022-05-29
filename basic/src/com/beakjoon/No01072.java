package com.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No01072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        long x = Integer.valueOf(sToken.nextToken());
        long y = Integer.valueOf(sToken.nextToken());

        long z = y * 100 / x;
        if (z >= 99) System.out.println(-1);
        else {
            long minGame = 0;
            long maxGame = Integer.MAX_VALUE;

            long result = binarySearch(minGame, maxGame, x, y, z);

            System.out.println(result);
        }
    }
    public static long binarySearch(long minGame, long maxGame, long x, long y, long z) {
        while (minGame <= maxGame){
            long mid = (minGame + maxGame)/2;
            if ((y+mid) * 100 / (x+mid) > z){
                maxGame = mid - 1;
            } else {
                minGame = mid + 1;
            }
        }
        return minGame;
    }
}
