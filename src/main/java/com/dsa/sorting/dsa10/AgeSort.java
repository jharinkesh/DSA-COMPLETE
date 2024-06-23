package com.dsa.sorting.dsa10;

import java.util.Arrays;

public class AgeSort {

    public static void main(String[] args) {
	Student[] s = { new Student("baba", 28), new Student("ravi", 21), new Student("hari", 25),
		new Student("rama", 27) };
	System.out.println(Arrays.deepToString(s));
	Arrays.parallelSort(s);
	System.out.println(Arrays.deepToString(s));
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
	this.name = name;
	this.age = age;
    }

    @Override
    public int compareTo(Student o) {
	return this.age - o.age;
    }

    @Override
    public String toString() {
	return "[" + name + "," + age + "]";
    }

}