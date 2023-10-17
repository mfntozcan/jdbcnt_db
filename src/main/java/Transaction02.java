import java.sql.*;

public class Transaction02 {
    public static void main(String[] args) throws SQLException {
    // dogru yaklasim; birbirine bagimli olan bu iki islemi tekbir transaction icine alarak yapmak.

        //hesap no:1234 ten hesap no:5678 e 1000$ para transferi olsun.
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        // transaction yonetimini alalim
       con.setAutoCommit(false);
       PreparedStatement prst = null;

       try {
           String sql = "UPDATE hesaplar SET bakiye=bakiye+? WHERE hesap_no=?";
           prst = con.prepareStatement(sql);
           //1nci islem>para gonderme islemi
           prst.setInt(1, -1000);
           prst.setInt(2,1234);
           prst.executeUpdate();//commit edilene kadar UPDATE edilen deger kalici hale gelmez.


           //Sistemsel bir hata olustu.

           if (false){// eger sistemde basarizlik oldugunu varsaymak istiyorsak false kismi true olmalidir.
                        // false yazinca sistemsel hata olmadigi anlamina gleir.
               throw new Exception();
           }

           //2nci islem> para alma islemi
           prst.setInt(1, 1000);
           prst.setInt(2,5678);
           prst.executeUpdate();

           con.commit();//iki islemin de tamalandigina dair onaylama islemi.
           //islemler bittigi icin uygulamanin kapanmasini istiyoruz.
           prst.close();
           con.close();
           System.out.println("islem basarili..");


       }catch (Exception e){

           con.rollback();
           System.out.println("Islem basarisiz.");


       }finally {
           prst.close();
           con.close();//islem basariz oldugunda yukaridaki kapama islemi calismayacagindan

       }










    }
}
