package basics.basictypes

fun main() {
    /**
     * 16 bit yer kaplarlar.
     * Tek tirnaklar arasina harf,sayi,escape char ya da unciode yazarak kullanılır.
     * Tek tirnaklar icerisine,birden fazla karakterden olusan birsey veremeyiz.
     * Çift tırnak içerisine yazarsak String olur,Char olmaz.
     */

    val firstCharOfName: Char = 'A'
//    val firstCharOfName2: Char = "a" calismaz.
    val charNumber: Char = '9'
//    val charNumber2: Char = "39" calisma

    val nullableChar: Char? = null

    /**
     * Butun degiskenler null olabilir,burada da bu degiskeni null yapar isek arka planda class olarak tutulur.Referans tipli,boxed degiskene doner.
     * Nullable olmayanlar ise optimizasyonlarla duz char degiskenine doner.
     */

    /*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * Number deger alan bir char degiskeni,Int'e cevirirken,gercek sayisal degerini gormeyiz.
     * Alacagi ve bizim de gorecegimiz deger,ASCII tablosundaki o sayisal degerin karsiligi(decimal degeri) olacaktir.
     * Ayrica toInt() deprecated olmustur,yerine .code kullanilir.
     * Kod challenglarinda depreceted kod birakmamayi oncelik halina getirmeliyiz.
     * Eger bir sebepten ötürü,char icerisindeki sayinin gercek degerini gormek istiyorsak digitToInt() fonksiyonunu kullanabiliriz.
     * Depreceted demek bu kod suan kullaniliyor fakat belli bir api levelendan sonra bu kod kullanimdan kalkacaktir demektir.
     */
    val convertedCharNumber = charNumber.toInt()
    val convertedCharNumber2 = charNumber.code
    val digitToInt = charNumber.digitToInt()

    println("Char Number:$charNumber")
    println("Converted Char Number:$convertedCharNumber")
    println("Converted Char Number2:$convertedCharNumber2")
    println("DigitToInt:$digitToInt")

    /*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * Escape karakterlerini de tanimlamak icin kullanilir.
     */
    val exampleString = "Kotlin escape karakterleri ornekleri\n" +
            "\t \\t ile bir tab bosluk ekleyebilirsiniz\n" +
            "\t \\n ile yeni bir satira gecebilirsiniz\n" +
            "\t \\b ile bir backspace(geri al) islemi yapabilirsiniz\n" +
            "\t \\r ile satir basina donebilirsiniz.\n" +
            "\t \\' ile tek tirnak(') karakterini kullanabilirsiniz.\n" +
            "\t \\\" ile cift tirnak(\") karakterini kullanabilirsiniz.\n" +
            "\t \\\\ ile ters slash(\\) karakterini kullanabilirsiniz.\n" +
            "\t \\\$ ile dolar isaretini ($) kullanabilirsiniz."

    println(exampleString)

    /*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * Unicode karakterli kullanmak icin kullanilir.
     * Eger backslashle basliyorsak,birden fazla karakter yazabiliyoruz.IDE,Bunun unicode tanimi oldugunu algilar.
     */
    val blackHeart = '\u2665'
    val heavyBlackHeart = '\u2764'


    println("First commit with :$blackHeart")
    println("First commit with :$heavyBlackHeart")


}