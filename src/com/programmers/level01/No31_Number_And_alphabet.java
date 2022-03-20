package com.programmers.level01;

public class No31_Number_And_alphabet {
    public static void main(String[] args) {
        String s = "........";
        int num = solution(s);
        System.out.println(num);
    }

    private static int solution(String s) {
        s = s.replaceAll("zero", "0")
                .replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9");

        return Integer.parseInt(s);
    }
}
