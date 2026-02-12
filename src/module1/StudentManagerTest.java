package src.module1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentManagerTest {

    @Test
    void testCreate() {
        StudentManagerLegacy sm = new StudentManagerLegacy();
        assertNotNull(sm);
    }
}
