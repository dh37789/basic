package com.inflearn.S03;

import java.util.Arrays;
import java.util.Scanner;

public class S03_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sdoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        String ans = solution(sdoku);
        System.out.println(ans);
    }

    private static String solution(int[][] sdoku) {
        

        for (int i = 0; i < 9; i++){
            // 가로
            boolean[] hor = new boolean[9];
            boolean[] ver = new boolean[9];
            Arrays.fill(hor, false);
            Arrays.fill(ver, false);
            for(int j = 0; j < 9; j++){
                if (hor[sdoku[i][j]-1] == true){
                    return "NO";
                } else {
                    hor[sdoku[i][j]-1] = true;
                }
                if (ver[sdoku[j][i]-1] == true){
                    return "NO";
                } else {
                    ver[sdoku[j][i]-1] = true;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                boolean[] squ = new boolean[9];
                Arrays.fill(squ, false);
                for (int k = 0; k < 3; k++){
                    for (int l = 0; l < 3; l++){
                        if (squ[sdoku[i*3+k][j*3+l]-1] == true){
                            return "NO";
                        } else {
                            squ[sdoku[i*3+k][j*3+l]-1] = true;
                        }
                    }
                }
            }
        }
        return "YES";
    }
}
