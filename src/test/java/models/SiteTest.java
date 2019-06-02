package models;

import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class SiteTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void site_instantiatesCorrectly_True() {
        Site testSite = new Site("Sabasaba", 1);
        assertEquals(true, testSite instanceof Site);
    }

    @Test
    public void Site_InstantiatesWithName_String() {
        Site testSite = new Site("Sabasaba", 1);
        assertEquals("Sabasaba", testSite.getName());
    }

    @Test
    public void Site_InstantiatesWithEngineerId_int() {
        Site testSite = new Site("Sabasaba", 1);
        assertEquals(1, testSite.getEngineerId());
    }

    @Test
    public void equals_returnsTrueIfNameAndEngineerIdAreSame_true() {
        Site testSite = new Site("Sabasaba", 1);
        Site anotherSite = new Site("Sabasaba", 1);
        assertTrue(testSite.equals(anotherSite));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        Site testSite = new Site("Sabasaba", 1);
        testSite.save();
        assertTrue(Site.all().get(0).equals(testSite));
    }

    @Test
    public void save_assignsIdtoSite() {
        Site testSite = new Site("Sabasaba", 1;
        testSite.save();
        Site savedSite = Site.all().get(0);
        assertEquals(savedSite.getID(), testSite.getId();

    }

    @Test
    public void all_returnsAllInstancesOfSItes_true() {
        Site firstSite = new Site("Sabasaba", 1);
        firstSite.save();
        Site secondSite = new Site("Bombolulu", 1);
        secondSite.save();
        assertEquals(true, Site.all().get(0).equals(firstSite));
        assertEquals(true, Site.all().get(1).equals(secondSite));

    }
}
