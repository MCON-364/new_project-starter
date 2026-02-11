package mcon364.las.touro.edu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testGetUserName(){
        assertTrue(Main.getUserName("USERNAME").isPresent());
        assertEquals(System.getenv("USERNAME"), Main.getUserName("USERNAME").get());
        assertFalse(Main.getUserName("treefrog").isPresent());
    }


    @Test
    void testGetGreeting(){
        assertEquals("Hello, Stranger", Main.getGreeting("HI"));
        assertEquals("Hello, "+System.getenv("USERNAME"), Main.getGreeting("USERNAME"));
    }

    @Test
    void testProcessValues() {
        assertEquals(2, Main.processValues(List.of(
                List.of(1, 2, 3),
                List.of(20, 0, 25),
                List.of(0, 5, 99),
                List.of(45, -600, 1),
                List.of(99, 60, 65),
                List.of(12, 60, 65)
                )
        ));
        assertEquals(0, Main.processValues(new ArrayList<>()));

    }
}
