import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class CountryTest02 {

     /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' tablosundan region_id'si 1 olan ülke adlarını almak üzere sorgu gönderir

    Then
      Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısınınin 8 oldugunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */


    @Test
    public void countryTest() throws SQLException {

        //1-Kullanıcı veritabanına bağlanır

        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        //2-Kullanıcı, 'countries' tablosundan ülke adlarını almak üzere sorgu gönderir

        Statement st = con.createStatement();

        String sql = "SELECT country_name FROM countries WHERE region_id=1";

        ResultSet rs = st.executeQuery(sql);

        //3-  Kullanıcı, 1 nolu bölgeye ait ülkelerin sayısınınin 8 oldugunu doğrular

        int actualData = 0;
        while (rs.next()){
            actualData++;
        }
        int expectedData=8;

        Assert.assertEquals(expectedData, actualData);

        //4- Kullanıcı, bağlantıyı kapatır
        st.close();
        con.close();



    }
}
