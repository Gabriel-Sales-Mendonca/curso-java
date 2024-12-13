package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        Set<Integer> totalStudents = new HashSet<>();

        System.out.print("How many students for course A? ");
        int studentsA = sc.nextInt();
        for(int counter = 0; counter < studentsA; counter++) {
            int studentId = sc.nextInt();
            a.add(studentId);
        }

        System.out.print("How many students for course B? ");
        int studentsB = sc.nextInt();
        for(int counter = 0; counter < studentsB; counter++) {
            int studentId = sc.nextInt();
            b.add(studentId);
        }

        System.out.print("How many students for course C? ");
        int studentsC = sc.nextInt();
        for(int counter = 0; counter < studentsC; counter++) {
            int studentId = sc.nextInt();
            c.add(studentId);
        }

        totalStudents.addAll(a);
        totalStudents.addAll(b);
        totalStudents.addAll(c);

        System.out.println("Total students: " + totalStudents.size());
    }
}