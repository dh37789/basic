package com.example.a_sort;

public class SelectSort {

  public static void main(String[] args) {
    int[] arr = {9, 2, 10, 6, 3, 4, 1, 8, 7, 5};

    System.out.println("Before : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    selectSort(arr);

    System.out.println("After : ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  private static void selectSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int tmp = i;
      int tmp2;
      for (int j = i; j < arr.length; j++) {
        if (arr[tmp] > arr[j]) {
          tmp = j;
        }
      }
      tmp2 = arr[i];
      arr[i] = arr[tmp];
      arr[tmp] = tmp2;
    }
  }
}
