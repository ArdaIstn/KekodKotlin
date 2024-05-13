package basics.basictypes

fun main() {
    /**
     * Sonlu sayili liste olusturmaya yarar.
     */

    /**
     * Kucukten buyuge liste olusturma icin;

    ".." operatoru,ya da rangeTo()
    "..<" operatoru, ya da rangeUntil()
    fonksiyonunu kullanabiliriz.
     */

    val numbers = 1..100 //[1,100]

    println("Numbers")
    for (number in numbers) { //[1,100]
        print("$number ")
    }
    println()

    println("Numbers2")
    val numbers2 = 1.rangeTo(100)
    for (number in numbers2) { //[1,100]
        print("$number ")
    }

    println()

//    val numbers3 = 1 rangeTo 100 // İnfix seklinde kullanim yapamiyoruz.

    val numbersUntil = 1..<100//[1,100)

    println("Numbers Until")
    for (number in numbersUntil) { //[1,100)
        print("$number ")
    }

    val numbersUntil2 = 1.rangeUntil(100)
    // val numberUntil3 = 1 rangeUntil 100 İnfix seklinde kullanim yapamiyoruz.

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * Char'lardan olusan bir liste de tanimlanabilir,Turkce karakterler icermez.
     *
     */

    val alphabet = 'A'..'Z'


    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * Buyukten kucuge .. operatorunu kullanarak liste olusturamayiz.Ide hata verecektir.
     * Buyukten kucuge liste olusturmak icin downTo() fonksiyonunu kullanabiliriz.Infix kullanimi da vardir.
     */

//    val reversedNumber = 100..1 This range is empty,Did you mean to use 'downTo()' uyarısı verir.

    val reversedNumber = 100.downTo(1)
    val reversedNumber2 = 50 downTo 1


    println("Reversed Numbers")
    reversedNumber.forEach { print("$it ") }
    println()

    println("Reversed Numbers2")
    reversedNumber2.forEach { print("$it ") }


    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * until fonksiyonu kullanarak da range tanimlanabilir.Ancak bu durumda bitis degeri listeye dahil edilmez.
     */

    val gradeNumbers = 10.until(100) //[10,100]
    val gradeNumbers2 = 100 until 10

    println("Grade Numbers ")
    gradeNumbers.forEach { print("$it ") }

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * step fonksiyonu kullanarak liste olustururken belli sayıda atlamalar yapabiliriz.
     */
    val stepedNumbers1 = 1..101 step (2)
    val stepedNumbers2 = 1..101 step 3


    println("Steped Numbers1")
    stepedNumbers1.forEach { print("$it ") }
    println()
    println("Steped Numbers2")
    stepedNumbers2.forEach { print("$it ") }

    println()

    val reversedStepedNumbers1 = 100 downTo 1 step (2)
    val reversedStepedNumbers2 = 100 downTo 1 step (3)

    println("Reversed Steped Numbers1")
    reversedStepedNumbers1.forEach { print("$it ") }
    println()
    println("Reversed Steped Numbers2")
    reversedStepedNumbers2.forEach { print("$it ") }

    println()/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    println("------------------------------------------------------------------------------")

    /**
     * CharRange,IntRange ve LongRange isimlerinde özel rangeler vardır.Progression olarak adlandirilirlar.
     * Diger tipler bulunmaz.
     *
     * Genelde IntRange kullaniriz.
     *
     * Bu durumda first,last,step,count gibi ek bilgiler alabilirler.
     *
     * Iterable<N> interfacesini implement etmislerdir.O sebeple map filter gibi fonksiyonları kullanabilirler.
     */

    val numbersList: IntRange = 10..<90

    println("NumbersList First:${numbersList.first}")
    println("NumbersList Last:${numbersList.last}") // step'ine gore last'i degisebilir.
    println("NumbersList Step:${numbersList.step}")
    println("NumbersList Count:${numbersList.count()}")

    when (10) {
        in numbersList -> {
            println("10 sayisi numbersList icerisinde yer alir.")
        }
    }

    println("NumbersList Random:${numbersList.random()}")


    val countBiggerThan50 = numbersList.count { it > 50 }
    println("Count Bigger Than 50:$countBiggerThan50")

    println("NumbersList Sum: ${numbersList.sum()}")
    println("NumbersList Average: ${numbersList.average()}")

    val reversedNumbersList = numbersList.reversed()
    reversedNumbersList.forEach { print("$it ") }

}