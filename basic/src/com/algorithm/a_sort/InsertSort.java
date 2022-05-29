package com.algorithm.a_sort;

public class InsertSort {

  public static void main(String[] args) {
    int[] arr = {4, 6, 10, 9, 1, 3, 8, 7, 5, 2};

    System.out.println("Before : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    insertSort(arr);

    System.out.println("After : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static void insertSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int tmp = arr[i];
      int j = i - 1;
      while ((j >= 0) && (arr[j] > tmp)) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;
    }
  }
}
