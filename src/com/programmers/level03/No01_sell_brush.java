package com.programmers.level03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class No01_sell_brush {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referal = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        int[] result = solution(enroll, referal, seller, amount);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution (String[] enroll, String[] referral, String[] seller, int[] amount){
        HashMap<String, String> networkCompany = new HashMap<>();
        HashMap<String, Integer> companyDepth = new HashMap<>();

        int[] result = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++){
            networkCompany.put(enroll[i], referral[i]);
            companyDepth.put(enroll[i], i);
        }


        for (int i = 0; i < seller.length; i++){
            Stack<String> dfs = new Stack<>();
            dfs.push(seller[i]);
            int money = amount[i]*100;
            while (!dfs.isEmpty()){
                String clerk = dfs.pop();
                if("-".equals(clerk)){
                    break;
                }
                result[companyDepth.get(clerk)] += money - money/10;
                money = money/10;
                String elder = networkCompany.get(clerk);
                dfs.push(elder);

                if (money < 10){
                    break;
                }
            }
        }
        return result;
    }
}
