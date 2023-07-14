package com.effectiveJava.item63;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringSpeedTest {

    public static void main(String[] args) {
        List<String> stringList = initList();
        useString(stringList);
        useStringBuffer(stringList);
    }

    private static void useString(List<String> stringList) {
        long startTime = System.currentTimeMillis(); // 코드 시작 시간

        String result = "";
        for (int i = 0; i < stringList.size(); i++)
            result += stringList.get(i); /** 문자열 연결 */

        long endTime = System.currentTimeMillis(); // 코드 끝난 시간
        long durationTimeSec = endTime - startTime;
        System.out.println("String: " + durationTimeSec + "m/s"); // 밀리세컨드 출력
        System.out.println("String: " + (durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
    }

    private static void useStringBuffer(List<String> stringList) {
        long startTime = System.currentTimeMillis(); // 코드 시작 시간

        StringBuilder b = new StringBuilder(stringList.size() * 100);
        for (int i = 0; i < stringList.size(); i++)
            b.append(stringList.get(i));

        b.toString();

        long endTime = System.currentTimeMillis(); // 코드 끝난 시간
        long durationTimeSec = endTime - startTime;
        System.out.println("StringBuffer: " + durationTimeSec + "m/s"); // 밀리세컨드 출력
        System.out.println("StringBuffer: " + (durationTimeSec / 1000) + "sec"); // 초 단위 변환 출력
    }

    private static List<String> initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 80;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            list.add(generatedString);
        }
        return list;
    }
}
