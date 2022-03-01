package com.programmers.level02;

import java.util.*;

public class No03_Delevlop {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] answer = solution(progresses, speeds);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++){
            int progress = progresses[i];
            while (progress < 100){
                progress = progress + speeds[i];
                day[i] = ++day[i];
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < day.length; i++) {
            queue.add(day[i]);
        }

        int size = queue.size();
        int dayCount = queue.poll();
        int prod = 1;
        List<Integer> dayList = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            int tmp = queue.poll();

            if (dayCount < tmp){
                dayList.add(prod);

                prod = 1;
                dayCount = tmp;
            } else {
                prod++;
            }
        }
        dayList.add(prod);

        return dayList.stream().filter(i->i!=0).mapToInt(i->i).toArray();
    }
}
