package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No16953_bfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(sToken.nextToken());
        int b = Integer.parseInt(sToken.nextToken());

        System.out.println(bfs(a, b));
    }

    public static int bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.a == b)
                return node.count + 1;

            if (node.a * 2 <= b) queue.add(new Node(node.a * 2, node.count + 1));
            if (node.a*10+1 <= b) queue.add(new Node(node.a * 10 + 1, node.count + 1));
        }
        return -1;
    }
    public static class Node {
        long a;
        int count;

        public Node(long a, int count) {
            this.a = a;
            this.count = count;
        }
    }
}
