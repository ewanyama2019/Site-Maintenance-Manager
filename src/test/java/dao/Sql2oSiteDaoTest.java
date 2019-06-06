package dao;

import models.DB;
import models.Site;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class Sql2oSiteDaoTest {

    private Sql2oSiteDao siteDao;
    private Connection conn;    //must be sql2o class conn

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/site_maintenance_test";
        DB.sql2o = new Sql2o(connectionString, "postgres", "wanyama123");
        siteDao = new Sql2oSiteDao(DB.sql2o); //ignore me for now
        conn = DB.sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingSiteSetsId() throws Exception {
        Site site = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        int originalSiteId = site.getId();
        siteDao.saveSite(site);
        assertNotEquals(originalSiteId, site.getId());
    }

    @Test
    public void existingSitesCanBeFoundById() throws Exception {
        Site site = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        siteDao.saveSite(site);  //add to dao (takes care of saving)
        Site foundSite = siteDao.findSite(site.getId());
        assertEquals(site, foundSite); //should be the same
    }

    @Test
    public void existingSiteCanAllBeListedFromlistAllSites() throws Exception {
        Site site = new Site("Sabasaba", "CO_0002", "Coast", "Mombasa", 1);
        siteDao.saveSite(site);
        assertEquals(5, siteDao.listAllSites().size());
    }

    @Test
    public void withNoSiteSavedReturnsEmptyList() throws Exception {
        assertEquals(0, siteDao.listAllSites().size());
    }

//    @Test
//    public void updateSiteProperties() throws Exception {
//        String initialSiteProperties = "\"Sabasaba\", \"CO_0002\", \"Coast\", \"Mombasa\", 1";
//        Site site = new Site(initialSiteProperties);
//        siteDao.saveSite(site);
//        siteDao.updateSite(site.getId(), "Bombolulu", "CO_0003", "Coast", "Mombasa", 3);
//        Site updatedSite = siteDao.findSite(site.getId()); //why do I need to refind this?
//        assertNotEquals(initialSiteProperties, updatedSite.getSiteName());
//    }





}
