package com.programmers.level03;

import java.util.Arrays;
import java.util.HashMap;

public class No01_sell_brush_recur {
    private static int[] result;
    private static HashMap<String, String> networkCompany;
    private static HashMap<String, Integer> companyDepth;

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referal = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        int[] result = solution(enroll, referal, seller, amount);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution (String[] enroll, String[] referral, String[] seller, int[] amount){
        networkCompany = new HashMap<>();
        companyDepth = new HashMap<>();

        result = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++){
            networkCompany.put(enroll[i], referral[i]);
            companyDepth.put(enroll[i], i);
        }


        for (int i = 0; i < seller.length; i++){
            int money = amount[i]*100;
            dfs(seller[i], money);
        }

        return result;
    }

    private static void dfs (String clerk, int money) {
        if ("-".equals(clerk)||money < 1){
            return;
        }
        result[companyDepth.get(clerk)] += money - money/10;
        dfs(networkCompany.get(clerk), money / 10);
    }
}
