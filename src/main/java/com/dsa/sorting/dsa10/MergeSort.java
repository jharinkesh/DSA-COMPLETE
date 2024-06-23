package com.dsa.sorting.dsa10;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] a = {7, 2, 4, 5, 60, 6, 1};
    mergeSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  static void mergeSort(int[] a, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(a, start, mid);
      mergeSort(a, mid + 1, end);
      merge(a, start, mid, end);
    }
  }

  static void merge(int[] a, int start, int mid, int end) {
    int i = start, j = mid + 1, count = 0;
    int[] b = new int[end - start + 1];
    while (i <= mid && j <= end) {
      b[count++] = a[i] <= a[j] ? a[i++] : a[j++];
    }

    while (i <= mid) {
      b[count++] = a[i++];
    }

    while (j <= end) {
      b[count++] = a[j++];
    }

    for (int x : b) {
      a[start++] = x;
    }
  }

}
