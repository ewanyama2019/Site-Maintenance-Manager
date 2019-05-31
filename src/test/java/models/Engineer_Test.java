package models;

import org.junit.*;
import static org.junit.Assert.*;

public class Engineer_Test {
    @Test
    public void engineer_InstantiatesCorrectly_true() {
        Engineer testEngineer = new Engineer("Eric", "[email protected]");
        assertEquals(true, testEngineer instanceof Engineer);
    }

    @Test
    public void getFirstName_engineerInstantiatesWithFirstName_Eric() {
        Engineer testEngineer = new Engineer("Eric", "[email protected]");
        assertEquals("Eric", testEngineer.getFirstName());
    }

    @Test
    public void getEmail_engineerInstantiatesWithEmail_String() {
        Engineer testEngineer = new Engineer("Eric", "[email protected]");
        assertEquals("[email protected]", testEngineer.getEmail());
    }
}