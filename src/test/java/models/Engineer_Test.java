package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

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

    @Test
    public void equals_returnsTrueIfFirstNameAndEmailAreSame(){
        Engineer firstEngineer = new Engineer("Eric", "[email protected]");
        Engineer anotherEngineer = new Engineer("Eric", "[email protected]");
        assertTrue(firstEngineer.equals(anotherEngineer));
    }

    @Test
    public void save_insertsObjectsIntoDatabase_Engineer() {
        Engineer testEngineer = new Engineer("Eric", "[email protected]");
        testEngineer.save();
        assertTrue(Engineer.all().get(0).equals(testEngineer));
    }



}
