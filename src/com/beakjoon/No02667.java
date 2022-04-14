package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No02667 {
    static int n;
    static int building;
    static int count;
    static List<Integer> list;
    static boolean[][] visited;
    static int[][] apart;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        apart = new int[n][n];
        for (int i = 0; i < n; i++){
            String line = br.readLine();
            apart[i] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (apart[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                    building++;
                    list.add(count);
                }
            }
        }
        System.out.println(building);
        Collections.sort(list);
        list.forEach(System.out::println);
    }

    public static void bfs (int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x));
        count = 1;
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dirY[i];
                int nx = node.x + dirX[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n ||visited[ny][nx] || apart[ny][nx] == 0)
                    continue;
                queue.offer(new Node(ny, nx));
                visited[ny][nx] = true;
                count++;
            }
        }
    }

    static class Node {
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
