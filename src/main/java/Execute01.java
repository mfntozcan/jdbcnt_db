import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.ADIM:Driverı göster
        Class.forName("org.postgresql.Driver");//Java 7 ile birlikte buna gerek kalmadı.

        //2.ADIM:bağlantıyı oluşturma
        Connection connection =DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        //3.ADIM:Statement nesnesini oluşturma:SQL sorgularını DB ye gönderme ve çalıştırma için
        Statement st =connection.createStatement();

        //4.ADIM:sorgu oluşturma ve çalıştırma

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.
        boolean sql1=st.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT, worker_name VARCHAR(50),salary REAL)");
        System.out.println("sql1 = " + sql1);

        //DQL için kullanılırsa:ResultSet nesnesi alırsa TRUE değerini döndürür.
        //DDL için kullanılırsa:ResultSet nesnesi almadığı için FALSE döndürür.

        //ÖRNEK 2:"workers" tablosuna VARCHAR(20) tipinde "city" sütununu ekleyiniz.

      //  boolean sql2=st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
      //  System.out.println("sql2 = " + sql2);


        //ÖRNEK 3:"workers" tablosunu SCHEMAdan siliniz.
        boolean sql3 = st.execute("DROP TABLE IF EXISTS workers");
        System.out.println("sql3 = "+ sql3);








        //5ncu Adim; Baglantiyi ve statement i kapatiyoruz.

        st.close();;
        connection.close();





    }
}
