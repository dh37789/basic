package com.programmers.level02;

public class No04_word_zip {
    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int half = s.length()/2;
        int len = 1;
        String minStr = s;
        while(len <= half) {
            StringBuilder builder = new StringBuilder();
            String strSplit = s.substring(0, len);

            int compression = 1;
            for (int j = len; j < s.length(); j += len) {
                String strCompress = s.substring(j, j+len > s.length() ? s.length() : j+len);
                if(strSplit.equals(strCompress)) {
                    compression++;
                } else {
                    if (compression != 1){
                        builder.append(compression + strSplit);
                        compression = 1;
                    } else {
                        builder.append(strSplit);
                    }
                    strSplit = strCompress;
                }
            }
            if (compression != 1){
                builder.append(compression + strSplit);
            } else {
                builder.append(strSplit);
            }
            if (minStr.length() > builder.toString().length()){
                minStr = builder.toString();
            }

            len++;
        }

        return minStr.length();
    }
}
