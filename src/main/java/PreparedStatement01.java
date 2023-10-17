
/*
PreparedStatement; onceden derlenmis, birden fazla kez kullanilabilen,
                parametreli sorgular olusturmamizi ve calistirmamizi saglar

PreparedStatement, statement i extend eder(Statementin gelismis halidir.)
 */

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        Statement st =con.createStatement();


//----------------------------------ORNEK 1------------------------------------
        //ÖRNEK1:bolumler tablosunda Matematik bölümünün taban_puani'nı 475 olarak güncelleyiniz.

//        String query="UPDATE bolumler SET taban_puani=475 WHERE bolum ILIKE 'matematik'";
//        st.executeUpdate(query);

        //parametreli sorguyu String olarak yazalım
        String query="UPDATE bolumler SET taban_puani=? WHERE bolum ILIKE ?";

        //parametreli sorguyu oluşturalım
        PreparedStatement prst =con.prepareStatement(query);

        //parametreleri  set edelim
        prst.setInt(1,475);
        prst.setString(2,"matematik");

        //parametrelerini verdiğimiz sorguyu çalıştıralım
        int updated=prst.executeUpdate();
        System.out.println("updated = " + updated);





        System.out.println("-----------------2--------------------");
        //ÖRNEK2:(Prepared Statement kullanarak) bolumler tablosunda Edebiyat bölümünün taban_puanı'nı 455 olarak güncelleyiniz.
        prst.setInt(1,455);
        prst.setString(2,"edebiyat");

        int updated2=prst.executeUpdate();
        System.out.println("updated = " + updated2);


        System.out.println("-----------------3--------------------");
        //ÖRNEK3:Prepared Statement kullanarak ogrenciler tablosundan Matematik bölümünde okuyanları siliniz.
        String query3="DELETE FROM ogrenciler WHERE bolum ILIKE ?";
        PreparedStatement prst2=con.prepareStatement(query3);

        prst2.setString(1,"matematik");
        int deleted=prst2.executeUpdate();
        System.out.println("deleted = " + deleted);


        System.out.println("-----------------4--------------------");
        //ÖRNEK4:Prepared Statement kullanarak bolumler tablosuna
        // Yazılım Mühendisliği(id=5006,taban_puanı=475, kampus='Merkez') bölümünü ekleyiniz.


        String query4="INSERT INTO bolumler VALUES(?,?,?,?)";//(id,bolum,taban_puani,kampus)
        PreparedStatement prst3=con.prepareStatement(query4);

        prst3.setInt(1,5006);
        prst3.setString(2,"Yazılım Müh.");
        prst3.setInt(3,475);
        prst3.setString(4,"Merkez");

        int inserted=prst3.executeUpdate();
        System.out.println("inserted = " + inserted);



        prst.close();
        st.close();
        con.close();
    }
}
