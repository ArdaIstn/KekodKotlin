package classes

/**
 * Classlar class keywordu ile baslar.Icerisinde fonksiyonlar ve propertyler tanimlanabilir.
 * Best practice olarak class isimlerini buyuk,fonksiyon isimlerini kucuk harfle baslamaliyiz.
 * Class'ın nesnesini olustururken constructor parantezlerini veririz.
 * Constructor insa edici,olusturucu anlamina gelir.
 * Kotlinde javadan farkli olarak constructor parantezleri class'ın yanına yazılır.Javada bu yoktur.
 * Constructorlarla ilgili yani biz hangi parametrelerle nesneyi olusturacaksak o parametrelere sahip ya bir primary constructor,
 * ya da secondary constructorlar veya constructor olusturmaliyiz.Olmayan parametrelerle nesne olusturamayiz.
 * Ek olarak,Kotlinde bir primary constructor yazmazsak veya javada hiç bir constructor yazmasak da arka planda default olarak boş bir  constructor olusur.
 * Constructorlarin parametrelerini yemek tarifi gibi dusunursek,olustururken de malzemeleri dogru sirayla ve dogru parametrelerle vermemiz lazim.
 *
 *
 */
/**
 * 1.mülakat sorusu olarak kotlindeki constructor yapısını anlatınız sorusu gelebilir!!!.
 * 2. mülakat sorusu olarak init bloğu nedir sorusu gelebilir!!!.
 * -> Cevap:Primary constructor'ın body'si oldugu icin,primary constructor calistigi anda init blogu da calisacaktir.
 *
 */


class Turtle(val name: String = "Tosbik", val feetCount: Int = 4) {

    // Primary constructor icerisindeki parametrelere val ya da var vermemiz, init blogu disindan da erisilmesini saglar.
    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    val sex: String = "Female"
    val isMarried: Boolean = true

    init { // Primary constructor cagirildigi zaman calisan bloktur.Primary constructor'ın body'sidir.
        println("Init block is working.")
        println("Name:$name,FeetCount:$feetCount")
        println("******************")

    }

    constructor(name: String = "Kosbik", feetCount: Int = 4, isMarried: Boolean = true) : this(name, feetCount) {
        println("Secondary constructor is working.")
        println("***********************")
    } // Secondary constructor'dır.Herhangi bir sebepten constructor overload yapacaksam bu sekilde kullanabilirim.
    // Secondary constructor'ı cagrirsak bile this ile primary constructor'ı isaret edecegi icin oncelikle init blogu(primary constructor body'si) calisacaktir.
    // Sonrasinda ise secondary constructor'ın body'si calisacaktir.(Siralamala: init blogu -> Secondary constructor blogu)
    // Javada oyle degildir,hangi constructor'dan nesne uretiliyorsa o constructor'ın body'si calisir,bir yeri isaret etmez.
    // Secondary construcor'lar primary constructor'ın default deger icermeyen tum degiskenlerini icermek zorundadir.
    // İcermiyorsa da this() icerisine direk degerler verilebilir fakat bu kotu bir kullanimdir.

    constructor(name: String, feetCount: Int, age: Int) : this(name, feetCount) {
        println("Second secondary constructor is working.")

    }


    fun makeASound(): String {
        return "hrhrhrhrhrh"

    }

    fun eatMeal() {
    }

    fun walk() {

    }

    fun swim() {

    }

}


fun main() {
    val turtleOne: Turtle = Turtle()
    val turtleTwo: Turtle = Turtle("Murtle")
    val turtleThree: Turtle = Turtle(feetCount = 4)
    val turtleFour: Turtle = Turtle("Curtle", 4) // 2 adet default parametre vererek 4 farklı sekilde yazabiliriz.
    // Bu sayede fonksiyonlarda function overload'ı engelleyebildigimiz gibi,constructor overload'ı da engelleyebiliriz.
    val turtleFive: Turtle = Turtle("Gurtle", 4, false)
    val turtleSix: Turtle = Turtle(isMarried = true)
    val turtleSeven: Turtle = Turtle("Furtle", 4, 2)


}

