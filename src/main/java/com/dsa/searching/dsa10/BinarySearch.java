package com.dsa.searching.dsa10;

public class BinarySearch {

  public static void main(String[] args) {
    int[] a = {4, 8, 9, 10, 13, 14, 16, 20, 30, 90};
    System.out.println(search(a, 8));
    System.out.println(search(a, 90));
    System.out.println(search(a, 95));

    System.out.println(searchR(a, 8, 0, a.length - 1));
    System.out.println(searchR(a, 90, 0, a.length - 1));
    System.out.println(searchR(a, 95, 0, a.length - 1));
  }

  static int search(int[] a, int k) {
    int l = 0, h = a.length - 1;
    while (l <= h) {
      int mid = (l + h) / 2;
      if (a[mid] == k)
        return mid;
      else if (k < a[mid])
        h = mid - 1;
      else
        l = mid + 1;
    }
    return -1;
  }

  static int searchR(int[] a, int k, int l, int h) {
    if (l <= h) {
      int mid = (l + h) / 2;
      if (a[mid] == k)
        return mid;
      else if (k < a[mid])
        return searchR(a, k, l, mid - 1);
      else
        return searchR(a, k, mid + 1, h);
    }
    return -1;
  }
}
