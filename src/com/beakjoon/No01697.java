package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No01697 {
    static boolean[] visited;
    static int result;
    static int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(sToken.nextToken());
        int k = Integer.parseInt(sToken.nextToken());

        bfs(n, k);
        System.out.println(result);
    }

    private static void bfs(int n, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(n, 0));

        visited = new boolean[max+1];
        visited[n] = true;

        result = max;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.n] = true;

            if (node.n == k)
                result = Math.min(result, node.index);

            if (node.n * 2 <= max && visited[node.n*2] == false) {
                queue.offer(new Node(node.n * 2, node.index + 1));
            }
            if (node.n + 1 <= max && visited[node.n+1] == false) {
                queue.offer(new Node(node.n + 1, node.index + 1));
            }
            if (node.n - 1 >= 0 && visited[node.n-1] == false) {
                queue.offer(new Node(node.n - 1, node.index + 1));
            }
        }
    }

    private static class Node {
        int n;
        int index;

        public Node(int n, int index) {
            this.n = n;
            this.index = index;
        }
    }
}
