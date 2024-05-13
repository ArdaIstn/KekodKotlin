package classes

/**
 * Genericler tipini bilmedigimiz herhangi bir degiskeni bekledigimiz durumda kullandigimiz yapilardir.
 * Kotlin'de classlar type parameters'lara sahip olabilirler.(Genericslerle aynı anlamdadir)

 * Kotlin wildcard'lari desteklemiyor.(Javada ? wildcard'dir)
 * Bunun yerine Declaration-site variance ve type projections kavramlari vardir.
 * Wildcards kısmı için javaya bakalım.

 * Kotlin'de ve Java'da Genericler invariant(değişmez) durumundadir,yani birbirleri yerine kullanilamazlar.
 * Bunun anlami List<String>,List<Object>'in bir alt tipi değildir.(Java:Object = Kotlin:Any)
 * Eğer list'ler invariant olmasaydi,Javada'ki arrayler'den bir farki kalmazdi.
 * Normal bir fonksiyonda ust sinifi verdiysek alt siniflarini verebiliriz.
 * Fakat generic tip bekledigimiz bir yerde ust sinifi verdigimiz bir yerde direkt olarak alt siniflari veremeyiz.Ne veriyorsak onu alabiliriz.(Invariant)

 * Co-Variance:Generic Type kullanirken,parametre olarak kendisini ya da child classlarini bekledigimiz durumda Co-Variance bir kullanim yapmis oluruz.
 * Contra-Variance:Generic Type Kullanirken,parametre olarak kendisini ya da supertypelarini,ust classlarini bekledigimiz durumda Contra-Variance bir kullanim yapmis oluruz.
 *
 * Invariant:Generic tiplerde biz bir fonksiyona veya classa parametre olarak sadece kendisini verdiysek,o generic tipin child'ini veya supertype'ini veremeyiz,sadece kendisini verebiliriz.
 * Fakat sadece generic bir tip olarak belirtiyorsak(T,K,E gibi,önünde in veya out olmadan).(MÜLAKAT SORUSU GELEBİLİR)
 * Generic typler tek basina kullanildiginda,sadece belirtilen arayuzdeki tip neyse o tipin degiskenlerini kabul etmesidir.Supertypelarini veya childtypelarini kabul etmez.
 *
 * Invariant durumununun ötesine geçebilmemiz için,bir kısıtlamada bulunuruz.
 * Örneğin tipini belirlemediğim bir classa ihtiyacim var, şu class ve altlari veya şu class ve supertypelari olabilir gibi bir kisitlama vermis oluruz ki bu tarz bi kullanimi yapabilelim.
 * Javada ? extends E kullanımı kendisi ve childlarini,  ? super E ise kendisini ve supertype'larini belirtmis oluruz.
 * UNUTMA:Supertype bir class veya bir interface olabilir.
 */

/**
 * MÜLAKAT SORUSU ÇIKABİLİR!
 * Generic Typler nedir,neden kullanılır ?
 * İnvariant Nedir ?
 * Co-Variant Nedir ?
 * Contra-Variant Nedir ?
 * (Cevaplari yukarıda yer almaktadır)
 *
 * Neden Any Yerine Generics Kullaniyoruz ?(Cevabı GenericsIntro.kt dosyasında)
 */

class Box<T>(t: T) { // Class kullanirken bu sekilde veririz.
    // Özetle ben buraya öyle bir T veriyorum ki,o değişkenin ne olduğuyla ilgilenmiyorum anlamına gelir.

    var value = t

    fun print() {
        println(value)
    }

    fun <L> foo(l: L) {

    } // Ya L gibi birseyi parametre olarak almasi lazim ya da geri donus degeri olarak almasi lazim.
}

class asdasd(param: Any) {

}

fun main() {

    // Basitce instancesini olusturabiliriz.
    // Kotlinde de javada da generic'ler invarianttir.
    // Örneğin,ben burda Box<Int> yerine Number verirsem, eşitlikte Box<Int> seklinde bir kullanim yapamam.Tam tersi de geçerlidir.
    // Sadece generic type kullandığımızda bu durum geçerlidir.
    val box: Box<Int> = Box<Int>(1)

    val box2 = Box("Hello World") // type inference'de aldığı değer üzerinden yapılabilir.

    val box3 = Box(10.5) // Bu durumda da box3'ün tipi Double olur.



    box.print()
    box2.print()
    box3.print()

    /***********************************************************************************************************************/

}


/**
 * Declaration-site variance(out ve in keywordleri)
 */

// out,co-variance kullanımlar için lazımdır.(Kendisi veya SubType'lari geçerli olsun istiyorsak)

interface Source<out T> { // Kendisi veya  SubType'larini verebilirim.
    fun nextT(): T
}
// Java:interface Source<? extends T>

fun demo(source: Source<String>) {

    val objects: Source<Any> = source

    objects.nextT()
}


// in,contra-variance kullanimlar için lazimdir.(Kendisi veya Supertype'ları geçerli olsun istiyorsak)

interface Comparable<in T> { // Kendisi veya SuperType'larini verebilirim.
    operator fun compareTo(other: T): Int
}
// Java:interface Comparable<? super T>


fun demo(x: Comparable<Number>) {

    x.compareTo(1.0)

    val y: Comparable<Double> = x

}

//Burda amac bir array'in diger array'in tum item'larini kopyalayabilmesidir.

fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)

    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun copy2(from: Array<out Any>, to: Array<Any>) {}

fun copy3(dest: Array<in String>, value: String) {}

fun demo2() {
    val ints: Array<Int> = arrayOf(1, 2, 3, 4)
    val any = Array<Any>(3) { "" }

    //Array<T> bu durum için,Array<Int> invariant durumunda,yani değişmez.
    // Yani ne Array<Int> ne de Array<Any> birbirinin subtype'ı değildir.(invariant durumu)

//    copy(ints, any)


    // copy2'deki kullanima baktigimizda ise bunu artik yapabiliriz.Buna Type-Projection diyoruz.
    // copy2'deki Array<out Any> ifadesi,javadaki Array<? extends Object> karşiligi oluyor.(co-variance durumu)
    // Yani copy2 fonksiyonu, Array<out Any> diyerek Any class'i ve onun subType'larini alabilir diyoruz.

    copy2(ints, any)

    // copy3'deki Array<in String> ifadesi,Javada'ki Array<? super String> ifadesine karsilik gelir.

    val strings: Array<Any> = arrayOf(1, 'A', "C")

    copy3(strings, "a") // in String demek,String class'i ve onun superType'larini alabilir anlamina gelir.
    // Bu durumda ben Any classini da parametre olarak verebilirim.(contra-variance durumu)

    /***********************************************************************************************************************/

    /**
     * Star Projection
     * Bazen type argument hakkinda hicbirsey bilmeyiz,yine de bunu guvenli bir sekilde kullanabilmemiz lazimdir.
     *
     * Foo<out T:TUpper>T bu durumda co-variant oluyor ve kendisi veya subtype'larini alabiliyor.
     * Foo<*> ise Foo<out TUpper>'ın esdegeri oluyor.read için->Foo<out TUpper>
     *
     * Foo <in T> T bu durumda contra variant oluyor ve kendisi ile supertypelarini alabiliyor.
     * Foo<*> ise Foo<in Nothing>'in esdegeri oluyor.write için Foo<in Nothing> oluyor.
     *
     * Foo<T:TUpper> T Bu durumda in-variant oluyor,superi TUpper için.
     * Foo<*> ise read için -> Foo<out TUpper>write için Foo<in Nothing> oluyor
     */


    /**
     * Function<*,String> ifadesi Function<in Nothing,String> olur.
     *
     */

    // Bu ifade,Function'ın parametrelerinin turlerini belirtmedigimiz ancak dönüş değeri türünün String
    // olduğu bir fonksiyonu temsil eder.Bu durumda,herhangi bir türden parametre kabul edebiliriz,
    // ancak dönüş değeri her zaman String olmalıdır.Bu,Kotlin'de Functino<in Nothing,String> ile
    // aynı şeyi ifade eder.Nothing,diğer tüm türlerin alt türüdür,bu yüzden Function herhangi bir türden parametre kabul edebilir.


    /**
     * Function<Int,*> ifadesi Function<Int,out Any?>.
     */

    // Bu ifade,Function'ın Int türünden bir parametre aldığı ancak dönüş değeri türünün belirli bir
    // türle sınırlı olmadığı bir Function'ı temsil eder.Yani,herhangi bir dönüş değeri türüne sahip olabilir.
    // Bu durumda,dönüş değeri Any? olarak kabul edilir,çünkü Any? türü herhangi bir türün alt türüdür ve nulalble olabilir.(? işareti)


    /**
     * Funciton<*,*> ifadesi Function<in Nothing,out Any?>

     */

    // Bu ifade,hem parametrelerin hem de dönüş değerinin türlerinin belirli bir türle sınırlı olmadığı bir
    // Function'ı temsil eder.Yani Function herhangi bir türden parametre kabul edebilir ve herhangi bir türde
    // dönüş değeri verebilir.Bu durumda,yine Function<in Nothing,out Any> ile aynıdır; çünkü parametre
    // türü Nothing(yani herhangi bir tür) ve dönüş değeri türü Any?(yani herhangi bir tür veya nullable olabilir)
}

class Boxs<T>(val item: T)

fun printBox(box: Boxs<*>) {
    val item = box.item
    println("Item is $item")
}

fun demo3() {
    val stringBox = Boxs("Hello World")
    val intBox = Boxs(55)

    printBox(stringBox)
    println(intBox)
}

inline fun <reified A, reified B> Pair<*, *>.asPairOf(): Pair<A, B>? {
    if (first !is A || second !is B) return null
    return first as A to second as B
}

val somePair: Pair<Any?, Any?> = "items" to listOf(1, 2, 3)


val stringToSomething = somePair.asPairOf<String, Any>()
val stringToInt = somePair.asPairOf<String, Int>()
val stringToList = somePair.asPairOf<String, List<*>>()
val stringToStringList = somePair.asPairOf<String, List<String>>() // Compiles but breaks type safety!
// Expand the sample for more details


/**
 * Generic typlerde refied keywordu bize kullandigimiz generic type'in hangi tipte oldugunun bilgisini verir.
 * Bu sayede ilgili class'ın kendi özelliklerini kullanabilmemizi veya type casting işlemlerini yapabilmemizi sağlar.
 */

/**
 * Kotlin'de generic typler'in default olarak compile time sirasinda degiskenlerinin tipi bellidir,fakat runtime sirasinda
 * degisken tipleri belli degildir.Bu durumda runtime sirasinda o degiskenin tipiyle alakali bir islem yapmaya calisirsak TYPE ERASURE problemini yasariz.(tipi belli degil cunku)
 * Eger bu TYPE ERASURE problemini engellemek istiyorsak yani o generic type'in tipiyle alakalı birsey yapmak istiyorsak inline ve refied kw'lerini kullanmaliyiz.
 *
 */