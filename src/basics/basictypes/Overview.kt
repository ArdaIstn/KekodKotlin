package basics.basictypes

/**
 * Degiskenlerin kabaca 2 turu vardir.
 * 1)Referans Tipli Degiskenler,2)Primitive Tipli Degiskenler
 * Java ve diger bircok dilde primitive degiskenler gorurken,kotline baktigimizda tum degisken tipleri bir CLASS'dir.
 * Primitive tipler hem kapladiklari alan bakimindan,hem de erisim hizlari bakimindan referans tipli degiskenlere gore cok daha hizli calisirlar.
 * Daha az sey yapabiliriz fakat cok daha hizlidirlar.
 * Kotlinde her sey birer nesnedir.Yani buradaki class tipindeki degiskenler,calisma zamaninda yapilan optimizasyonlarla java tarafindaki gercek primitive karsiliklarina donusturururler.
 * ShowKotlinByteCode yapıp gorebiliriz.
 *
 */

/**
 * val degiskenlere genelde immutable deriz,fakat bu yanlis bir ifadedir.Aslinda readOnly degiskenlerdir.
 * readonly demek degeri okunabilen,ilk deger atamasindan sonra tekrar deger atanamaz(set edilemez) demektir.
 * immutable ise bir degiskenin/nesnenin durumu asla ilk degerden farkli olamaz demektir.
 * Asagidaki ornege bakabiliriz.
 */

/**
 * val degisken ile var degisken arasinda bir perfomans farki bulunmuyor denebilir.
 * Yine de akademik seviyede konusuyorsak,var degiskenler bir "readonly" gibi şarta sahip olmadiklar icin,
 * gozardi edilebilecek kadar ufak bir farkla val degiskenlere gore performanslidir.
 *
 *
 * Bunun yaninda eger projemizde multi-thread islemler varsa,bu islemlerde kullanılan degiskenlerin
 * birbirlerinin son durumlarini kontrol etme ihtiyacinin yarattigi maliyet cok daha ciddi performans sorunlarina yol acmaktadir.
 * Bu sebeple gene kabul(best-practice) val degiskenlerin,var degiskenlerden daha performansli oldugu yonundedir.
 * Tum bu sebeplerle bir degiskeni once val olarak tanimlamamiz,sonrasinda baska biryerde bu degiskenin degerini degistiriceksek,
 * var yapmamiz pek cok acidan daha kullanislidir.
 *
 * ------------------------------------------------------------------------------------------------------------------------------
 * Bir classin uye degiskenini var olarak tanimlayip,bu degiskenin onundeki var kelimesini degistirmeden,nasıl val yapabilecegimiz mulakatta karsimiza cikabilir.
 *
 * Bunun cozumu ise set fonksiyonunu private yapmamizdir.Bu durumda,degisken var olsada readonly bir hale donusur.
 * Asagidaki testUser() fonksiyonunu orneginde aciklanmistir.



 */
fun main() {
    val name: String = "Arda"
    val age: Int = 24
    val isMale: Boolean = true
    val firstLetterOfSurname: Char = 'I'
    val byteValue : Byte = 10
    val shortValue : Short = 20
    val longValue : Long = 10L
    val doubleValue  : Double = 10.5
    println("----------------------")

    calculateAvailableSpace()

}

class Box {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 50
    var usedSpace: Int = 0

    val availableSpace: Int
        get() {
            return (width * height * length) - usedSpace // Degiskenin degeri,buradaki ozelliklere gore degisebilir.Bu sebeple val degiskenler immutable degil,read only'dir.
        }
}

fun calculateAvailableSpace() {
    val box = Box()
    box.height = 10
    box.width = 20
    box.length = 5
    box.usedSpace = 2

    println(box.availableSpace)

    println("----------------------")

    box.height = 30
    box.width = 10
    box.length = 8
    box.usedSpace = 0

    println(box.availableSpace)
}

class User {
    val name: String = "Arda"
    var surname : String = "Işıtan"
        private set
}

fun testUser(){
    val user = User()
    user.name // Erisimde bir problem yoktur.
    user.surname // Erisimde bir problem yoktur.

// user.name = "Barış"  Val oldugu icin zaten degeri degistirilemez.
//     user.surname = "Şahin" set fonksiyonunu private yaptigimiz icin degeri degistirilemez.
}