package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No02468 {
    static int n;
    static int safeZone;
    static int[][] region;
    static boolean[][] visited;
    static int minWater = 101;
    static int maxWater = -1;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 2차 배열의 범위 */
        n = Integer.parseInt(br.readLine());
        /* 각 높이가 들어갈 땅덩이 */
        region = new int[n][n];
        StringTokenizer sToken;
        for (int i = 0; i < n; i ++) {
            sToken = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                region[i][j] = Integer.parseInt(sToken.nextToken());
                /* 가장 높은 봉우리 이상 물에잠기면 어자피 0이므로
                 * 가장 낮은 높이부터 높은 높이까지 재어준다. */
                minWater = Math.min(minWater, region[i][j]);
                maxWater = Math.max(maxWater, region[i][j]);
            }
        }

        /* 만약 모든 땅덩이의 높이가 0일경우 안전지대는 1 */
        if (minWater == maxWater) {
            safeZone = 1;
        } else {
            /* 낮은 높이부터 높은 높이까지 차례대로 비교를 해준다. */
            for (int k = minWater; k < maxWater; k++) {
                /* bfs/dfs를 위한 방문체킹 */
                visited = new boolean[n][n];
                int count = 0;
                for (int i = 0; i < n; i++){
                    for (int j = 0; j < n; j++) {
                        /* 방문하지 않았거나, 땅의 높이가 물의 높이보다 높을경우 join */
                        if (!visited[i][j] && region[i][j] > k){
                            bfs(i, j, k);
                            count++;
                        }
                    }
                }
                safeZone = Math.max(safeZone, count);
            }
        }
        System.out.println(safeZone);
    }

    /* bfs */
    private static void bfs(int x, int y, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            /* 좌표체킹 */
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dirX[i];
                int ny = node.y + dirY[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[nx][ny] || region[nx][ny] <= k)
                    continue;
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
