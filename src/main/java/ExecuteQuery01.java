import org.postgresql.Driver;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        //1nci adim

        //2nci adim
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbcnt_db","techpront","password");

        Statement st =con.createStatement();


        System.out.println("------------------ornek 1 -------------------------------");



        //ÖRNEK 1:id'si 5 ile 10 arasında olan ülkelerin "country_name" bilgisini listeleyiniz.

        boolean sql1 = st.execute("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
        System.out.println("sql1 = " + sql1);

        ///kayıtlarımızı görmek için executeQuery() kullanmalıyız.
        ResultSet resultSet =st.executeQuery("SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10");
//        resultSet.next();
//        System.out.println("Ülke ismi = " + resultSet.getString("country_name"));
        while(resultSet.next()){
            System.out.println("Ülke ismi = " + resultSet.getString("country_name"));
//            String name= resultSet.getString("country_name");
//            List<String> names=new ArrayList<>();
//            names.add(resultSet.getString("country_name"));
        }

        //ResultSet'te geriye dönüş yoktur.
        System.out.println("------------------ornek 2 -------------------------------");

        //ÖRNEK 2: phone_code'u 600 den büyük olan ülkelerin "phone_code" ve "country_name" bilgisini listeleyiniz.

        ResultSet rs=st.executeQuery("SELECT phone_code,country_name FROM countries WHERE phone_code>600");
        while (rs.next()){

            System.out.println("Tel kodu: "+rs.getInt("phone_code")+
                    "--Ülke ismi: "+rs.getString("country_name"));

        }
        System.out.println("------------------ornek 3 -------------------------------");

        //ÖRNEK 3:it_persons tablosunda "salary" değeri en düşük salary olan yazılımcıların tüm bilgilerini gösteriniz.

        ResultSet rs3 = st.executeQuery("SELECT * FROM it_persons WHERE salary=(SELECT MIN(salary) FROM it_persons)");
        while (rs3.next()){

            System.out.println(rs3.getInt("id")+" -- "+rs3.getString("name")+"--"+
                    rs3.getDouble("salary")+"--"+rs3.getString("prog_lang"));
        }

        System.out.println("------------------ornek 4 -------------------------------");

    //ÖRNEK 4:Puanı bölümlerin taban puanlarının ortalamasından yüksek olan öğrencilerin isim ve puanlarını listeleyiniz.

        String query4="SELECT isim,puan FROM ogrenciler WHERE puan>(SELECT AVG(taban_puani) FROM bolumler)";
        ResultSet rs4=st.executeQuery(query4);

        while (rs4.next()){
            System.out.println(rs4.getString("isim")+"--"+rs4.getInt("puan"));
        }

        System.out.println("------------------ornek 5 -------------------------------");



    }
}
