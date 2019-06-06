package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;



public class SiteTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void site_instantiatesCorrectly_True() {
        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        assertEquals(true, testSite instanceof Site);
    }

    @Test
    public void Site_InstantiatesWithSiteName_String() {
        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        assertEquals("Sabasaba", testSite.getSiteName());
    }

    @Test
    public void Site_InstantiatesWithEngineerId_int() {
        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        assertEquals(1, testSite.getEngineerId());
    }

    @Test
    public void equals_returnsTrueIfSiteNameAndEngineerIdAreSame_true() {
        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        Site anotherSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        assertTrue(testSite.equals(anotherSite));
    }

//    @Test
//    public void saveSite_returnsTrueIfDescriptionsAretheSame() {
//        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
//        testSite.saveSite();
//        assertTrue(Site.listAllSites().get(0).equals(testSite));
//    }
//
//    @Test
//    public void saveSite_assignsIdToSite() {
//        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
//        testSite.saveSite();
//        Site savedSite = Site.listAllSites().get(0);
//        assertEquals(savedSite.getId(), testSite.getId());
//
//    }
//
//    @Test
//    public void listAllSites_returnsAllInstancesOfSites_true() {
//        Site firstSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
//        firstSite.saveSite();
//        Site secondSite = new Site("Bombolulu", "CO_0003", "Coast", "Mombasa", 1);
//        secondSite.saveSite();
//        assertEquals(true, Site.listAllSites().get(0).equals(firstSite));
//        assertEquals(true, Site.listAllSites().get(1).equals(secondSite));
//
//    }
//
//    @Test
//    public void findSite_returnSiteWithSameId_secondSite() {
//        Site firstSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
//        firstSite.saveSite();
//        Site secondSite = new Site("Bombolulu", "CO_0003", "Coast", "Mombasa", 3);
//        secondSite.saveSite();
//        assertEquals(Site.findSite(secondSite.getId()), secondSite);
//    }
//
//    @Test
//    public void saveSite_savesEngineerIDIntoDB_true() {
//        Engineer testEngineer = new Engineer("Eric", "Wanyama", "EK0001", "[email protected]");
//        testEngineer.saveEngineer();
//        Site testSite = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", testEngineer.getId());
//        testSite.saveSite();
//        Site savedSite = Site.findSite(testSite.getId());
//        assertEquals(savedSite.getEngineerId(), testEngineer.getId());
//    }




}
