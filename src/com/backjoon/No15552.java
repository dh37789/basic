package com.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *  빠른 A+B
 */
public class No15552 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());
    for (int i = 0; i < num; i++) {
      String a = br.readLine();
      String[] b = a.split(" ");
      int c = Integer.parseInt(b[0]) + Integer.parseInt(b[1]);
      bw.write(c+"\n");
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
