package basics.basictypes

fun main() {
    /**
     * Ayni türden ya da belirtilen türün alt türünden,sabit sayıda veri tutan bir veri kümesi yapısıdır.
     * En sık kullanılan versiyonu Object-Type Arrayler'dir.Array sınıfı ile temsil edilirler.

     * Array classindan miras alacak sekilde arrayler olusturuyorsak,bunlar referans tipli arraylar olur.
     * Eğer primitive tipleri Object-Type Array olarak kullanırsanız Boxed kullanım yapmış olursunuz.
     * Bu da performansa etki eder.Eğer sadece primitivlerden oluşan arrayler oluşturcaksanız,
     * bu durumda Primitive Type Arrayler kullanmalıyız.
     * ByteArray(byte[]),ShorArray(short[]),IntArray(int[]),LongArray(long[]),DoubleArray(double[]),FloatArray(float[]),
     * BooleanArray(boolean[]),CharArray(char[])
     */

    /**
     * Genel olarak elimizde kümeleyebilecegimiz veri grupları varsa ve bunlari listelemek,goruntulemek istiyorsak,ya da üzerlerinde döngü döndürme,birşey arama gibi
     * durumlarda arrayleri kullanabiliriz.
     * Veri ekleme,veri çıkarma gibi işlemler yapacaksak,collectionsları kullanmamız daha uygundur.
     */


    /**
     * arrayof(ayni tip degerler) seklinde tanimlanabilir.
     * arrayOf<Any>(farkli tip degerler) seklinde tanimlanabilir.
     * arrayOfNulls<Type>(size) ise verilen boyut kadar null deger iceren bir dizi tanimlanabilir.
     * emptyArray() bos array tanimlar.
     */

    val studentNumbers = arrayOf(13, 45, 52, 64, 10, 20) // Sırası önemli degildir.
    val studentNumbers2 = arrayOf<Int>(
        13, 45, 52, 64, 10, 20
    ) // Aynı şekilde hepsi aynı tip veriden olusuyorsa interface kullanimina gerek yoktur.(<Int>)

    val studentNames = arrayOf("Ahmet", "Ayşe", "Veli", "Derya")
    val firstCharOfNames = arrayOf('A', 'B', 'C', 'D')
    val mixedArray = arrayOf<Any>(1, "A", true, 'C')//Farkli tipte verileri arrayin icerisine koyabiliyoruz.
    //<Any> buradaki interfacedir.Arayüz ve interface aynı seydir.
    //<


    val arrayofNulls = arrayOfNulls<String>(4)//Tipini ve size'ini belirtmek zorundayiz.
    // null null null null diye çıktı verir.
    println(arrayofNulls.joinToString())

    //Bombos bir array olusacaktir.Boyut vermedigimiz tek array emptyArray'dir.


    val emptyArray = emptyArray<String>() // "","","","" bunu yapmiyor,size'i 0 olan bir array olusturur.
    var emptyArray2: Array<String> = emptyArray()


    /**
     *     emptyArray+= "Arda"
     *     emptyArray2 = arrayOf("Arda")  Bu ikisi memory karsiliklarinda ayni anlama gelir.
     */


//    emptyArray[0] = "arda" Herhangi bir indeksi olmadigi icin bu islemi yapamayiz.ArrayIndexOutOfBoundsException hatasi aliriz.

    println("------------------------------------------------------------------------------")/*----------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Array'ler sabit büyüklüktedir.
     * Array'lere ekleme veya çıkarma yapmak aynı Stringlerde oldugu gibi memory'de yeni bir Array olusturulmasina neden olur.
     * Biz herhangi bir arraye(nasıl tanımlandıgı farketmez) yeni bir ekleme yapıyorsak,bu durumda mevcut durumdaki array'i
     * refere etmeyi bırakır,onun yerine yeni bir array olusturur.
     */

    var cityArray = arrayOf("Samsun", "İstanbul", "Ankara")
    cityArray += "Sivas"
    println(cityArray.joinToString())

    //Yukaridaki durumda,ilk basta arrayi olusturur,sonra biz Sivas'i ekledigimizde yeni bir array olusturup,
    //bu durumda cityArray,eklenmis halini refere eder.

    //Birden fazla ekleme yapmak icin,
    cityArray += arrayOf("İzmir", "Antalya")
    println(cityArray.joinToString())

    cityArray.forEach {
        print("$it ")
    }
    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * Array<Type>{higher order function} seklinde de tanimlanabilir.
     * Bu durumda higher order function icerisinde son satira denk gelen degerler diziyi olusturur.
     * Higher order function,icerisi dizinin boyutu kadar index'i(it) bir arttirarak calisir.(0,1,2,3,...)
     * Eger biz arrayleri olusturma islemi sirasinda degerleri bir takim islemlere tutma amacimiz var ise,
     * bu durumda higher order'li sekilde kullanabiliriz.
     *
     */

    // 5 elemanli,tum elemanlari (index * 3.14) yapıp degerleri bize donduren bir  dizi olusturur.

    val normalArray = Array<Double>(5) {
        //pseudo codes
        //pseudo codes
        //pseudo codes
        3.14 * it

    }
    println(normalArray.joinToString())


    // 10 elemanli,0-9 arasindaki index degerlerinin karesini alan bir dizi olustur.
    // Boyle bir kullanimi yapmasak daha iyi olur :)
    val squareArray = Array<Unit>(10) {

        print("${it * it} ")
    }

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * ByteArray,ShortArray,IntArray,LongArray,DoubleArray,FloatArray gibi ya da bunların Unsigned halleri primitive array tanımlamaları da yapılabilir.

     * .toCharArray() gibi fonksiyonlar ile Object-Typed bir array Primitive-Typed bir array'e donusturulebilir.
     * .toTypedArray() fonksiyonu ile Primitive-Typed bir array'i Object-Typed bir array' donusturebiliriz.

     * Bu tarz tanimlamalarda ilgili index degerine atama icin set(index,value) ya da [ index ] = value kullanilabilir.
     * Bu tarz tanimlamalarda ilgili index degerindeki degisken degerine get(index) ya da [ index ] seklinde ulasilabilir.
     */


    val firstCharOfCountries = CharArray(4)
    firstCharOfCountries[0] = 'T'
    firstCharOfCountries.set(1, 'U')

    println(firstCharOfCountries[0])
    println(firstCharOfCountries.get(1))

    println(firstCharOfCountries.joinToString())

    val charSample: CharArray =
        arrayOf('T', 'U', 'R', 'K', 'E', 'Y').toCharArray() // Bu sekilde primitive halini alabiliriz.
    println(charSample)

    val byteArray = ByteArray(5)
    val shortArray = ShortArray(5)
    val intArray = IntArray(5)
    val longArray = LongArray(5)
    val doubleArray = DoubleArray(5)
    val charArray = CharArray(5)
    val booleanArray = BooleanArray(5)
    val floatArray = FloatArray(5)

    println("ByteArray:${byteArray.joinToString()}")
    println("ShortArray:${shortArray.joinToString()}")
    println("IntArray:${intArray.joinToString()}")
    println("LongArray:${longArray.joinToString()}")
    println("BooleanArray:${booleanArray.joinToString()}")
    println("FloatArray:${floatArray.joinToString()}")
    println("DoubleArray:${doubleArray.joinToString()}")
    println("CharArray:${charArray.joinToString()}")


    println("------------------------------------------------------------------------------")
    val numbersArray = IntArray(5) {
        println("Arda baba")
        10 * it
    }
    println("NumbersArray:${numbersArray.joinToString()}")

    val doubleArray2 = DoubleArray(5) {

        2.5 * it
    }


    println("DoubleArray2:${doubleArray2.joinToString()}")


    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * val ile tanimlanmis bi arrayin herhangi bir indexindeki degeri degistirebiliriz.
     * val indexdeki degerlerin degismesine karısmaz
     * Anca ilgili bir diziyi baska bir diziye esitleyemeyiz.
     * Bunun icin tanimlamayi var ile degistirmemiz gerekir.
     * Arrayler mutable'dir,icerisindeki indexlerdeki degerler degisebilir.
     */

    val awesomeArray = arrayOfNulls<Int>(4)
    println(awesomeArray.joinToString())
    awesomeArray[2] = 2
    println(awesomeArray.joinToString())

//    awesomeArray = arrayOf(1,2,3,4,5) Bu sekilde calismaz.

    /**
     *  Array'in size'i disina (boyutu disina) cikiyorsak,IndexOutOfBound hatasi aliriz.
     */
    awesomeArray[3] = 10
    println(awesomeArray.joinToString())
//    awesomeArray[4] = 9 bu kisim calismaz.

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    //2 boyutlu arrayler
    val twoDArray = Array(2) {
        Array(2) {
            0
        }
    }
    println(twoDArray.contentDeepToString())


    //3 boyutlu arrayler
    val threeDArray = Array(3) {
        Array(3) {
            Array(3) {
                0
            }
        }
    }
    println(threeDArray.contentDeepToString())

    //Arrayler her zaman mutabledir.
    val simpleArray = arrayOf(1, 2, 3)
    simpleArray[0] = 10
    twoDArray[0][0] = 2

    println(simpleArray[0])
    println(twoDArray[0][0])


    //  Ayni zamanda array'ler üst classlari yerine atanamazlar.(invariant)
    //  Atayamamak var ya da val olmasindan kaynaklanmaz.
    //  Herhangi bir array'in ust classindaki bir array'in yerine atanamamasi durumuna invariant denir.
    //  Mülakatta çıkmayabilir fakat detay bir kotlin sınavında sorulabilir

    val arrayOfString: Array<String> = arrayOf("V1", "V2")
//    val arrayOfAny : Array<Any> = arrayOfString Burasi calismaz.

    val arrayOfAny2: Array<Any> = arrayOf("V1", "V2")
    // Yukaridaki string array'in karsiligini direk olarak atayamiyoruz.
    // Fakat ayni array'i arrayOf ile verebiliriz.

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * vararg kelimesi ile istedigimiz sayida parametreyi kabul edebiliriz.
     * Eger vararg'a denk gelecek sekilde bir array kullanmak istiyorsak,"spread" "*" operatoru kullaniriz.
     * Spread operatoru,verdiginiz array'in elemanlarinin her birini bir variable olacak sekilde parametre olarak paslar.
     */

    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", "c", "d", "e")
    println()
    printAllStrings("a", "b", *lettersArray)

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * Array'leri karşılaştırırken == operatorunu kullanamayiz.== operatoru o array'lerin referans objectlerini karşılaştırır.
     * contentEquals ya da contentDeepEquals kullanmamiz gerekir.
     */
    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(1, 2, 3)

    println(array1 == array2) //Aslinda degiskenlerdeki === gibi dusunebiliriz.Memory'de tutuldugu yerler farkli oldugu icin false degeri aliriz.
    //Degerleri ayni olsa bile!!

    val array3 = array1
    val array4 = array1
    println(array3 == array4) // Fakat burda array3 ve array4 ayni yeri isaret eder,referanslari aynidir.Burda true degerini aliriz.


    println(array1.contentEquals(array2))//Tek boyutlu bir arrayimiz var ise icerideki degerleri karsilastirir.

    val array5 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    val array6 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

    println(array5.contentDeepEquals(array6)) // Cok boyutlu bir arrayimiz var ise icerideki degerleri karsilastirir.


    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/ Array'lerde kullanabilecegimiz fonksiyonlarin listesi.

    val sumArray = arrayOf(1, 2, 3, 4)
    println(sumArray.sum())

    val shuffledArray = arrayOf(1, 2, 3, 4)
    shuffledArray.shuffle()
    println(shuffledArray.joinToString())

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")


    /**
     * Array'leri List'e ve Set'e dönüştürebiliriz.
     */

    val sampleArray = arrayOf("a", "b", "c", "c")
    println(sampleArray.toSet())

    println(sampleArray.toList())

    /**
     * Map'lere de donusturebiliriz.Ancak bunun icin arrayin ozel olarak Pair<K,V> formunda olması lazim.
     */

    val cities = arrayOf("Istanbul" to 34, "Samsun" to 55, "Bursa" to 16)
    println(cities.toMap())
}

fun printAllStrings(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}