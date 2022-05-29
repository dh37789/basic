package com.beakjoon;

import java.io.*;
import java.util.Arrays;

public class No01978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        if (n > 0){
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++){
            int tmp = arr[i];
            boolean prime = true;
            if (tmp == 1){
                continue;
            }

            int sqrt = (int)Math.sqrt(tmp);
            for (int j = sqrt; j > 1; j--) {
                if(tmp%j == 0){
                    prime = false;
                    break;
                }
            }

//            for (int j = tmp-1; j > 1; j--){
//                if(tmp%j == 0){
//                    prime = false;
//                    break;
//                }
//            }
            if (prime){
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
