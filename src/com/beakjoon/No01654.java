package com.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class No01654 {
    static int n;
    static int requireLan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        n = Integer.parseInt(sToken.nextToken());
        requireLan = Integer.parseInt(sToken.nextToken());

        Long[] lanArr = new Long[n];

        for (int i = 0; i < n; i++) {
            lanArr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lanArr, Collections.reverseOrder());

        long result = binarySearch(lanArr);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static long binarySearch(Long[] lanArr){
        long max = lanArr[0];
        long min  = 1;
        long middle;

        while(max >= min){
            int lanCount = 0;
            middle = (max + min)/2;

            for (int i = 0; i < n; i++){
                lanCount += (int) (lanArr[i]/middle);
            }

            if (lanCount < requireLan) {
                max = middle - 1;
            } else if (lanCount >= requireLan) {
                min = middle + 1;
            }
        }

        return max;
    }
}
