package classes

/**
 * Kotlinde classlar default olarak final,Javada ise classlar default olarak open durumundadir.
 * Open:Miras alinabilir,Final:Miras alinamaz demektir.
 * Eger sahip oldugumuz ozellikler veya fonksiyonlar(degerleri farkli olabilir) baska classlarda da varsa,ust bir class
 * olusturup,o classa ilgili ozellikleri ve fonksiyonlari yazdiktan sonra child classlar tarafindan miras alinmasini saglayabiliriz.
 * Bu sayede asagidaki ornekteki gibi child classlarda ayni fonksiyonlari ve ozellikleri tekrar tekrar yazmaya gerek kalmadan inheritance sayesinde
 * parent classı miras alıp,direk olarak kullanabiliriz.
 * Burda onemli olan ozelliklerin veya fonksiyonlarin ayni olmasidir.Elbette value'lari classimiza gore degisebilir
 */

/**
 * Miras almada birinci amacimiz ust classin butun ozelliklerini kullanabilcek sekilde child classlar olusturmaktir.
 * Ikinci amacimiz Ust classda olmasini istemeyecegimiz ancak child classda olmasini isteyecegimiz ozellikler olursa child class olusturabiliriz,miras almayi yapariz.
 * Ucuncu olarak Ust classlarda sahip oldugumuz yetkinlikleri child classlarda degistirmek isteyebiliriz.
 */

/**
 * MÜLAKAT SORUSU GELEBİLİR !!
 * Final ve Open keywordleri nedir ?
 * Bunlara Accesibility Modifier denir.Open veya final kullanmamiz miras alinmayla ilgili bir durumdur.
 * Eger biz bir classin onune open koyarsak o classin miras alinabilecegi anlamina gelir.
 * Eger biz bir degiskenin veya fonksiyonun onune open koyarsak bu durumda da o degisken child classlarda override edilebilir anlamina gelir.
 * (Dinamik Polymorphism )

 * Ayni sekilde biz bir classin onuna Final koyarsak ki Kotlinde default olarak classlar Final durumundadir, bu durumda
 * bu class miras alinamaz demektir.
 * Eger bir degiskenin veya fonksiyonun onune Final koyarsak ki Kotlinde default olarak degiskenler ve fonksiyonlar final durumundadir,bu durumda bu degisken veya fonksiyon child classlarda
 * override edilemez anlamina gelir.
 */

/**
 * MÜLAKAT SORUSU GELEBİLİR !!
 * Polymorphism Nedir ?
 * Cevap: Polymorphism basitce ust classta bulunan bir degiskeni veya fonksiyonu,override ederek anlamini veya gorevini
 * degistirerek child classlarda kullanmaktir.Bu durumda override edecegimiz fonksiyonunu veya degiskenin onune open
 * keywordunu koymamiz gerekir.
 * Dynamic Polymorphism ve Static Polymorphism olmak üzere ikiye ayrılır.
 */


open class Animal(open val name: String = "", val feetCount: Int = 4) {

    open var origin: String = ""
    var tailShape: String = ""

    open fun makeASound(): String {
        return ""
    }

    fun attackToTheWolf() {

    }

    fun eat() {

    }

    fun walk() {

    }

    fun dance() {

    }
}


class Dog(name: String, feetCount: Int) : Animal(name, feetCount) {
    override fun makeASound(): String {
        return "Hav Hav" // Dynamic Polymorphism
    }


    fun call(arda: Arda) {
        arda.foo() // Static Polymorphism
    }

    fun call(ahmet: Ahmet) {
        ahmet.boo() // Static Polymorphism
    }

    /**
     * Yukaridaki fonksiyonlarin uretecegi degerler bellidir yani direk classin icerisinde yazilidir,ondan bu statik bir bilgidir.(Static kw ile ilgisi yoktur, o farkli bi durumdur)
     * Fakat makeASound fonksiyonunda farklı classlar icerisinde uretecegi degerler degisebilecegi icin bu dinamik bir bilgidir.
     */
}

class Arda {
    fun foo() {}
}

class Ahmet {
    fun boo() {}
}

class Cat(override val name: String) : Animal(name) {
    override fun makeASound(): String {
        return "Miyav Miyav" // Dynamic Polymorphism
    }
}


fun main() {
    val dog = Dog("Karabas", 4)
    val cat = Cat("Boncuk")

    println("DogName:${dog.name},DogFeetCount:${dog.feetCount}")
    println("CatName:${cat.name},CatFeetCount:${cat.feetCount}")

    println(dog.makeASound())
    println(cat.makeASound())


}