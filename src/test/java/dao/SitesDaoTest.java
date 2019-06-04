//package dao;
//
//import org.junit.Test;
//import models.Site;
//import org.mozilla.javascript.EcmaError;
//import org.sql2o.*;
//import org.junit.*;
//
//import static org.junit.Assert.*;
//
//public class SitesDaoTest {
//
//    @Test
//    public void addingSiteSetsId() throws Exception {
//        Site site = new Site("Tudor Mvita", 1);
//        int originalSiteId = site.getId();
//        siteDao.add(site);
//        assertNotEquals(originalSiteId, site.getId());
//    }
//
//    @Test   // READ SITES BY ID find(int id)
//    public void existingSitesCanBeFoundById() {
//        Site site = new Site("Tudor Mvita", 1);
//        siteDao.add(site); //add to dao (takes care of saving)
//        Site foundSite = siteDao.findById(site.getId()); //retrieve
//        assertEquals(task, foundSite); //should be the same
//    }
//}
