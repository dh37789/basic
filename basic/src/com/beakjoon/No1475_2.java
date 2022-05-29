package com.beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class No1475_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] card = new double[9];
        String roomNo = br.readLine();

        for(String numStr : roomNo.split("")) {
            int number = Integer.parseInt(numStr);
            if (number == 6||number == 9) {
                card[6] += 0.5;
            } else {
                card[number] = card[number] + 1.0;
            }
        }

        int[] cardInt = DoubleStream.of(card).mapToInt(arr -> (int) Math.ceil(arr)).toArray();
        Arrays.sort(cardInt);
        bw.write(String.valueOf(cardInt[8]));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
