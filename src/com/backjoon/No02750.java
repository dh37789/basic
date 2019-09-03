package com.backjoon;

import java.util.Scanner;

public class No02750 {
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] arr = new int[t];

    for (int i = 0; i < t; i++)
      arr[i] = sc.nextInt();

    sc.close();
    arr = bubble(arr);
    arr = insert(arr);
    arr = select(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  // 선택정렬
  private static int[] select(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      int min = i;
      int tmp;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[min] > arr[j]) {
          min = j;
        }
      }
      tmp = arr[min];
      arr[min] = arr[i];
      arr[i] = tmp;
    }
    return arr;
  }

  // 삽입정렬
  private static int[] insert(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      for (j = i - 1; j >= 0; j--) {
        if (key < arr[j]) {
          arr[j+1] = arr[j];
        }else{
          break;
        }
      }
      arr[j+1] = key;
    }
    return arr;
  }

  // 버블정렬
  private static int[] bubble(int[] arr) {
    int tmp;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length-i; j++) {
        if (arr[j-1] > arr[j]) {
          tmp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = tmp;
        }
      }
    }
    return arr;
  }
}
