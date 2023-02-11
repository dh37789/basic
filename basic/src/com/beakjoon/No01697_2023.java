package com.beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No01697_2023 {

    public static boolean[] visited;
    public final static int MAX_AREA = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer inputToken = new StringTokenizer(input.readLine());

        int startLocation = Integer.parseInt(inputToken.nextToken());
        int targetLocation = Integer.parseInt(inputToken.nextToken());

        visited = new boolean[MAX_AREA];

        int result = findBrother(startLocation, targetLocation);

        System.out.println(result);
        input.close();
    }

    private static int findBrother(int startLocation, int targetLocation) {
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Node(startLocation, 0));
        visited[startLocation] = true;

        int result = MAX_AREA;
        while (!bfsQueue.isEmpty()) {
            Node node = bfsQueue.poll();
            visited[node.getLocation()] = true;

            if (arriveLocation(targetLocation, node)) {
                result = Math.min(node.getIndex(), result);
            }

            calculateLocation(bfsQueue, node);
        }
        return result;
    }

    private static void calculateLocation(Queue<Node> bfsQueue, Node node) {
        if (node.getLocation() * 2 < MAX_AREA && !visited[node.getLocation()*2])
            bfsQueue.offer(new Node(node.getLocation() * 2, node.getIndexPlusOne()));
        if (node.getLocation() + 1 < MAX_AREA && !visited[node.getLocation()+1])
            bfsQueue.offer(new Node(node.getLocation() + 1, node.getIndexPlusOne()));
        if (node.getLocation() - 1 >= 0 && !visited[node.getLocation()-1])
            bfsQueue.offer(new Node(node.getLocation() - 1, node.getIndexPlusOne()));
    }

    private static boolean arriveLocation(int targetLocation, Node node) {
        return node.getLocation() == targetLocation;
    }

    public static class Node {
        private int location;
        private int index;

        public Node(int n, int index) {
            this.location = n;
            this.index = index;
        }

        public int getLocation() {
            return location;
        }

        public int getIndex() {
            return index;
        }

        public int getIndexPlusOne() {
            return ++index;
        }
    }
}


