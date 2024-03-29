package com.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No07576 {
    static int m, n;
    static int[][] tomatoBox;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sToken = new StringTokenizer(br.readLine());

        m = Integer.parseInt(sToken.nextToken());
        n = Integer.parseInt(sToken.nextToken());

        /* 토맛토를 상자에 넣어준다. */
        tomatoBox = new int[n][m];
        for (int i = 0; i < n; i++) {
            tomatoBox[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        /* 잘~ 익은 토마토를 선별해 Queue에 넣어준다. */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoBox[i][j] == 1){
                    queue.offer(new Node(i, j));
                }
            }
        }
        /* 숙성 시작 */
        bfs();

        /* 토마토가 전부 익는 max일자 계산 */
        System.out.println(getMaxDay());
    }

    private static void bfs() {
        while (!queue.isEmpty()){
            Node node = queue.poll();

            /* 주어진 좌표를 기준으로 상하좌우 탐색 및 값 치환 */
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dirY[i];
                int nx = node.x + dirX[i];

                if (ny < 0 || nx < 0 || nx >= m || ny >= n || tomatoBox[ny][nx] != 0)
                    continue;

                tomatoBox[ny][nx] = tomatoBox[node.y][node.x] + 1;
                queue.offer(new Node(ny, nx));
            }
        }
    }

    private static int getMaxDay() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoBox[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, tomatoBox[i][j]);
            }
        }
        return max - 1;
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
