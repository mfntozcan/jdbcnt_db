public class IlkTest {

    /*
    Expected Data; Beklenen data
    Actual data; Gercek data

    Test; Beklenen data ile gercek datanin karsilastirilmasidir.

     */
    public static void main(String[] args) {

        //-----------Test 1-----------------
        String expectedData= "Selam";
        String actualData= "Selam";

       if (actualData.equals(expectedData)){
           System.out.println("Test Passed");
       }else {
           System.out.println("Test Failed");
       }

        //-----------Test 2-----------------
       int sayi1=5;
       int sayi2=5;

        if (sayi1 == sayi2){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        //-----------Test 3-----------------
        if (sayi1 > sayi2){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

    // Otomasyon testi yapabilmek icin  bir TEst Famework lerine ihtiyacimiz vardir. JUnit, TestNG, Cucumber gibi







    }
}
