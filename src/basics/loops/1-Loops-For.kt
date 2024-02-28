package basics.loops

/**
 * Kotlinde 3 farkli sekilde for tanimlayabiliriz.
 * 1) value in List             seklinde value degerlerini alabiliriz.
 * 2) index in list.indices     seklinde index degerlerini alabiliriz.
 * 3) (index,value) in list.withIndex() seklinde index,value degerlerini alabiliriz.
 * Genel olarak tekrarlı islemler icin looplar'i kullanırız.
 */


fun main() {

    for (value: Int in 1..10) {
        print("$value ")
    }

    // Type inference oldugu icin value:Int gibi tipini belirtmemize gerek yoktur.Genel egilim de bu yondedir.

    println()

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")

    for (country in countryCodeArray) {
        print("$country ")
    }

    println()

    val alphabetList = ('A'..'Z')

    for (alphabet in alphabetList) {
        print("$alphabet ")
    }

    println()

    for (index in countryCodeArray.indices) {
        print(" $index.deger:${countryCodeArray[index]}")
    } // indexe ihtiyacim varsa bunu kullanabilirim.

    println()

    for ((index, value) in countryCodeArray.withIndex()) {
        print(" $index.deger:$value")
    } // Hem index,hem de value'ya ihtiyacım varsa bunu kullanabilirim.
    // Bu kullanım data classlarda  kullanılan,destructuring declaration kullanımıdır.
    // Bir fonksiyonun geri donusunu,iki farklı degiskene atanmasi durumuna  destructuring declaration denir.
    // Data classlarda tekrardan bu konuya deginilecektir.


    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * repeat(times) seklinde herhangi bir listeye ihtiyac duymadan tekrarlayan isler yapabiliriz.
     * it indeks degeridir.
     */

    repeat(10) {
        print("$it:Hello World ")
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * return kullanarak ilgili sart saglanirsa,donguden cikabiliriz.
     * continue kullanarka ilgili sart saglanirsa,donguye o degeri atlayarak devam edebiliriz.
     */

    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        }
        print("$value ")
    }

    println()

    for (value in 1..50) {
        if (value % 2 == 0) {
            break
        }
        print("$value")
    }


    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Ic ice for dongusu kullanıyorsak bir ustteki for'a degil de iki ustteki uc ustteki fora donmek istiyorsak,
     * label kullanabiliriz.Bunun icin labelname@ ifadesini ilgili for'un onune yazıp,return ya da continue yazan yere
     * ise @labelname seklinde yazmamiz yeterlidir.
     * Tek bir dongu yazıyorsak kullanmamiz anlamsizdir,cunku zaten donecegi yer de o for dongusunun kendisidir.
     *  Ic ice for dongulerinde labellara ihtiyacimiz olacaktir.
     * return kullanmak dongulerle alakali bir sey degildir,icinde bulundugumuz fonksiyondan cikmamizi saglar.
     */

    for (value in 1..5) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue
            }
            print("Continue1:$value2 ")
        }

    }

    println()
    println("Normal continue")


    returnLabel@ for (value in 1..5) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue@returnLabel
            }
            print("Continue1:$value2 ")
        }

    }

    println()
    println("label continue")
    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")


    for (value in 1..5) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                break
            }
            print("Continue1:$value2 ")
        }

    }
    println()
    println("normal break")

    returnLabel@ for (value in 1..5) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                break@returnLabel
            }
            print("Continue1:$value2 ")
        }

    }
    println()
    println("label break")


}