package com.beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No07568 {
    public static class People{
        int weight;
        int stature;

        public People(int weight, int stature) {
            this.weight = weight;
            this.stature = stature;
        }

        public int getWeight() {
            return weight;
        }

        public int getStature() {
            return stature;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<People> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer sToken = new StringTokenizer(br.readLine());
            list.add(new People(Integer.parseInt(sToken.nextToken()), Integer.parseInt(sToken.nextToken())));
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            People people1 = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    People people2 = list.get(j);
                    if (people1.getStature() < people2.getStature() && people1.getWeight() < people2.getWeight()) {
                        answer[i] = ++answer[i];
                    }
                }
            }
            bw.write(String.valueOf(answer[i] + 1));
            bw.write(i < list.size() - 1 ? " " : "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
