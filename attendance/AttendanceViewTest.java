package attendance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AttendanceViewTest {

    private ByteArrayOutputStream out;

    // Runs before EACH test
    @BeforeEach
    void setup() {
        AttendanceView.studentIds = new int[]{101, 102, 103};

        AttendanceView.attendanceRecords = new String[][]{
                {"2026-01-29", "Present"},
                {"2026-01-29", "Absent"},
                {"2026-01-29", "Present"}
        };

        // Capture console output
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    // ---------------- TEST 1 ----------------
    @Test
    void testViewSingleStudentPresent() {
        AttendanceView.viewSingleStudent(101);

        String output = out.toString();
        assertTrue(output.contains("Present"));
        assertTrue(output.contains("Student ID: 101"));
    }

    // ---------------- TEST 2 ----------------
    @Test
    void testViewSingleStudentNotFound() {
        AttendanceView.viewSingleStudent(999);

        String output = out.toString();
        assertEquals("Student not found!\n", output);
    }

    // ---------------- TEST 3 ----------------
    @Test
    void testViewAllStudentsForDate() {
        AttendanceView.viewAllStudents("2026-01-29");

        String output = out.toString();

        assertTrue(output.contains("Student ID: 101"));
        assertTrue(output.contains("Student ID: 102"));
        assertTrue(output.contains("Student ID: 103"));
    }

    // ---------------- TEST 4 (Repeated Test) ----------------
    @RepeatedTest(2)
    void testOutputIsNotNull() {
        AttendanceView.viewSingleStudent(101);
        String output = out.toString();
        assertNotNull(output);
    }
}
