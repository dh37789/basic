package com.programmers.level01;

import java.util.*;
import java.util.stream.Collectors;

public class No29_Kakao_Send_Report_Result {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(solution(id_list, report, k));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> reportDetail = Arrays.stream(id_list).distinct().collect(Collectors.toMap(s -> s,key -> new HashSet<>()));
        Map<String, Integer> mail_count = Arrays.stream(id_list).distinct().collect(Collectors.toMap(s -> s, s -> 0, (e1, e2) -> e1, LinkedHashMap::new));

        for (String reportStr : report){
            StringTokenizer sToken = new StringTokenizer(reportStr);
            String send = sToken.nextToken();
            String recieve = sToken.nextToken();
            reportDetail.get(recieve).add(send);
        }

        for (String id : id_list) {
            if (reportDetail.get(id).size() >= k) {
                for(String send : reportDetail.get(id)){
                    int reportCount = mail_count.get(send);
                    mail_count.put(send, reportCount+1);
                }
            }
        }

        int[] answer = new int[mail_count.size()];
        int idx = 0;
        for (String key : mail_count.keySet()){
            answer[idx] = mail_count.get(key);
            idx++;
        }

        return answer;
    }
}
