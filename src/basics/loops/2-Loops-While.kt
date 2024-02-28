package basics.loops

/**
 * Degisen hicbirsey yoktur.Diger dillerde while nasıl kullanılıyorsa kotlinde de aynı sekilde kullanırız.
 * Eger bir donguye ihtiyacimiz var ise ve bu dongu sırasında if-else ile bir sartli duruma ihtiyacimiz varsa
 * bu durumda for + if else kullanmak yerine while kullanabiliriz.
 */

fun main() {
    var number = 0
    var number2 = 0

    while (number < 5) {
        print("${number++} ")
    }

    println()

    while (number2 < 5) {
        print("$number2 ")
        number2++
    }

    println()
    println("-----------------")

    for (value in 0..110) { // Bu kodla yukardaki kod aynidir.
        if (value < 5) {
            print("$value ")
        } else {
            break
        }
    }

}