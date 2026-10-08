import java.util.Scanner;

class Student {
    String studentName;
    String rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public boolean checkEligibility() {
        return marks >= 50.0;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public double calculateScholarship() {
        double totalFee = calculateFee();
        if (marks >= 85.0) {
            return totalFee * 0.20;
        } else if (marks >= 70.0) {
            return totalFee * 0.10;
        } else {
            return 0.0;
        }
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\n----------------------------------------");
        System.out.println("      STUDENT REGISTRATION SUMMARY      ");
        System.out.println("----------------------------------------");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks Obtained : " + marks);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
        System.out.println("Eligibility    : Eligible");
        System.out.println("Total Fee      : Rs. " + calculateFee());
        System.out.println("Scholarship    : Rs. " + calculateScholarship());
        System.out.println("Final Fee      : Rs. " + calculateFinalFee());
        System.out.println("----------------------------------------");
    }
}

public class Hackathon2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter student's full name: ");
        String name = input.nextLine();

        System.out.print("Please enter roll number: ");
        String roll = input.nextLine();

        System.out.print("Please enter marks obtained: ");
        double marks = input.nextDouble();
        input.nextLine(); 

        System.out.print("Please enter course name: ");
        String course = input.nextLine();

        System.out.print("Please enter course credits: ");
        int credits = input.nextInt();

        Student student = new Student(name, roll, marks, course, credits);

        if (student.checkEligibility()) {
            System.out.println("\nGreat news! The student is eligible for registration.");
            student.displayDetails();
        } else {
            System.out.println("\nSorry, the student is not eligible for registration (marks are below 50).");
        }

        input.close();
    }
}