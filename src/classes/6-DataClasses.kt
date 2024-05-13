package classes

/**
 * İŞ GÖRÜŞMESİ 1. SORU
 * Data Classlar ile Düz Class'ların farkı nedir ?

 * Data Class'larda  arka planda otomatik olarak toString(),HashCode(),Equals() ve Copy() fonksiyonları oluşturulur fakat düz class'ta otomatik olarak oluşturulmaz.
 * Düz classta bu fonksiyonları istersek biz override edebiliriz.(copy hariç)
 * Ayrıca bu fonksiyonların içleri doludur.Bize düz class'taki fonksiyonlardan farklı çıktılar üretir.
 * Bu fonksiyonlar sadece primary constructor'da yer alan değişkenler ile doldurulur.Yani harici member property'ler bu fonksiyonlarda kullanılmazlar.
 *
 * Ek olarak primary constructor'daki parametre sayısı kadar componentN fonksiyonları oluşur.
 * Bu,bize Destructuring Declaration kullanımı yapmamızı sağlar.
 * Okunaklığın arttırılmasını sağlar.
 *
 */


/**
 * İŞ GÖRÜŞMESİ 2. SORU
 * Data Classlar'ın primary constructor'ında tanımlanan değişkenler, neden val veya var ile tanımlanması zorunludur ?

 * Arka planda kodlar yazılırken,generate edilen fonksiyonlarda bu değişkenlere erişildiği için val veya var ile tanımlamak zorunludur.
 *

 */


/**
 * Data Class'lar iş görüşmelerinde kesin sorulur.
 */

/** DATA CLASS'LARIN ÖZELLİKLERİ
 *
 * Primary Constructor'ı mutlaka olmalidir.
 * Primary Constructor'da en az 1 tane  parametre içermelidir.
 * Bu parametre mutlaka val ya da var ile tanımlanmış olmalıdır.
 * Parametreleri default değer alabilir.Bu konu mapping kütüphanelerinin boş constructor'a sahip olması gerekliliğinden ötürü önemlidir.
 *
 * İnit bloğu içerebilir.
 *
 * Secondary Constructor içerebilir.
 *
 * Member property veya fonksiyon tanımlanabilir.
 *
 * Member property'lerin componentN function'ları generate edilmez.
 *
 * Member property'ler (copy,haschode,equals,toString()) fonksiyonları generate edilirken kullanılmazlar.
 *
 * Visibility Modifier'leri kullanabilirim.
 *
 * Open kullanırsam hata verir,demek ki data class'lar miras alınamaz.
 *
 * Final kullanırsam redundant uyarısı alırım.
 *
 * Abstract veya open class'ları miras alabilir.
 *
 * Bir interface'yi implement edebilir.
 *
 *
 * sealed yapılamazlar.
 *
 * inner yapılamıyor ama nested olarak bulunabilir.
 *
 * Body'si olsa da olmasa da kullanılabilir.
 *
 * Data classlar'ın içerisine fonksiyon yazmamamız gerekir.
 *
 * Data Class'ların görevi veri tutmak,veri taşımaktır.
 *
 * Eğer generate edilen fonksiyonlardan biri data class içerisinde override edilirse,generate edilmesi engellenir ve böylece,
 * class içindeki implemantasyon geçerli olur.toString() örneği gibi.
 */

class Pokemon(val name: String, val type: String, val age: Int) {

}

data class PokemonData(val name: String, val type: String, val age: Int) {

    var origin: String = "origin"

}

data class UserInfo(val name: String, val surname: String, val age: Int) {
    var country: String = ""

}


fun main() {


    val user1 = UserInfo("Arda", "Işıtan", 24)
    println(user1) // toString() kullanımı,istersek override edebiliriz.

    val user2 = UserInfo("Arda", "Işıtan", 24)

    user1.country = "Turkey"
    user2.country = "Spain"

    println("User1 Equals User2:${user1.equals(user2)}") // true döner.

    /**
     * user1 ve user 2 nesnelerinin name,surname,age değerleri aynı fakat country bilgileri farklıdır ve buna rağmen equals fonksiyonu bize true döner.
     * Bunun sebebi aslında equals fonksiyonun arka planda sadece primary constructor'da tanımlanan değişkenleri kullanmasından kaynaklıdır.
     */

    println("************************************")

    // Copy Kullanımı
    val user3 = user1.copy(name = "Mehmet", age = 32)
    println(user3.toString())
    println("User3:$user3") // user3, arka planda toString() fonksiyonunu çağırır.

    val user4 = UserInfo("Mehmet", "Işıtan", 32) // Copy kullanmasaydık bu şekilde yazmamız gerekirdi.
    println(user4.toString())
    println("User4:$user4")

    println("************************************")

    //Destructuring Declaration
    val pair: Pair<String, String> = Pair("Fenerbahce", "Galatasaray")
    println(pair)
    println(pair.first)
    println(pair.second)

    val triple: Triple<String, String, String> = Triple("Fenerbahce", "Galatasaray", "Besiktas")
    println(triple)
    println(triple.first)
    println(triple.second)
    println(triple.third)

    println("************************************")


    val (pFirst, pSecond) = pair
    println("pfirst:$pFirst, psecond:$pSecond")

    val (tFirst, tSecond, tThird) = triple
    println("tFirst:$tFirst, tSecond:$tSecond, tThird:$tThird")

    val (name, surname, age) = user1
    println("name:$name, surname:$surname, age:$age")

    // ComponentN fonksiyonları destructuring declaration kullanımı yapmamızı saglar.
    // Arka planda name değişkenine component1,surname değişkenine component2, age değişkenine component3 fonksiyonları atanir.
    // Bu componentN fonksiyonları da zaten arka planda primary constructor'daki değişkenleri sırasıyla return eder.



}