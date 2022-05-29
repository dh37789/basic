package com.algorithm.a_sort;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {9, 2, 10, 6, 3, 4, 1, 8, 7, 5};

    System.out.println("Before : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    bubbleSort(arr);

    System.out.println("After : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int tmp;
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j - 1] > arr[j]) {
          tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }
      }
    }
  }

}
