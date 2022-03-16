package com.beakjoon;

import java.io.*;
import java.util.Stack;

public class No17413_Sb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        bw.write(solution(input));

        bw.flush();
        br.close();
    }

    public static String solution (char[] input) throws IOException {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        boolean tag = false;

        for (int i = 0; i < input.length; i++){
            if ('<' == input[i]) {
                write(sb, stack);
                sb.append(input[i]);
                tag = true;
            } else if ('>' == input[i]){
                sb.append(input[i]);
                tag = false;
            } else if(tag){
                sb.append(input[i]);
            } else {
                if(' ' == input[i]){
                    write(sb, stack);
                    sb.append(' ');
                }else {
                    stack.push(input[i]);
                }
            }
        }

        write(sb, stack);

        return sb.toString();
    }

    public static void write(StringBuilder sb, Stack<Character> stack) {
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}
