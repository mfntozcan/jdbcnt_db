import org.junit.Assert;
import org.junit.Test;
import utils.JdbcLocalDBUtils;

import java.sql.*;

import static utils.JdbcLocalDBUtils.*;

public class Deneme {
    @Test
    public void countryTest() throws SQLException {
        String sql = "select country_name from countries";

        ResultSet rs = executeQuery(sql);

        // Kullanıcı, country_name sütununda en az bir ülke adı olduğunu doğrular
        int ulkeSayisi = 0;
        while (rs.next()){
            ulkeSayisi++;
        }

        Assert.assertTrue(ulkeSayisi > 0);

        // Kullanıcı, Bağlantıyı kapatır
        closeConnection();

    }
}