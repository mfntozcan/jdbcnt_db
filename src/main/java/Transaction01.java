
/*
Transaction ;; DataBase deki en kucuk(parcalanamaz, atomik) islemdir.

Birden fazla islemi gruplayarak tek bir transaction olusturabiliriz.

Bu islemlerden en az biri basarisiz olursa ROLLBACK ile diger islemler de iptal edilerek veri tutarliligi saglanir.

Bu islemlerin tamami basarili olursa degisiklikler COMMIT ile onaylayarak DB de kalici hale getirilir.


 */

import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) throws Exception {

        //hesap no:1234 ten hesap no:5678 e 1000$ para transferi olsun.

        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        Statement st =con.createStatement();

        String sql = "UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
        PreparedStatement prst = con.prepareStatement(sql);

        ///----------olmamasi gereken cozum--------------

        //1- para transferi yapan hesabin bakiyesini guncellenecek
        prst.setInt(1,-1000);
        prst.setInt(2,1234);
        prst.executeUpdate();

        //Bu asamada sistemde hata olusursa
        if (true){
            throw new Exception();//burada uygulama duracak
        }

        //2- para transferi alan hesabin bakiyesini guncellencek
        prst.setInt(1,1000);
        prst.setInt(2,5678);
        prst.executeUpdate();

        //her iki islem ayri transactionlarda




    }
}
