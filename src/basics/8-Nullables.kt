package basics

fun main() {
    /**
     * Bir degiskene null deger atamasi yapabilmek icin tipinin sonuna ? isareti konur.
     * Eger bir degiskene tip verilmez ve direk null deger atamasi yapilirsa,IDE tip cikarimi yaparken
     * bir degiskenin degerini Nothing? olarak isaretler.Cunku hangi tipe karsilik geldigini bilemez.
     */


    val name: String? = null
    val age: Int? = null

    val number =
        null //Burda IDE tipin ne oldugunu bilemez,Nothing? ozel tipini verir.Belki bir kotlin sinavinda karsimiza cikabilir.

    val number3 = null // Nothing?
    //Bir fonksiyonun,herhangi bir deger dondurmek zorunda olmadigi durumlarda kullanılır.
    //Exception firlatmalarda genellikle gorulur.


    var number1: Int? = null
    var number2: Int? = null

    var result: Int? = 0


    result!!.plus(324) // Null olmayacagini garanti ediyoruz,her halukarda calistir diyoruz.
    result?.plus(324) // Null degilse calistir,null ise calistirma demektir.

    /**
     * if(result!=null){
     *  result.plus(324) Java tarafinda bu kod ?. kullanimla aynidir.Kotlinde bizim bu if kosulunu yazmamiza gerek yoktur.
     * }
     */

    // Exception : Uygulamamiz calisirken,hata alip uygulamanin cokmesi durumudur.
    // Genel olarak kritik durumlarda,kullanciya ciddi bir problem olacaksa !!. kullanmamiz daha mantiklidir.(Uygulamanin cokmesi daha uygundur)
    // Eger cok onemli bir durum degilse, ?. kullanabiliriz.
    /* --------------------------------------------------------------------------------------------------------------------------------------------- */

    /**
     * Elimizde nullable bir degisken varsa ve bu degiskenin methodlarindan birine ihtiyac duyacaksak ya da,direk olarak kullanacaksak,
     * bu durumda ideye ya bu degiskenin null olmayacaginin garantisi !! operatoru ile vermek gerekiyor,
     * ya da null degilse calissin demek icin ?. operatorunu kullanmak gerekiyor.
     * Best Practice olarak kodlarimizi !! seklinde yazmamiz Kotlin Null Pointer Exception hatasi almamizi saglar.
     * Bu sayede gozden kacan nullable degerleri bulabilmemizi saglar.
     * Ancak,canliya cikan projemizde,cok gerekli olmayan kisimlar icin,daha az onemli olan kisimlar icin ?.
     * daha onemli,kritik kisimlar icin !!. kullanmaliyiz.
     */


//    if (number1 != null && number2 != null) { Nullable kontrolunu boyle yazma.
//        result = number1 + number2
//    }





}