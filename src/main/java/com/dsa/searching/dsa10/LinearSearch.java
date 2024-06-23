package com.dsa.searching.dsa10;

public class LinearSearch {

  public static void main(String[] args) {
    int a[] = {3, 1, 9, 3, 4, 6, 1};
    // System.out.println(search(a, 4));
    System.out.println(searchR(a, 0, 4));

  }

  static int search(int[] a, int key) {
    int index = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) {
        index = i;
        break;
      }
    }
    return index;
  }

  static int searchR(int[] a, int start, int key) {
    if (start <= a.length) {
      if (a[start] == key)
        return start;
      else
        return searchR(a, ++start, key);
    } else {
      return -1;
    }
  }
}
