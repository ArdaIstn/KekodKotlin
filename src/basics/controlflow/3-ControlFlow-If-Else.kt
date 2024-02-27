package basics.controlflow

import java.io.IOException

/**
 * if-else caselerinden sonra suslu parantez acilir ve kapanir.
 * Ancak bu suslu parantezlerin arasına tek satir kod yazacaksak,suslu parantez kullanmak zorunda değiliz.
 * Ama best practice olarak suslu parantezleri kullanmaliyiz.
 * If-else caselerin state ve expression olmak uzere 2 adet kullanımı vardır.
 * State kullanımı,sadece if-else kullanarak sartli durumlarimizi kodlamaktir.
 * Expression kullanımı ise bir value'ya deger olarak esitligin karsi tarafina if-else kodlarini yazmaktir.
 * Expression olarak yapılan kullanımda,if-else caselerin icerisine yazilmis parantezlerin son satiri value olarak atanir.
 */

fun main() {
    println("Öğrenci misin ? ")

    val answer = readln()

    // State Kullanımı
    // İf bloğu cevabın Evet olup olmadığını kontrol eder.
    // ignoreCase ile de büyük-küçük harf duyarliligini ihmal etmiş oluruz.
    if (answer.contains("Evet", ignoreCase = true)) {
        println("Öğrenci")
    } else {
        println("Öğrenci Değil")
    }


    if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci")
    else println("Öğrenci Değil")


    if (answer.contains("Evet", ignoreCase = true)) println("Öğrenci") else println("Öğrenci Değil")

    /**
     *  Yukarıdaki gibi 3 farklı şekilde yazabilirim.Fakat en doğru ve temiz kullanımı ilk başta {} kullanılarak yazılan yazım şekildir.
     *
     */

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    //Expression kullanımıdır.{} içerisindeki son satir,deger olarak degiskene atanir.

    val result: String = if (answer.contains("Evet", ignoreCase = true)) {
        println("Expression kullanımına örnektir.")
        "Öğrencidir"
    } else {
        println("Expression kullanımına örnektir.")
        "Öğrenci Değil"
    }

    println(result)

    /**
     * Expression kullanımında değişkenin tipini belirtmediğimizde IDE bize hata vermez.
     * Fakat Best Practice olarak değişkenin tipini belirtmeliyiz.
     */

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Kotlin'de if-else'lerin Expression kullanimindan oturu,ternary operatoru yoktur.
     * Ternary yerine asagidaki gibi bir kullanim yapabiliriz.
     */
    val isStudent = false
    val isStudent2 = if (isStudent) {
        "true"
    } else {
        "false"
    }
    // Fakat bu kullanim gorunus olarak kotu bir kullanimdir.

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * 2 farkli tipteki number degiskenler  karsilastirilirken equals fonksiyonu once tipleri karsilastirdigi icin
     * eger tipler uyusmuyorsa, IDE hata verecektir.

     * Asagidaki ornekteki kod calismaz.
     * Calismasi icin ya 10 sayisini longa cevirmeliyiz ya da 10L sayisini Int'e cevirmeliyiz..
     */

    /* if (10 == 10L){
         Calismaz.
     }*/

    Int

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Birden fazla sartli durumumuz var ise bunlarin her birini asagidaki gibi ayri ayri if seklinde yazmak,
     * if-else seklinde yazmaktan daha kotu bir performans almamiza yol acar.Zira if-else durumlarinda doğru case
     * bulunursa,diger case'ler kontrol edilmez.Ancak asagidaki durumda dogru case bulunsa bile tum caseler
     * kontrol edilir.
     */


    println("Notunuzu giriniz.")
    val grade = readln().toInt()


    if (grade <= 100) {
        println("100'den küçük veya eşit.")
    }
    if (grade > 85) {
        println("85'ten büyük.")
    }
    if (grade <= 70) {
        println("70'ten küçük veya eşit")
    }
    if (grade >= 65) {
        println("65'ten büyük veya eşit")
    }
    if (grade > 40) {
        println("40'tan büyük.")
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Bazı durumlarda if else yazmaktansa,if case'sini yazıp return ya da throw gibi kodun devam etmesini bozacak
     * ifadelerle kodu sonlandirabiliriz.Kod calisirken bu if case'ine girmezse devam eden kod blogu calisir ki
     * bu da pratikte else case'si demek olur.Bu sekilde yazim,kodu biraz daha temiz gosterecektir.
     */

    if (isStudent) {
        println("Student")
    } else {
        otherMethod()
    }

    if (isStudent) {
        println("Student")
        throw IOException()
        // return
    }
    otherMethod()

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * if-else kullanımında önemli bir nokta vardır.Eger ben if içerisinde bir degiskeni kontrol ediyorsam,
     * else-if bloklarında da o degiskenin farklı durumlarını kontrol etmem gerekir.
     * Farklı bir degiskenin kontrolunu else-if kısmına koymamam gerekir.
     * Eger else-if kısmında illa ki kontrol ettireceksem,if kısmında da bu degiskenin bulunması gerekir.
     * Bunu yapmasam bile kod gerekli şartları sağladığında calısabilir fakat bu yanlış bir kullanımdır.
     * Sonuç olarak if parantezlerinin içerisindeki degiskenlerle else-if'in icerisindeki degiskenler baglantılı olmalıdır.
     * Baglantili olmayacak birsey yapıyorsak, alt alta if kullanımı daha uygun olacaktir.
     */

}

private fun otherMethod() {

}