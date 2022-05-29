package com.beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No01021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sToken.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int m = Integer.parseInt(sToken.nextToken());

        int count = 0;
        sToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            int number = Integer.parseInt(sToken.nextToken());
            while (true) {
                int tmpNumber = queue.getFirst();
                if (number == tmpNumber){
                    queue.removeFirst();
                    break;
                }

                int stand = queue.indexOf(number);
                if (stand < queue.size()/2) {
                    count++;
                    moveLeft(queue);
                } else if (stand >= queue.size()/2) {
                    count++;
                    moveRight(queue);
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void moveRight(LinkedList<Integer> queue) {
        int number = queue.getLast();
        queue.removeLast();
        queue.addFirst(number);
    }

    private static void moveLeft(LinkedList<Integer> queue) {
        int number = queue.getFirst();
        queue.removeFirst();
        queue.addLast(number);
    }
}
