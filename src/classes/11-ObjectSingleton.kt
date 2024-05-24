package classes

/**
 * Object-Singleton Veya Object-Declaration  diye duyarız.
 *
 * MÜLAKAT SORU 1
 * Singleton Pattern Nedir ?
 * Bir class'ın herhangi bir t anında memory'de her erişildiğinde sadece 1 tane nesnesi olacağını garanti eden şablondur.
 * Yani bir class'ın nesnesinin memory'de herhangi bir t anında sadece 1 tane olmasına object-singleton kullanımı deriz.
 * Sürekli nesne oluşturmak yerine farklı yerlerde aynı nesneyi kullanabiliriz.
 * Bu sayede o nesneye hızlı erişmek istediğimde tekrardan nesne oluşturmaya gerek kalmadan kullanabilirim.
 * Kısacası her t anında aynı nesneye erişmektir diyebiliriz.
 */

// Pattern Nedir?
// Bir işin yapılmasını kolaylastiran,performansini arttiran,okunakliligini duzelten,test edilebilmesini kolaylastiran yapilara denir.

/**
 * Singleton kullanımında arka planda statik olarak tutulduğu için garbage collector bunları temizleyemez.
 * Bu memory kontrolü tamamen developer'ın kontrolündedir.
 * Bu yüzden kullanırken dikkatli olunmalı,herşeyi singleton yapmamalıyız.
 */

/**
 * Eger uygulamamın lifeCycle(yasam dongusu)'ı  boyunca kullanilacaksa onu singleton olarak kullanabilirim.
 * Eger spesifik olarak 1 istekte,1 ekranda veya 1,2 yerde kullaniliyorsa bunu statik yapilarin icerisinde tanimlamamam gerekir.
 * Static yapilari garbage collector temizleyemez.
 * Bu tarz kullanimlari kendi anlamlari uzerinden degerlendirmem gerekir.
 */

/** MÜLAKAT SORU 2
 * Singleton Pattern aynı zamanda bir anti-pattern olarak da adlandırılır.Peki bu neden ?
 * Java karsiliginda static keywordu ile yazildigi icin, yanlis ve gereksiz kullanimlarda (ornek veri tasimak icin kullanmak)
 * garbage collector'in toplamadigi veri sayisi artacak.
 * Bu da memory leak'e sebep olabilir.Aynı zamanda bir antipatterndir.
 * Ayrıca singleton kullanımında tek bir obje üzerinden işlem yapacağımız için farklı yerlerde bir değişiklik yaptığımızda diğer yerlerde de güncellemesini yapmalıyız.
 */

/** MÜLAKAT SORU 3
 * Singleton Pattern'nin adım adım nasıl yapılacağını anlat.
 *
 *   Ozetle JAVA'da 3 adimda yapilir;
 *   1- Default constructor'i private olarak olustur.Başka public constructor bulundurma.Classin nesnesi disaridan olusturulamasin ki memoryde bu classin ayni anda tek bir nesnesinin oldugundan emin olayim.
 *   2- Class'in icinde class'ın bir nesnesini oluştur. olustur (private volatile static olarak)
 *   3- Bu nesneyi donduren bir newInstance() fonksiyonu yaz (public synchronized static olarak).
 *   4- Bunu yaparken yazdigin nesneyi null kontrolu yaparak geri dondur.(Instance'yi geri donduren fonksiyon static oldugu için oluşturduğumuz instance'yi de static yapmamız gerekir)
 */

/**
 * Her ekranda biz bir sınıfın instancesini kullanıyorsak,o instance'yi defalarca yeniden oluşturmak yerine singleton olarak tanımlayabiliriz.
 * Örneğin Android'de retrofit instancesi singleton olarak tutulur ki her sayfada o instanceyi tekrardan oluşturmak zorunda kalmayalım.
 */

object RetrofitKotlin { // Kotlin'de ise singleton kullanımını böyle yaparız.
    // Object kw ile bir sınıf oluşturduğumuzda arka planda bu direkt olarak singleton formunda olur.
    var baseUrl = "www.google.com"
}


fun main() {

    val retrofit = RetrofitKotlin.baseUrl
    println(retrofit)


}

