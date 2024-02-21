package basics

import java.util.*

fun main() {

    /**
     * Yaklasik olarak her karakter basina 2 byte yer kaplar.UTF-16 encoding kullanır.
     *
     * Cift tirnak icerisine yazilan karakterler butunudur.
     * Bir string ifadenin tum karakterlerini tek tek alip,char bir listeye atabilirsiniz.
     * Ya da ekrana yazdirabilirsiniz
     */
    val deneme = arrayOf(1, 2, 3, 4, 5)
    println(deneme.joinToString())

    val name = "kekod"
    val char1 = 'k'
    val char2 = 'e'
    val char3 = 'k'
    val char4 = 'o'
    val char5 = 'd'

    val nameArray = charArrayOf(char1, char2, char3, char4, char5)

    for (char in name) {
        println(char)
    }

    println("------------------------------------------------------------------------")

    val awesomeKekod = "Kekod is Awesome"

    val firstCharOfAwesomeKekod = awesomeKekod[awesomeKekod.indices.first]
    val firstCharOfAwesomeKekod2 = awesomeKekod[0]
    val lastCharOfAwesomeKekod = awesomeKekod[awesomeKekod.indices.last]
    val lastCharOfAwesomeKekod2 = awesomeKekod[15]

    println(firstCharOfAwesomeKekod)
    println(firstCharOfAwesomeKekod2)
    println(lastCharOfAwesomeKekod)
    println(lastCharOfAwesomeKekod2)

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * Stringler immutabledir.Bir string ilk deger atamasi yapildiktan sonra degerini degistiremez ya da yeni bir deger set edemez.
     * String uzerinde yapacagimiz tum islemler bize yeni bir string object'i donecektir.
     * String'in ilk hali degismeyecektir.Bu sadece stringlerde boyledir.Diger veri tiplerinde boyle degildir.

     * Primitive tipler referans tiplere gore daha hizli calisir bunu biliyoruz dolayisiyla bunlar stackde kalacaktir.
     * Fakat stringler stackde degiskenin ismini tutar,heap'de degeri yer alir.
     * Ama biz string'in degerini degistirdigimizde ,degiskenin yeni degeri icin heapde ayri bir alan olusturulur,
     * Bizim degiskenimiz o yeni degeri isaret eder.
     * İlk deger degismedigi icin memoryde hala kaldigi icin bu durumda string degiskenler immutabledir.
     * Tabii ki var oldugu durumda yeni bir deger alabilir fakat ilk deger hala memoryde kaldigi icin immutabledir.
     * Garbage collector belli zamanlarda heap'i gezer.İsaret edilmeyen bir value varsa bu memoryden komple silinir.
     * Garbage collector calisana kadar bu degerler memoryde beraber yer kaplar.(İş görüşmesinde show yaparsın :) )
     *
     *
     *
     */
    val name2 = "Arda"
    println(name2.uppercase())
    println(name2)

    var surname = "Işıtan"
    surname = "Kaya"

    println()

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * Farklı tipteki bir degiskenin onune String bir degisken ya da ifade koyarak toplarsaniz,sonuc String olacaktir.
     * Ancak String bir degisken ya da ifadenin onune + ile farklı tipte bir degisken eklerseniz kod calismayacaktir.
     */

    val numbersValue = "value" + (1 + 2 + 3)

    println("Numbers Value:$numbersValue")

//   val numbersValue2 : String = (1 + 2 + 3) + "value" calismayacaktir.

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * Degiskenin degerine erismek icin $ isaretini kullanabiliriz.
     * Buna String template denir.
     * Eger degiskenin bir ozelligine ihtiyac duyacaksak ${} seklinde kullanilir.
     */

    println("Numbers value :$numbersValue")
    println("Numbers value length:${numbersValue.length}")

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * 3 tane cift tirnak kullanarak raw string(multiline string) olusturulabilir.
     * Raw stringler ideye nasil yaziliyorsa oyle kullanilir.Hizalamada bozulma olmaz.
     * trimIndent() fonksiyonu ile bu Raw String'in kenar bosluklarini silebilirsiniz.
     * Bu silme islemini yaparken tum satirlardaki en soldaki karakteri baz alarak silme islemini saglar.
     * Alttaki ornek icin 3 satirdan da $ isaretinin solundaki bosluga kadarini siler.
     * Raw stringler icinde escape karakterler calismaz.
     */

    val rawPineTree = """
               *
     $        ***
             *****
    """.trimIndent()

    val rawPineTree2 = """
               *
     $        ***
             *****
    """

    val rawPineTree3 = """
               *
              ***
             *****
    """.trimIndent()

    println(rawPineTree)
    println(rawPineTree2)
    println(rawPineTree3)

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * Raw Stringler(Multiline String) içinde escape characterler kullanmak icin ${'$') yapısını kullanabiliriz.
     * Raw Stringler \ characterini almazlar.
     * Row string icerisinde escape karakterler icin \ kullanilmaz.
     */

    val price = """
        Price ${'$'}_9.99
        """
    println(price)

    println("------------------------------------------------------------------------")/* ---------------------------------------------------------------------------------------------------------------*/

    /**
     * Kotlin'de String.format() metodu,Java'nın String.format() metoduna çok benzer bir sekilde calisir.
     * Bu metod,belirli bir string içinde yer tutucuları belirtilen değerlerle değiştirerek yeni bir string
     * olusturmamiza olanak tanir.Yer tutucular,formatlama belirtimleriyle tanımlanır ve bu belirtimler,
     * degistirilecek degerlerin nasıl bicimlendirilecegini kontrol eder.
     */

    /**
     * %s: String icin
     * %d: Tam sayi,integer icin.
     * %f: Kayan noktali sayi(float,double) icin
     * %n: Yeni bir satira gecmek icin (platform bagimsiz)
     */

    val yas = 24
    val mesaj = String.format("Yaşım:%d", yas)
    println(mesaj)

    val boy = 1.80
    val mesaj2 = String.format("Boyum:%.2f metre", boy)
    println(mesaj2)

    val ad = "Arda"
    val mesaj3 = String.format("Ad:%s Yas:%d Boy:%.2f", ad, yas, boy)
    println(mesaj3)

    val sayi = 1234567.79
    val usFormat = String.format(Locale.US, "Us Formatinda: %,.2f", sayi)
    println(usFormat)//US formatinda 1,234,567.79 seklinde yazilir.


    //Türkçe için Locale nesnesi,"tr" ISO 639 dil kodu  ve "TR" ISO 3166 ülke kodu ile olusturulabiliyor.
    val localeTR = Locale("tr", "TR")//Turkce icin locale nesnesi olusturuluyor.Local'i olusturmus oluyoruz.

    //Formati kullanirken float veya double uzerinde islem yapacaksak,nokta ve virgul kullanimina dikkat etmek icin locale'i eklemeyi unutmamaliyiz.
    val usFormatTR = String.format(localeTR, "Tr formatinda: %,.2f", sayi)

    println(usFormatTR) //TR formatinda 1.234.567,79 seklinde yazilir.

    // Kusurat kisminda nokta mi virgul mu olacaginin kararini locale'imiz verir.
    // Fakat biz her halukarda . oncesinde , koyarak ayiracin  ne olacagini belirtiyoruz.
    // .2f ve .3f formatini zaten degistiremeyiz.

}