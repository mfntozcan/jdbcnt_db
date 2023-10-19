import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.JdbcMedunnaDBUtils.closeConnection;
import static utils.JdbcMedunnaDBUtils.executeQuery;

public class MedunnaTest {
    /*
   Given
     Kullanıcı veritabanına bağlanır
     (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))

   When
     Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir

   Then
     Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular

   And
     Kullanıcı, bağlantıyı kapatır
  */


    @Test
    public void medunnaTest() throws SQLException {
        // Expected Datalar
        int expectedRoomNumber = 72132940;
        String expectedRoomType = "SUITE";
        boolean expectedStatus = true;
        double expectedPrice = 5000.00;
        String expectedDescription = "B189 - Database Testi İçin oluşturuldu";

        String sql = "select * from room where room_number = 72132940";

        ResultSet resultSet = executeQuery(sql);
        resultSet.next();

        int actualRoomNumber = resultSet.getInt("room_number");
        String actualRoomType = resultSet.getString("room_type");
        boolean actualStatus = resultSet.getBoolean("status");
        double actualPrice = resultSet.getDouble("price");
        String actualDescription = resultSet.getString("description");

        Assert.assertEquals(expectedRoomNumber, actualRoomNumber);
        Assert.assertEquals(expectedRoomType, actualRoomType);
        Assert.assertEquals(expectedStatus, actualStatus);
        Assert.assertEquals(expectedPrice, actualPrice, 0.01);
        Assert.assertEquals(expectedDescription, actualDescription);

        closeConnection();
    }
    @Test
    public void medunnaTest02() throws SQLException {
        String sql = "select * from room where room_number = 72132940";

        ResultSet resultSet = executeQuery(sql);
        resultSet.next();

        Assert.assertEquals(72132940, resultSet.getInt("room_number"));
        Assert.assertEquals("SUITE", resultSet.getString("room_type"));
        Assert.assertTrue(resultSet.getBoolean("status"));
        Assert.assertEquals(5000.00, resultSet.getDouble("price"), 0.01);
        Assert.assertEquals("B189 - Database Testi İçin oluşturuldu", resultSet.getString("description"));

        closeConnection();
    }


}


