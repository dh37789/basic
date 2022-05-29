package com.programmers.level02;

public class No04_word_zip {
    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int len = 1; // 압축할 단어의 길이
        int result = s.length();
        /* 1부터 글자수/2 까지의 탐색을 한다.*/
        while(len <= s.length()/2) {
            StringBuilder builder = new StringBuilder();
            String strSplit = s.substring(0, len);

            // 압축한 단어 수
            int compression = 1;
            for (int j = len; j < s.length(); j += len) {
                // 비교할 단어의 substring 최대 글자 수를 넘지않도록 삼항연산자 추가
                String strCompress = s.substring(j, j+len > s.length() ? s.length() : j+len);
                if(strSplit.equals(strCompress)) {
                    // 글자가 같을경우 압축할 단어 수 +1
                    compression++;
                } else {
                    // 글자가 다를 경우 숫자와 함께 출력
                    builder.append(compression == 1 ? strSplit : compression + strSplit);
                    strSplit = strCompress;
                    compression = 1;
                }
            }
            builder.append(compression == 1 ? strSplit : compression + strSplit);
            // 현재 최소값과 방금 압축한 글자를 비교해서 가장 작은값을 추출
            result = Math.min(result, builder.toString().length());
            len++;
        }

        return result;
    }
}
