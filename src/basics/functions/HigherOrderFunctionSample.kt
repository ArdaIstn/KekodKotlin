package basics.functions

fun main() {
    calculateAndPrintNormal(3, 5, '+')
    calculateAndPrintNormal(3, 5, '*')
    calculateAndPrintNormal(32, 2, '/')
    calculateAndPrintNormal(10, 5, '-')
    calculateAndPrintNormal(20, 3, '%')

    println("*****************************************************")

    calculateAndPrintHigher(3, 4) { myNum1: Int, myNum2: Int -> myNum1 + myNum2 }
    calculateAndPrintHigher(10, 4) { myNum1: Int, myNum2: Int -> myNum1 - myNum2 }
    calculateAndPrintHigher(10, 4) { myNum1: Int, myNum2: Int -> myNum1 * myNum2 }
    calculateAndPrintHigher(20, 4) { myNum1: Int, myNum2: Int -> myNum1 / myNum2 }
    calculateAndPrintHigher(20, 3) { myNum1: Int, myNum2: Int -> myNum1 % myNum2 }

    println("*****************************************************")

    println("1. sayiyi giriniz.")
    val inputNumber1 = readln().toInt()

    println("2. sayiyi giriniz.")
    val inputNumber2 = readln().toInt()

    println("İslem turunu giriniz.")
    val operator = readln()

    /**
     * Higher order functionsların parametresinde bulunan normal fonksiyonları tanımlarken 3 adet yol vardır.
     */

    println("*****************************************************")

    //1.yöntem
    val sumFunction =
        { inputNumber1: Int, inputNumber2: Int -> inputNumber1 + inputNumber2 } // Bir fonksiyondur,invoke edilebilir.

    //2.Yöntem

    val minusFunction = fun(inputNumber1: Int, inputNumber2: Int): Int { // Bir fonksiyondur,invoke edilebilir.
        return inputNumber1 - inputNumber2
    }

    //3.Yöntem

    // Burda :: kullanimini unutmamamiz gerekir.
    // Ayrica biz burda fonksiyonu cagirmiyoruz,fonksiyonun bodysini vermis oluyoruz.
    // Parametreleri calculateAndPrintHigher2 icerisinde operation fonksiyonunu call ederken vermiş oluyoruz.
    // Okunaklik olarak en guzeli budur.
    // Test yazimi ise daha kolaydir,farklı classlarda da kullanabilmemizi saglar.


    when (operator) {
        "+" -> calculateAndPrintHigher2(inputNumber1, inputNumber2, sumFunction)

        "-" -> calculateAndPrintHigher2(inputNumber1, inputNumber2, minusFunction)

        "*" -> calculateAndPrintHigher2(inputNumber1, inputNumber2, ::multiplyFunction)

        "/" -> calculateAndPrintHigher2(
            inputNumber1, inputNumber2
        ) { inputNumber1: Int, inputNumber2: Int -> inputNumber1 / inputNumber2 }


        "%" -> calculateAndPrintHigher2(
            inputNumber1, inputNumber2
        ) { inputNumber1: Int, inputNumber2: Int -> inputNumber1 % inputNumber2 }

    }

    calculateAndPrintHigher3()
    calculateAndPrintHigher3(3, 10)

    println("****************************")

    calculateAndPrintHigher4()
    calculateAndPrintHigher4(3, 10)


}

fun multiplyFunction(inputNumber1: Int, inputNumber2: Int): Int {
    return inputNumber1 * inputNumber2
}

fun calculateAndPrintNormal(numberOne: Int, numberTwo: Int, operation: Char) {
    val result = when (operation) {
        '+' -> numberOne + numberTwo
        '*' -> numberOne * numberTwo
        '-' -> numberOne - numberTwo
        '/' -> numberOne / numberTwo
        '%' -> numberOne % numberTwo
        else -> {
            numberOne + numberTwo
        }
    }

    println(result)
}


/**
 * Bir fonksiyon,parametre olarak başka bir fonksiyonun bodys'ni aliyorsa(yani baska bir fonksiyonu parametre olarak aliyorsa) bu fonksiyona Higher Order Function denir.
 * Ya da bir fonksiyonun geri donus tipi de bir fonksiyon ise bu durumda bu fonksiyonumuz Higher Order Function olur.
 * Normalde bir fonksiyonu  cagirirken nasıl fonksiyonun body'sine gidiyorsak,
 * Higher order fun içerisindeki fonksiyon da cagirilinca body'sinin oldugu yere gider ve orayi calistirir.
 *
 */
fun calculateAndPrintHigher(numberOne: Int, numberTwo: Int, operation: (number1: Int, number2: Int) -> Int) {
    //Higher order fonksiyonuna parametre olarak verilen fonksiyondaki number1 ve number2 parametrelerini hic kullanmayiz.
    // Bu sebeple parametre isimlerini belirtmemize gerek yoktur.
    // Sadece parametre tiplerini belirtmemiz yeterlidir.
    // Genellikle gercek  projelerde fonksiyon parametreleri isim almadan sadece tip belirtilerek kullanilir.

    val result = operation(numberOne, numberTwo)
    //val result2 = operation.invoke(numberOne, numberTwo) Yukaridaki kullanimla aynidir.Nullable olma durumlarında kullanılır.
    println("Result:$result")

}

fun calculateAndPrintHigher2(numberOne: Int, numberTwo: Int, operation: (number1: Int, number2: Int) -> Int) {
    val result = operation(numberOne, numberTwo)
    println("Result:$result")

}

fun calculateAndPrintHigher3(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: (number1: Int, number2: Int) -> Int = { num1: Int, num2: Int -> num1 + num2 } // Fonksiyona default bir deger vermis oluruz.
) {
    //Burda operation fonksiyonu call ediliyor,eger calculate fonksiyonu call edilirken bir fonksiyon verilmediyse burda default olarak tanimlanan yere gider.
    val result = operation(numberOne, numberTwo) // Eger cagirirken fonksiyon vermezsem,buradaki fonksiyonu calistirir.
    println("Result:$result")

    //Eger ben bu higher order fonksiyonunu cagirdigimda surekli bir fonksiyon parametre vermek istemiyorsak,default bir deger vermek istiyorsam bu sekilde kullanabilirim.

}

fun calculateAndPrintHigher4(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: (number1: Int, number2: Int) -> Int = ::defaultSum // İstersek :: kullanarak da verebiliriz.Fonksiyona default bir deger vermis oluruz.
) {
    val result = operation(numberOne, numberTwo) // Eger cagirirken fonksiyon vermezsem,buradaki fonksiyonu calistirir.
    //Burda operation fonksiyonu call ediliyor,eger calculate fonksiyonu call edilirken bir fonksiyon verilmediyse burda default olarak tanimlanan yere gider.
    println("Result:$result")
    //Eger ben bu higher order fonksiyonunu cagirdigimda surekli bir fonksiyon parametre vermek istemiyorsak,default bir deger vermek istiyorsam bu sekilde kullanabilirim.

}

fun defaultSum(number1: Int, number2: Int): Int {
    return number1 + number2
}