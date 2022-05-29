package com.programmers.level01;

public class No30_Kakao_New_ID {
    public static void main(String[] args) {
        String new_id = "........";
        String id = solution(new_id);
        System.out.println(id);
    }

    private static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^0-9a-z-_.]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        if(new_id.isEmpty()) new_id = "a";
        if(new_id.length() > 15)
            new_id = new_id.substring(0, 15).replaceAll("[.]$", "");
        if(new_id.length() <= 2) {
            while (new_id.length() < 3)
                new_id += new_id.charAt(new_id.length() - 1);
        };

        return new_id;
    }
}
