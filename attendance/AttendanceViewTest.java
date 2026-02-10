package attendance;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AttendanceViewTest {

    // Helper method to set test data
    void setTestData() {
        AttendanceView.studentIds = new int[]{101, 102, 103};

        AttendanceView.attendanceRecords = new String[][]{
                {"2026-01-29", "Present"},
                {"2026-01-29", "Absent"},
                {"2026-01-29", "Present"}
        };
    }

    @Test
    void testViewSingleStudentPresent() {
        setTestData();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        AttendanceView.viewSingleStudent(101);

        String output = out.toString();
        assertTrue(output.contains("Present"));
    }

    @Test
    void testViewSingleStudentNotFound() {
        setTestData();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        AttendanceView.viewSingleStudent(999);

        String output = out.toString();
        assertTrue(output.contains("Student not found"));
    }

    @Test
    void testViewAllStudentsForDate() {
        setTestData();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        AttendanceView.viewAllStudents("2026-01-29");

        String output = out.toString();
        assertTrue(output.contains("Student ID: 101"));
        assertTrue(output.contains("Student ID: 102"));
        assertTrue(output.contains("Student ID: 103"));
    }
}
