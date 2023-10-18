import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    /*
    Assertion; Test sonuclarini dogrulamak icin kullanacagimiz class ve methodlardir.
    Test Gecti veya Test Kaldi seklinde donutler alabilmek icin dogrulama (assertion) islemi gerceklestiririz.

     */

//ASSERTION TURLERI;
    //1-assertEquals(); icerisine eklenen parametreler esit ise test gecer, aksi halde test kalir.
    @Test
    public void deneme1(){
        String expectedData = "Selam";
        String actualData = "Selam";

        Assert.assertEquals(expectedData, actualData);

    }
//assertTrue();  icerisine eklenen islem sonucu TRUE ise test gecer, FALSE ise test kalir.
    @Test
    public void deneme2(){
        int sayi = 5;

        Assert.assertTrue(sayi>0);


    }
// 3- assertNotEquals(); Icerisine eklenen parametreler esit degilse test GECER, esit ise test KALIR.
    @Test
    public void deneme3(){
        int sayi1=5;
        int sayi2=3;

        Assert.assertNotEquals(sayi1, sayi2);

    }

    // 4- assertFalse(); icerisine ekloenen islem sonucu false ise test gecer, aksi halde test kalir.

    @Test
    public void deneme4(){
        int sayi = 5;

        Assert.assertFalse(sayi>0);

    }

}
