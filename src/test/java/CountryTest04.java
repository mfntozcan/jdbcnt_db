import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.JdbcLocalDBUtils.closeConnection;
import static utils.JdbcLocalDBUtils.executeQuery;

public class CountryTest04 {

         /*
    Given
      Kullanıcı veritabanına bağlanır

    When
      Kullanıcı, 'countries' table'dan region id'leri almak üzere query gönderir

    Then
      Kullanıcı, 1'den büyük region id'lerin sayısının 17 olduğunu doğrular

    And
      Kullanıcı, bağlantıyı kapatır
    */

    /*
    1nci yol

     @Test
    public void countryTest() throws SQLException {
        String sql ="select region_id from countries where region_id>1";

        ResultSet resultSet = executeQuery(sql);

        int expectedData=17;
        int actualData = 0;

        while (resultSet.next()){
            actualData++;
        }

        Assert.assertEquals(17, actualData);

        closeConnection();
    }
     */

    @Test
    public void countryTest02() throws SQLException {
        String sql ="select count(*) from countries where region_id>1";

        ResultSet resultSet = executeQuery(sql);
        resultSet.next();
        int actualData = resultSet.getInt("count");
        int expectedData = 17;

        Assert.assertEquals(expectedData, actualData);

        closeConnection();


    }
}
