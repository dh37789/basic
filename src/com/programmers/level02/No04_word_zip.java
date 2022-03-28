package com.programmers.level02;

public class No04_word_zip {
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int len = 1;
        int result = s.length();
        while(len <= s.length()/2) {
            StringBuilder builder = new StringBuilder();
            String strSplit = s.substring(0, len);

            int compression = 1;
            for (int j = len; j < s.length(); j += len) {
                String strCompress = s.substring(j, j+len > s.length() ? s.length() : j+len);
                if(strSplit.equals(strCompress)) {
                    compression++;
                } else {
                    builder.append(compression == 1 ? strSplit : compression + strSplit);
                    strSplit = strCompress;
                    compression = 1;
                }
            }
            builder.append(compression == 1 ? strSplit : compression + strSplit);
            result = Math.min(result, builder.toString().length());
            len++;
        }

        return result;
    }
}
