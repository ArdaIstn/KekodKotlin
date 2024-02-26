package basics.controlflow

/**
 * +,-,*,/,% hangi operatoru kullaniyorsak,o operatorun asil yaptigi is disinda yeni bir anlam yuklememize OperatorOverload denir.
 * Overload kelimesi aşırı yüklemek demektir,yani aynı fonksiyonu birden fazla anlamda kullanmamizdir.

 * Bunun sayesinde aşağıdaki örnekte sadece bir number kullanabileceklerken,numberlarin yerine class referansi da kullanabiliyoruz.
 *
 * Burdaki önemli bir nokta da eğer operator fonksiyonlarini overload ediyorsak,
 * operatörün anlam bütünlüğünü bozmamaya çalışmalıyız.(çıkarmaysa çıkarma,toplamaysa toplama vs)

 * Düzenli olarak kullandığımız bir operatör var ise ve yaptığımız çeşitli işlemler
 * veya hepsinde ortak işlemler var ise operator overloading'i kullanabiliriz.

 * Herhangi düz bir fonksiyonu operator yapamayiz.
 * Eger minus fonksiyonundan operator keywordunu kaldırırsak,fonksiyon halini kullanabiliriz.
 * Fakat operator(-) halini kullanamayız.
 */


data class PairNumber(val numberOne: Int, val numberTwo: Int) {
    operator fun minus(pairNumber: PairNumber): PairNumber {

        val localNumberOne = numberOne - pairNumber.numberOne
        val localNumberTwo = numberTwo - pairNumber.numberTwo

        val returnPairObject = PairNumber(localNumberOne, localNumberTwo)

        println("Çıkarma Sonuç:${returnPairObject.numberOne},${returnPairObject.numberTwo}")



        return returnPairObject
    }


    operator fun plus(value: Int) {
        println("Toplama Sonuç:${numberOne + value}")
    } // Bu sekilde plus operatorunu ve fonksiyonunu ozelleştirip kullanabiliriz.

}


fun main() {
    val a = 5
    val b = 8

    //Operatorler arka planda eslenigi olan(corresponding) methodu cagirir.
    var result = a + b
    result = a.plus(b)

    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

//    val resultOne = pairNumberOne.numberOne - pairNumberTwo.numberOne
//    val resultTwo = pairNumberOne.numberTwo - pairNumberTwo.numberTwo

//    println("Sonuc:$resultOne,$resultTwo")

    /*-----------------------------------------------------------------------------------------------------------------*/

    /**
     * Yukaridaki sekilde yapmak yerine,minus fonksiyonunu overload ederek(yapacagi isi degistirerek) asagidaki gibi
     * kullanabiliriz.
     */


    pairNumberOne - pairNumberTwo
    pairNumberOne.minus(pairNumberTwo)

    pairNumberOne.plus(5)
    pairNumberOne + 10

    /* pairNumberTwo.plus(pairNumberTwo)
      pairNumberTwo + (pairNumberTwo)*/


    /* pairNumberOne.times(pairNumberTwo)
     pairNumberOn * (pairNumberTwo)*/


    /*-----------------------------------------------------------------------------------------------------------------*/

    /**
     * Times(*) işlemini yapamıyorum fakat minus(-) işlemini yapabiliyorum.Bu durumda bunlar bir classin nesnesi iken,
     * minus(-) operatoru kullanılabiliyorsa,bu classın tanımının uapıldığı yerde minus(-) operatörü overload edilmiştir.
     * Aynı şekilde Plus(+) operatorunu de yukarıdaki gibi class içerisinde overload ettiğimizde kullanabiliriz.
     */

    val pairNumber = pairNumberOne - pairNumberTwo

    val pairNumber2 = pairNumberOne - pairNumberTwo

    val pairNumber3 = pairNumberOne - pairNumberTwo

    val pairNumber4 = pairNumberOne - pairNumberTwo

    val pairNumber5 = pairNumberOne - pairNumberTwo

    val pairNumber6 = pairNumberOne - pairNumberTwo
}