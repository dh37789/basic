package com.algorithm.b_search;

public class Search {

  public static void main(String[] args) {
    int[] arr = {1, 12, 22, 34, 35, 85, 98, 100, 101, 150};

    int key = 101;
    int result = linearSearch(arr, key);

    if (result == -1) {
      System.out.println("검색한 결과값이 없습니다.");
    } else {
      System.out.println("검색하신 결과는 " + (result + 1) + "번째에 위치해 있습니다.");
    }

    int start = 1;
    int end = 10;
    result = binarySearch(arr, key, start, end);

    if (result == -1) {
      System.out.println("검색한 결과값이 없습니다.");
    } else {
      System.out.println("검색하신 결과는 " + (result + 1) + "번째에 위치해 있습니다.");
    }
  }

  private static int linearSearch(int[] arr, int key) {

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        return i;
      }
    }

    return -1;
  }

  private static int binarySearch(int[] arr, int key, int start, int end) {

    if (start > end) {
      return -1;
    }

    int mid = (start + end) / 2;

    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] > key) {
      return binarySearch(arr, key, start, mid - 1);
    } else if (arr[mid] < key) {
      return binarySearch(arr, key, mid + 1, end);
    }

    return -1;
  }
}
