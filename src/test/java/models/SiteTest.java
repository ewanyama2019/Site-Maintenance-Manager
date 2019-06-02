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
}
