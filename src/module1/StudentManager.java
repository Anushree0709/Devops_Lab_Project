package module;

import model.Student;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String rollNo, String name, String className) {
        students.add(new Student(rollNo, name, className));
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("Roll No | Name | Class");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
