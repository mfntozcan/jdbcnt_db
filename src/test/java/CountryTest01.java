import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest01 {

     /*
    Given = Hazirlik islemlerini ifade eder.
      Kullanıcı veritabanına bağlanır

    When = Eylem ile ilgili islemler.
      Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir

    Then = dogrulamalar(assertion) islemlerinde kullanilir.
      Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular

    And = Kendisinden onceki anahtar kelimenin devamini ifade etmek icin kullanilir.
      Kullanıcı, Bağlantıyı kapatır
    */

    @Test
    public void countryTest() throws SQLException {
        //1-Kullanıcı veritabanına bağlanır

        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        //2-Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir

        Statement st = con.createStatement();

        String sql = "SELECT country_name FROM countries";

        ResultSet rs = st.executeQuery(sql);

        //3-  Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular

        int ulkeSayisi = 0;
        while (rs.next()){
            ulkeSayisi++;
        }

        Assert.assertTrue(ulkeSayisi>0);

        //4-   Kullanıcı, Bağlantıyı kapatır

        st.close();
        con.close();



    }


}
