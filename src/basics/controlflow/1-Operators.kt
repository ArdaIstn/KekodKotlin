package basics.controlflow

fun main() {
    var numberOne = 10
    val numberTwo = 5

    println("Number One: $numberOne") //10
    println("Number One: ${numberOne++}") // 10
    println("Number One: $numberOne") // 11
    println("Number One:${++numberOne}")// 12

    // +,-,/,*,% operatorlerinin fonksiyon halleri de bulunur.

    print("${numberOne + numberTwo}")
    print(" ")
    print(numberOne.plus(numberTwo))

    println()

    print("${numberOne - numberTwo}")
    print(" ")
    print(numberOne.minus(numberTwo))

    println()

    print("${numberOne * numberTwo}")
    print(" ")
    print(numberOne.times(numberTwo))

    println()

    print("${numberOne / numberTwo}")
    print(" ")
    print(numberOne.div(numberTwo))

    println()

    print("${numberOne % numberTwo}")
    print(" ")
    print(numberOne.rem(numberTwo))
    println()

    println("-----------------------------------------------------------------------------------------------------------")

    println("Final notunuzu giriniz.")
    val grade = readln().toInt()

    val charNote = if (grade == 100) {   // <= ve >= de kullanabiliriz,IDE bunu kullanmamizi önerdi.
        "$grade = AA"
    } else if (grade in 80..99) {
        "$grade = BB"
    } else if (grade in 50..79) {
        "$grade = CC"
    } else if (grade in 20..49) {
        "$grade = DD"
    } else if (grade in 0..19) {
        "$grade = FF"
    } else {
        "Bulunamadi"
    }

    println("Char Note:$charNote")

    println("-----------------------------------------------------------------------------------------------------------")

    /**
     * Eger karsilastirma yaptigimiz iki sayidan biri veya ikisi nullable olursa,operatorleri kullanamayiz.
     * Bu durumda operatorlerin fonksiyon hallerini kullanmamiz gerekir.
     */

    println(grade.compareTo(100) == -1) // 65.compareTo(100) -> -1 ,100.compareTo(65) -> 1 ,100.compareTo(100) -> 0 bu sekilde sonuclar aliriz.
    println(grade.compareTo(100) == 1)
    println(grade.compareTo(100) == 0)
    println(grade.equals(100))
    println(!grade.equals(100))

    println(charNote)

    println("-----------------------------------------------------------------------------------------------------------")

    var a = 20
    val b = 5

    a += b
    println("a+=b:$a")

    a -= b
    println("a-=b:$a")

    a *= b
    println("a*=b:$a")

    a /= b
    println("a/=b:$a")

    a %= b
    println("a%=b:$a")

    /**
     * Atama işlemlerini stringin içerisinde yapamayız.
     */

    println("-----------------------------------------------------------------------------------------------------------")

    var numbOne = 10
    var numbTwo = 5
    var flag = true

    println("+a:${+numbOne}") // 10
    println("-b:${-numbTwo}") // -5
    println("++a:${++numbOne}") // 11
    println("a++:${numbOne++}") // 11
    println("a:${numbOne}")  //12
    println("--b:${--numbTwo}") //4
    println("!flag:${!flag}") // false


    println(numbTwo.unaryMinus()) //-4

    println(numbTwo + numbOne.unaryMinus()) // numbTwo = 4  numbOne = 12   4-12=-8


    /**
     * == ifadesi degeri karsilastirir.
     * === ifadesi isaret edilen referans tiplerini karsilastirir.
     */

}