package com.beakjoon;

import java.io.*;

public class No01436 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int movieOrderNumber = Integer.parseInt(input.readLine());

        int matchMovieTitle = 1;
        int movieTitle = 666;
        while (true) {
            if (matchMovieTitle == movieOrderNumber)
                break;
            movieTitle++;
            if (String.valueOf(movieTitle).contains("666"))
                matchMovieTitle++;
        }

        output.write(String.valueOf(movieTitle));
        output.flush();
        input.close();
        output.close();
    }
}
