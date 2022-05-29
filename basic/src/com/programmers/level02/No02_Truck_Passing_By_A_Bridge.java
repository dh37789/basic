package com.programmers.level02;

/**
 * 다리를 지나가는 트럭
 * link : https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class No02_Truck_Passing_By_A_Bridge {

  public static void main(String[] args) {
    int bridge_length = 100;
    int weight = 100;
    int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    System.out.println(solution(bridge_length, weight, truck_weights));
  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int real_weight = 0;
    int front = 0;
    int driving_front = 0;
    Truck[] trucks = new Truck[truck_weights.length];
    while (truck_weights.length > front || trucks.length > driving_front) {
      answer++;
      if (front < truck_weights.length && real_weight + truck_weights[front] <= weight) {
        Truck truck = new Truck(truck_weights[front], 0);
        real_weight += truck.weight;
        trucks[front] = truck;
        front++;
      }
      for (int i = driving_front; i < front; i++) {
        trucks[i].sec++;
        if (trucks[i].sec == bridge_length) {
          real_weight -= trucks[i].weight;
          driving_front++;
        }
      }
    }
    answer++;
    return answer;
  }

  public static class Truck {

    int weight = 0;
    int sec = 0;

    public Truck(int weight, int sec) {
      this.weight = weight;
      this.sec = sec;
    }
  }
}
