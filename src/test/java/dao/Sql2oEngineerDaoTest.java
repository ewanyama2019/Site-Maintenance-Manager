//package dao;
//
//import models.Engineer;
//import org.sql2o.*;
//import org.junit.*;
//
//import static org.junit.Assert.*;
//
//public class Sql2oEngineerDaoTest {
//    private static Sql2oEngineerDao engineerDao;
//    private static Sql2oSiteDao siteDao;
//    private static Connection conn;
//
//    @Before //run once before running any tests in this file
//    public static void setUp() throws Exception {
//        String connectionString = "jdbc:postgresql://localhost:5432/site_maintenance_test";  // connect to postgres test database
//        Sql2o sql2o = new Sql2o(connectionString, null, null);
//        engineerDao = new Sql2oEngineerDaoTest(sql2o);
//        siteDao = new Sql2oSiteDao(sql2o);
//        conn = sql2o.open(); // open connection once before this test file is run
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        System.out.println("clearing database");
//        engineerDao.clearAllEngineers(); // clear all categories after every test
//        siteDao.clearAllSites(); //clear all tasks after every test
//    }
//
//    @AfterClass // // run once after all tests in this file completed
//    public static void shutDown() throws Exception {
//        conn.close(); // close connection once after this entire test file is finished
//        System.out.println("connection closed");
//    }
//}

