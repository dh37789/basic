package com.beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No09372 {
    private static Graph graph;
    static int result;
    static Queue<Node> queue;

    private static class Node {
        private int item;
        private LinkedList<Node> adj;
        private boolean visit;

        public Node(int data){
            this.item = data;
            adj = new LinkedList<>();
            visit = false;
        }
    }

    private static class Graph{
        private Node[] nodes;

        private Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++){
                nodes[i] = new Node(i+1);
            }
        }

        private void addEdge(int land1, int land2){
            Node node1 = nodes[land1-1];
            Node node2 = nodes[land2-1];
            if (!node1.adj.contains(node2)){
                node1.adj.add(node2);
            }
            if (!node2.adj.contains(node1)){
                node2.adj.add(node1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            StringTokenizer sToken = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(sToken.nextToken());
            int m = Integer.parseInt(sToken.nextToken());

            result = 0;

            graph = new Graph(n);

            for (int j = 0; j < m; j++) {
                sToken = new StringTokenizer(br.readLine());
                graph.addEdge(Integer.parseInt(sToken.nextToken()), Integer.parseInt(sToken.nextToken()));
            }

            bfs();
            bw.write(String.valueOf(result-1));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        Node root = graph.nodes[0];
        queue = new LinkedList<>();

        queue.add(root);
        root.visit = true;

        while (!queue.isEmpty()){
            result++;
            Node r = queue.poll();
            for (Node n : r.adj){
                if (!n.visit){
                    n.visit = true;
                    queue.add(n);
                }
            }
        }
    }
}
