package attendance-marking-module;

import java.util.HashMap;

public class Attendance {
    private String date;
    private HashMap<Integer, String> studentAttendance;

    public Attendance(String date) {
        this.date = date;
        studentAttendance = new HashMap<>();
    }

    public void markAttendance(int rollNo, String status) {
        studentAttendance.put(rollNo, status);
    }

    public HashMap<Integer, String> getStudentAttendance() {
        return studentAttendance;
    }

    public String getDate() {
        return date;
    }
}
