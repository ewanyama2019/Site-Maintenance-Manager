package dao;

import models.Engineer;
import models.Site;
import java.util.List;

public interface SiteDao {

    //LIST ALL SITES
    List<Site> listAllSites();

    // CREATE :SAVE TO DATABASE
    void saveSite(Site site);

    // READ SITES BY ID
    Site findSite(int id);

//    // UPDATE
//    void updateSite();

    // DELETE SITE BY ID
    void deleteSitesById(int id);


    // DELETE ALL SITES
    void ClearAllSites();

}
