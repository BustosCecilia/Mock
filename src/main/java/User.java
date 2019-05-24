/*
 ID               int64  `json:"id"`
    Nickname         string `json:"nickname"`
    RegistrationDate string `json:"registration_date"`
    CountryID        string `json:"country_id"`
    Email            string `json:"email"`
    SiteID           string      `json:"site_id"`
 */

public class User {
    int ID;
    String nickname;
    String registration_date;
    String country_id;
    String email;
    String site_id;

    public User(int ID) {
        this.ID = ID;
        nickname = "Ceci";
        registration_date = "2011-09-05T12:00:00.000-04:00";
        country_id = "AR";
        email = "ceciliabus@gmail.com";
        site_id = "MLA";
    }
}
