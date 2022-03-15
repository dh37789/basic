package com.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No01920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        if (n > 0) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer sToken = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            bw.write(binarySearch(arr, Integer.parseInt(sToken.nextToken()), 0, arr.length-1));
            bw.flush();
            bw.newLine();
        }

        bw.close();
        br.close();

    }

    private static String binarySearch(int[] arr, int data, int start, int end) {

        if (start > end) {
            return "0";
        }

        int mid = (start + end) / 2;

        if (arr[mid] == data) {
            return "1";
        } else if (arr[mid] > data) {
            return binarySearch(arr, data, start, mid-1);
        } else if (arr[mid] < data) {
            return binarySearch(arr, data, mid+1, end);
        }
        return "0";
    }
}
