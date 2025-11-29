//Author: Somtirtha Chakraborty
//Reg No: 12211285
//Date : 15.11.2023

package Project;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        // Input number of subjects
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Input names of subjects
        String[] subjectNames = new String[numSubjects];
        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Enter name of Subject " + (j + 1) + ": ");
            subjectNames[j] = sc.nextLine();
        }

        // Store student names, marks, percentages, and grades
        String[] studentNames = new String[numStudents];
        int[][] marks = new int[numStudents][numSubjects];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Input names and marks for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of Student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            int total = 0;
            System.out.println("Enter marks for " + studentNames[i] + ":");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print(subjectNames[j] + ": ");
                marks[i][j] = sc.nextInt();
                total += marks[i][j];
            }
            sc.nextLine(); // consume leftover newline
            percentages[i] = (double) total / numSubjects;
            grades[i] = assignGrade(percentages[i]);
        }

        // Display student results
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.print(studentNames[i] + ": ");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print(subjectNames[j] + "=" + marks[i][j] + " ");
            }
            System.out.println(" | Percentage = " + percentages[i] + "%, Grade = " + grades[i]);
        }

        // Find class average, highest, lowest percentage
        double classTotal = 0;
        double highest = percentages[0];
        double lowest = percentages[0];

        for (int i = 0; i < numStudents; i++) {
            classTotal += percentages[i];
            if (percentages[i] > highest) highest = percentages[i];
            if (percentages[i] < lowest) lowest = percentages[i];
        }


        double classAverage = classTotal / numStudents;

        // Display stats
        System.out.println("\n--- Class Statistics ---");
        System.out.println("Class Average: " + classAverage + "%");
        System.out.println("Highest Percentage: " + highest + "%");
        System.out.println("Lowest Percentage: " + lowest + "%");

        sc.close();
    }

    // Method to assign grades
    public static char assignGrade(double percentage) {
        if (percentage >= 90) return 'A';
        else if (percentage >= 80) return 'B';
        else if (percentage >= 70) return 'C';
        else if (percentage >= 60) return 'D';
        else return 'F';
    }
}
