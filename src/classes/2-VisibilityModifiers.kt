package classes

/**
 * Gorunuruluk duzenleyicisi anlamina gelir.
 * Classlar'in,fonksiyonlarin veya degiskenlerin onune konulabilir.
 * Bunlar public,private,protected ve internaldir.
 * Unutmamaliyiz ki class icerisindeki tum degiskenlere veya fonksiyonlara VM onemi olmadan erisilebilir.
 * Javada hersey default olarak private,kotlinde ise hersey default olarak publictir.
 */

/**
 * Public -> Kotlinde default olarak hersey publictir,Javada ise default olarak hersey privatedir.Heryerden erisilebilir anlamina gelir.
 * Private -> Sadece tanimlandigi sinif icerisinden veya dosya icerisinden erisilebilir.Baska siniflardan veya disardan erisilemezler.
 * Protected -> Child classlar tarafindan erisilebilir anlamina gelir.Ancak,ayni paketteki diger siniflar veya disardaki siniflar bu elemana erisemez.
 * Internal -> Tanimlanilan modul icerisinden erisilebilir.Kotlin'de bir modül, genellikle bir proje içindeki bir paketi veya bir modül dosyasını temsil eder.
 * Internal Javada yoktur.(Modul ici public,modul disi private'dir)
 */

/**
 * Kotlin'de bizim degisken diye tanimladigimiz seyler aslinda birer property'dir.
 * Property bir degiskenin get ve set fonksiyonlaridir.
 * Biz kotlinde bir field tanimlamayiz,property tanimlariz.(Javadaki ismi field,Kotlindeki ismi property'dir)
 * Bir degiskenin onune VM koyarsak aslinda o degiskeninin getinin ve setinin gorunurlugunu degistirmis oluruz.
 * Arka plandaki memoryde yer kaplayan degiskenin kendisi,her zaman private olarak durur,buna backing field denir.
 * (Yukaridaki tanimlama class içerisindeki uye degiskenler icindir,bir fonksiyonun icerisindeki local degiskenler bu durumun disindadir)
 * Eğer public bir degisken tanimliyorsak,degiskenin kendisi private'dir(backing field),buna erisen get ve set fonksiyonlari publictir.
 * Eğer private bir degisken tanimliyorsa,degiskenin kendisi private'dir(backing field),buna erisen get ve set fonksiyonlari ise arka planda hic yazilmaz.
 */

/**
 * ENCAPSULATION NEDİR ?
 * Encapsulation basitce bir degiskeni veya bir fonksiyonu privatede tutup,hangi seviyede disari acilmasini,kullanilmasini istiyorsak,
 * o seviyede o degiskenin veya fonksiyonun bilesenlerini disariya acmamiza denir.(get ve set fonksiyonlarini)
 * Javada encapsulationu basitce o degiskenin onune public yazarak delebiliriz.
 * Fakat kotlinde o degiskenin onune public de yazsam,private de yazsam gercek degisken dedigimiz(backing field) arka planda her zaman private olarak tutulacaktir.
 * Asil gercek anlamda,javada oldugu gibi degisken dedigimiz seyler Kotlinde her zaman privatedir. Backing field'a hicbir zaman erisemeyiz ve degistiremeyiz.
 * Kotlinde Encapsulation'u delemeyiz!!
 * Bu sebeple KOTLIN'DE ENCAPSULATION'UN BABASI VARDIR :)
 */

/**
 * MULAKAT SORUSU GELEBILIR.
 *  Kotlinde hersey public olarak tanimlaniyor bu Encapsulation'a problem oluşturmuyor mudur?
 *  Javada herşey default olarak private , bunlara erisecek olan get ve set fonksiyonlarini public yaziyoruz ve bu encapsulation'ın tanimidir.
 *  fakat kotlinde  encapsulation varsa hersey neden public ?
 *
 * Cevap:Bahsettigimiz uzere kotlinde biz bir degiskeni public'de tuttugumuzda aslinda o degiskenin kendisi arka planda private(backing field),
 * ona erisen get ve set fonksiyonlari public olarak yazilir.Privatede tutar isek de degiskenin kendisi(backing field) private fakat
 * o degiskene erisen get ve set fonksiyonlari arka planda hic yazilmaz.Bu sebeple KOTLINDE ENCAPSULATION'UN BABASI VARDIR :)
 */

class Foo() {
    var name: String = "Arda"

    private var surname: String = "Işıtan"

    protected var email: String = "ardaaisitan@gmail.com"

    internal val age: Int = 24


    fun printAll() {
        println(name)
        println(surname)
        println(email)
        println(age)

    }

    fun myFun() {
        var country: String = "Turkey"
    }
// Eger bir fonksiyon  icerisinde degisken tanimlarsak,degiskenin kendisine(backing field) erismis oluruz.
// Yani get'i ve set'i yazilmaz.
// Property oldugu durum ise bir class'ın uyesi oldugu durumdur.
// Bu degiskene zaten fonksiyonun disindan  erisemeyiz.

}


fun main() {
    val boo = Foo()
    println(boo.name)
    println(boo.age)

    boo.printAll()


    /*
     println(boo.surname)
     println(boo.email)
     surname private,email protected oldugu icin erisemeyiz.
    */


}