package classes

/**
 * Sealed Classlar sinirli kumede,gruplanabilir classlar yazmamizi saglar.
 * Kisitlanmis bir class hiyerarsisi kurabilmemizi saglar.
 * Kisitlanmis bir class hiyerarsisini developer'in keyfiyetinden cikarip,IDE'nin kontrolune vermis oluruz.
 * Enum class'lar verileri gruplarken,sealed classlar classlar'i gruplar.
 *
 */

/** SEALED CLASS OZELLIKLERI
 * Visibility Modifierlar ile ozel bir kisiti yoktur.
 * Primary Constructor tanimlanabiliyor.
 * Init blogu kullanilabiliyor.
 * Secondary constructor olusturulabilir.
 * Sealed classlar baska bir classi miras alabilirler.Bu class'in open,abstract,sealed olmasi farketmez.
 * Interface implement edilebilir.Eger body'siz bir fonksiyonu varsa subclass'lar bunu override etmek zorundadir.
 * İnit'i ve constructor'ı olsa bile,nesnesi direkt olarak uretilemez ve primary'i constructor'ı default olarak private degil,protected olarak bulunur.
 * Bu Primary constructor icerisine tanimlanan propertyler,subClass'larda ister constructor icerisinde ister birer sabit olarak miras alindigi yerde degeri atanabilir.
 * Eger constructor'ı private'ye cekerseniz bu sayede sub classlar'in bu class scoop'u disinda miras alınmasini engellemis olursunuz.
 * Bu da ozellikle daha kisitli bir hiyerarsi kurmak istediginiz kutuphane kullanimlarinda (closed api) onemlidir.
 * Companion object tanımı yapılabilir.
 * Final,open,inner ya da enum class yapilamazlar.
 * Abstract kw kullanmak redundant uyarisi verir cunku arka planda zaten abstract class olarak tutulurlar.
 * Sealed Class içerisinde normal fonksiyon,open fonksiyon ve abstract bir fonksiyon veya abstract bir property tanımlanabilir.
 * Abstract bir fonksiyon veya abstract bir property tanımladığımızda bu fonksiyonu veya property'i child classlarda override etmek zorunludur.
 * Fakat sub class'ların içerisine abstract bir fonksiyon veya property tanimlayamayiz.
 *
 * Direct -> Eger bir class Sealed Class'i birinci seviyede miras aliyorsa buna denir.
 * InDirect -> Eger bir class Sealed Class'i miras almis Sealed olmayan bir class'i miras aliyorsa denir.
 * Direct classlar'in constructor'ında Sealed Class'tan bagimsiz property'ler tanimlanabilir.
 * Direct class'larda sealed classlardan bagimsiz interface implement edilebilir.Bu bize bir esneklik getirir.(Bunu enum classlarda farklar sorulursa kesin soyle)
 * Direct classlar zaten sealed class'i miras aldigi icin ve ayni zamanda Kotlin'de Multiple Inheritance desteklenmedigi icin herhangi bir class'i miras alamazlar.
 * Direct class'lar icerisinde Sealed Class'tan bagimsiz olarak companion object tanimlanabilir.
 * Direct class'lar icerisinde normal,open ve abstract fun tanimi yapilabilir.Abstract fun tanimi kullanilabilmesi icin de direct class'ın abstract olması gerekir.
 * Direct class'lar enum class disinda diger class turlerini alabilirler.sealed,inner,abstract,data,open olabilir.Ancak enum class olamamasinin sebebi
 * Enum class'lar baska bir class'i miras alamazlar.Ama Direct class'lar açık bir şekilde zaten Sealed Class'i miras almalidirlar.
 * Direct Class'larin birden fazla nesnesi olusturulabilir.Enum'larda sabitler tek bir nesne olarak memory'de tutulurlar.


 * Direct Class'lar enumlarda oldugu gibi static değillerdir.(Sealed Class'nın scoope'u içerisinde kullaniliyorsa static olurlar,
 * ama ozunde static olmadiklari icin kullanilirken nesnelerinin uretilmesi gerekmektedir).
 *
 * Sealed classlar aynı modül veya package icerisinde geçerlidir.Farkli moduller tarafindan gorulemezler.

 * Sealed classlar'ın direct classlari compile time'da biliniyor.Bu durumda ornegin when yapisi kullanirken,else case'i yazmamiza gerek yoktur.
 * IDE gelebilecek senaryolari bilir,yazmadigimizde ise bizi uyarir.
 * Normal class'larla yapsaydik,compile time'da bilinmeyecekti.
 */


/**
 * Enum Class'larda ayrimi soyle yapabilirim,eger ki her bir sabit  kendi icerisinde ayrisacaksa ve class olmanin
 * ozelliklerini kullanacaksam sealed class,ama butun sabitler yaptigim seylerde ayni ozelliklere sahip olsun,ayni fonksiyonlara sahip olsun,
 * ayni interfaceleri implement edebilsin yani kendi baslarina farklilasmasin istiyorsak enum class kullanmaliyiz.
 */

sealed class Errors(var errorNumber: Int) : A {
    class NoInternet(val errorMessage: String) : Errors(100), someOtherInterface {
        override fun myFun() {
            TODO("Not yet implemented")
        }


        override fun foo() {
            TODO("Not yet implemented")
        }

        override fun someOtherFoo() {
            TODO("Not yet implemented")
        }

        fun specialFun() {

        }

        open fun specialFun2() {

        }

        

//        abstract fun specialFun3(){
//
//        }  Normal bir class'in icerisinde abstract bir fun yazamam.
    }

    class ServerError : Errors(200) {
        override fun myFun() {
            TODO("Not yet implemented")
        }

        override fun foo() {
            TODO("Not yet implemented")
        }
    }

    open class fileIoError : Errors(300) {
        override fun myFun() {
            TODO("Not yet implemented")
        }

        override fun foo() {
            TODO("Not yet implemented")
        }
    }


    abstract fun myFun()

    open fun someFun() {}

    companion object {

    }


}


interface someOtherInterface {
    fun someOtherFoo()
}

/*********************************************************************************************************************/

open class C() : Errors(500) {
    override fun myFun() {
        TODO("Not yet implemented")
    }

    override fun foo() {
        TODO("Not yet implemented")
    }

}

class MyClass() : C() {

}
// Burda C Class'i Direct,MyClass ise InDirect bir Class'tir.

/*********************************************************************************************************************/


sealed class AA

class CC() : AA()

class BB() : AA()
// Bu sekilde de kullanilabilir


interface A {
    fun foo()
}


fun main() {

    var error = Errors.NoInternet("No Internet")
    var error2 = Errors.NoInternet("No Internet")
    var error3 = Errors.NoInternet("No Internet")


}