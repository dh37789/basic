package com.beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class No02805 {
    int n, m, mid;
    int[] treeArray;
    int max = Integer.MIN_VALUE;
    int min = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(sToken.nextToken());
        m = Integer.parseInt(sToken.nextToken());

        treeArray = new int[n];
        sToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeArray[i] = Integer.parseInt(sToken.nextToken());
            if (max < treeArray[i]) {
                max = treeArray[i];
            }
        }

        binarySearch();

        mid = (max + min)/2;
        bw.write(String.valueOf(mid));
        bw.flush();
        bw.close();
        br.close();
    }

    private void binarySearch() {
        if (min > max) return;

        long tree = cutTree(mid);

        if (tree >= m) {
            min = mid + 1;
        } else {
            max = mid - 1;
        }

        mid = (max + min)/2;
        binarySearch();
    }

    private long cutTree(int mid) {
        long sum = 0;
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i] > mid) sum += treeArray[i] - mid;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new No02805().solution();
    }
}
