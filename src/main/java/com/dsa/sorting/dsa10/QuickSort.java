package com.dsa.sorting.dsa10;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] a = {8, 3, 2, 4, 5, 3, 9};
    qsort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  static void qsort(int[] a, int start, int end) {
    if (start < end) {
      int p = partition(a, start, end);
      qsort(a, start, p - 1);
      qsort(a, p + 1, end);
    }
  }

  static int partition(int[] a, int start, int end) {
    int pi = start;
    for (int i = start; i < end; i++) {
      if (a[i] <= a[end]) {
        swap(a, i, pi++);
      }
    }
    swap(a, pi, end);
    return pi;
  }

}
