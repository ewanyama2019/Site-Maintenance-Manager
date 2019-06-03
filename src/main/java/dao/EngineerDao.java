package dao;

import models.Engineer;
import models.Site;
import java.util.List;

public class EngineerDao {

    //LIST ALL ENGINEERS
    List<Engineer> all();

    // SAVE TO DATABASE
    void save();

    // READ ENGINEER BY ID
    Engineer find(int id);

    // READ SITE BY ENGINEER ID
    List<Site> getSites();

    // CREATE


    //UPDATE

    // DELETE
    //void deleteById(int id);
    //void clearAllEngineers();





}
