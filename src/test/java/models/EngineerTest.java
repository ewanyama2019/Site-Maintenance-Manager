package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class EngineerTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void engineer_InstantiatesCorrectly_true() {
        Engineer testEngineer = new Engineer("Eric","Wanyama", "EK0001", "[email protected]");
        assertEquals(true, testEngineer instanceof Engineer);
    }

    @Test
    public void getFirstName_engineerInstantiatesWithFirstName_Eric() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        assertEquals("Eric", testEngineer.getFirstName());
    }

    @Test
    public void getLastname_engineerInstantiatesWithLastname_String() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        assertEquals("Wanyama", testEngineer.getLasttName());
    }

    @Test
    public void getEk_number_engineerInstantiatesWithEknumber_String() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "eric@eric.com");
        assertEquals("EK0001", testEngineer.getEk_number());
    }

    @Test
    public void getEmail_engineerInstantiatesWithEmail_String() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        assertEquals("[email protected]", testEngineer.getEmail());
    }


    @Test
    public void equals_returnsTrueIfFirstNameAndEmailAreSame(){
        Engineer firstEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        Engineer anotherEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        assertTrue(firstEngineer.equals(anotherEngineer));
    }

    @Test
    public void saveEngineer_insertsObjectsIntoDatabase_Engineer() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
        testEngineer.saveEngineer();
        assertTrue(Engineer.listAllEngineers().get(0).equals(testEngineer));
    }

    @Test
    public void listAll_returnsAllInstancesOfEngineer_true() {
        Engineer firstEngineer = new Engineer("Eric", "Wanyama", "EK0001", "eric@eric.com");
        firstEngineer.saveEngineer();
        Engineer secondEngineer = new Engineer("Mary", "Wamboi", "EK0002", "mary@mary.com");
        secondEngineer.saveEngineer();
        assertEquals(true, Engineer.listAllEngineers().get(0).equals(firstEngineer));
        assertEquals(true, Engineer.listAllEngineers().get(1).equals(secondEngineer));
    }

    @Test
    public void saveEngineer_assignedIdToObject() {
        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "eric@eric.com");
        testEngineer.saveEngineer();
        Engineer savedEngineer = Engineer.listAllEngineers().get(0);
        assertEquals(testEngineer.getId(), savedEngineer.getId());
    }

    @Test
    public void findEngineer_returnsEngineerWithSamaId_secondEngineer() {
        Engineer firstEngineer = new Engineer("Eric", "Wanyama", "EK0001", "eric@eric.com");
        firstEngineer.saveEngineer();
        Engineer secondEngineer = new Engineer("Mary", "Wamboi", "EK0002", "mary@mary.com");
        secondEngineer.saveEngineer();
        assertEquals(Engineer.findEngineer(secondEngineer.getId()), secondEngineer);
    }

//    @Test
//    public void getEngineerSites_retrievesAllSitesFromDatabase_sitesList() {
//        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "eric@eric.com");
//        testEngineer.saveEngineer();
//        Site firstSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", testEngineer.getId());
//        firstSite.saveSite();
//        Site secondSite = new Site("Bombolulu", "CO_0003", "Coast", "Mombasa", testEngineer.getId());
//        secondSite.saveSite();
//        Site[] sites = new Site[] {firstSite, secondSite};
//        assertTrue(testEngineer.getEngineerSites().containsAll(Arrays.asList(sites)));
//    }



}
