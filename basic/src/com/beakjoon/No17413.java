package com.beakjoon;

import java.io.*;
import java.util.Stack;

public class No17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        solution(input);

        br.close();
    }

    public static String solution (char[] input) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        boolean tag = false;

        for (int i = 0; i < input.length; i++){
            if ('<' == input[i]) {
                write(bw, stack);
                bw.write(input[i]);
                tag = true;
            } else if ('>' == input[i]){
                bw.write(input[i]);
                tag = false;
            } else if(tag){
                bw.write(input[i]);
            } else {
                if(' ' == input[i]){
                    write(bw, stack);
                    bw.write(' ');
                }else {
                    stack.push(input[i]);
                }
            }
        }

        write(bw, stack);
        String answer = bw.toString();
        bw.close();

        return answer;
    }

    public static void write(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while (!stack.isEmpty()){
            bw.write(stack.pop());
        }
    }
}
