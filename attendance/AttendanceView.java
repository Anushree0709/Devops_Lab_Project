package attendance;

import java.util.Scanner;

public class AttendanceView {

    static int[] studentIds;
    static String[][] attendanceRecords;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ---- USER INPUT SETUP ----
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        studentIds = new int[n];
        attendanceRecords = new String[n][2];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Student ID: ");
            studentIds[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter date (YYYY-MM-DD): ");
            attendanceRecords[i][0] = sc.nextLine();

            System.out.print("Enter attendance (Present/Absent): ");
            attendanceRecords[i][1] = sc.nextLine();
        }

        // ---- MENU ----
        System.out.println("\n=== Student Attendance Viewing Module ===");
        System.out.println("1. View attendance of one student");
        System.out.println("2. View attendance of all students for a date");
        System.out.print("Enter choice (1 or 2): ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            viewSingleStudent(id);
        } 
        else if (choice == 2) {
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            viewAllStudents(date);
        } 
        else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }

    static void viewSingleStudent(int studentId) {
        boolean found = false;

        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i] == studentId) {
                System.out.println(
                        "Student ID: " + studentIds[i] +
                        " | Attendance: " + attendanceRecords[i][1]
                );
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    static void viewAllStudents(String date) {
        System.out.println("Attendance for date: " + date);
        boolean found = false;

        for (int i = 0; i < studentIds.length; i++) {
            if (attendanceRecords[i][0].equals(date)) {
                System.out.println(
                        "Student ID: " + studentIds[i] +
                        " | Attendance: " + attendanceRecords[i][1]
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No attendance records found for this date.");
        }
    }
}
