package com.algorithm.b_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static void main(String[] args) {
//    2	10 {7,4,5,6}
//    100	100	{10}
//    100	100	{10,10,10,10,10,10,10,10,10,10}
    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = {7, 4, 5, 6};
    System.out.println(solution(bridge_length, weight, truck_weights));
  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int real_weight = 0;
    int front = 0;
    int driving_front = 0;
    int[] driving_truck = new int[truck_weights.length];
    List<Truck> trucks = new ArrayList<>();
    while (truck_weights.length > front || driving_truck.length >= driving_front) {
      answer++;
      if (front < truck_weights.length){
        if (real_weight + truck_weights[front] < weight) {
          Truck truck = new Truck(truck_weights[front], 0);
          trucks.add(truck);
          real_weight += truck_weights[front];
          driving_truck[driving_front] = truck_weights[front];
          front++;
        }
      }

      List<Truck> remove = new ArrayList<Truck>();
      for (Truck truck : trucks){
        int sec = truck.getSec();
        truck.setSec(++sec);
        if (sec == bridge_length){
          real_weight -= truck.getWeight();
          driving_front++;
          remove.add(truck);
        }
      }

      for (Truck truck : remove) {
        trucks.remove(truck);
      }

    }
    return answer;
  }

  public static class Truck {
    int weight = 0;
    int sec = 0;

    public Truck(int weight, int sec) {
      this.weight = weight;
      this.sec = sec;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public int getSec() {
      return sec;
    }

    public void setSec(int sec) {
      this.sec = sec;
    }
  }
}
