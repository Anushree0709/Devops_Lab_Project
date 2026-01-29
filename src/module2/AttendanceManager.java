package attendance-marking-module;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class AttendanceManager {

    private static HashMap<String, Attendance> attendanceMap = new HashMap<>();

    public static void markAttendance() {
        Scanner sc = new Scanner(System.in);
        String date = LocalDate.now().toString();

        Attendance attendance = attendanceMap.getOrDefault(
                date, new Attendance(date));

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();

            System.out.print("Present or Absent (P/A): ");
            String status = sc.next();

            attendance.markAttendance(roll, status.toUpperCase());
        }

        attendanceMap.put(date, attendance);
        System.out.println("Attendance marked successfully for " + date);
    }

    public static HashMap<String, Attendance> getAttendanceData() {
        return attendanceMap;
    }
}
