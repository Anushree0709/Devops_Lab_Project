// package src.module1;

// import model.Student;
// import java.util.ArrayList;

// class StudentManagerLegacy {
//     private ArrayList<Student> students = new ArrayList<>();

//     public void addStudent(String rollNo, String name, String className) {
//         students.add(new Student(rollNo, name, className));
//     }

//     public ArrayList<Student> getStudents() {
//         return students;
//     }

//     public void displayStudents() {
//         if (students.isEmpty()) {
//             System.out.println("No students available.");
//             return;
//         }

//         System.out.println("Roll No | Name | Class");
//         for (Student s : students) {
//             System.out.println(s);
//         }
//     }
// }


package src.module1;

import model.Student;
import java.util.*;

class StudentManagerLegacy {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(String rollNo, String name, String className) {

        // ✅ validation
        if (rollNo == null || rollNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Roll number cannot be null or empty");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        String r = rollNo.trim();
        String n = name.trim();
        String c = (className == null) ? "" : className.trim();

        // ✅ duplicate check
        for (Student s : students) {
            if (s.getRollNo().equals(r)) {
                throw new IllegalArgumentException(
                        "Student with roll number already exists: " + r);
            }
        }

        students.add(new Student(r, n, c));
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("Roll No | Name | Class");
        students.forEach(System.out::println);
    }
}
