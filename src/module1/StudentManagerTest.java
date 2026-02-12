// package src.module1;
// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// public class StudentManagerTest {

//     @Test
//     void testCreate() {
//         StudentManagerLegacy sm = new StudentManagerLegacy();
//         assertNotNull(sm);
//     }
// }


package src.module1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentManagerTest {

    StudentManagerLegacy sm;

    @BeforeEach
    void setUp() {
        sm = new StudentManagerLegacy();
    }

    @Test
    void testCreate() {
        assertNotNull(sm);
    }

    @Test
    void testAddStudent() {
        assertDoesNotThrow(() -> {
            sm.addStudent("101", "Sejal", "CS");
        });
    }

    @Test
    void testMultipleStudents() {
        assertDoesNotThrow(() -> {
            sm.addStudent("201", "A", "IT");
            sm.addStudent("202", "B", "IT");
        });
    }

    @Test
    void testEmptyName() {
        assertDoesNotThrow(() -> {
            sm.addStudent("102", "", "CS");
        });
    }

    @Test
    void testEmptyId() {
        assertDoesNotThrow(() -> {
            sm.addStudent("", "Test", "CS");
        });
    }

    // @Test
    // void testFailExample() {
    //         assertThrows(Exception.class, () -> {
    //         sm.addStudent("101", "Sejal", "CS");
    //     });
    // }

}
