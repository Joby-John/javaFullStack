package com.joby.markgrade;

import java.util.Scanner;

import com.joby.markgrade.Grader;

public class Main {
    public static void main(String[] args) {
        var grader = new Grader();
        int mark;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the marks");
            mark = sc.nextInt();
            System.out.println("Your grade is : " + grader.determineLetterGrade(mark));
            
        } catch (Exception e) {
            System.err.println("Invalid Input : " + e.getMessage());
        }
    }
}