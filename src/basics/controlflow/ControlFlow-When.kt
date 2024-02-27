package basics.controlflow

/**
 * Switch caselerin yerine gelmiştir.
 * when(karsilastirilacak ifade)
 *       value ->{}
 *       value ->{}
 *       else ->{}
 *      formatiyla kullanilir.
 *      Yine {} arasina tek satir kod yazilacaksa bu durumda {} kullanmayabiliriz.
 *      if'in tersine,eger tek satirsa when kullaniminda {} kullanmamak daha uygun olacaktir.
 *      "tr","az" gibi ayni kodu calistiracak caseler varsa araya virgul koyarak kullanabiliriz.
 *      Bu "veya" kullanımı yapmamızı saglar."tr veya az" gibi
 *      Eger if-else seklinde bir kod yazacaksak,if-else kullanabiliriz.
 *      Eger if-else if seklinde bir kod yazacaksak,when kullanmamiz daha uygun olacaktir.
 */

fun main() {

    // lowercase() stringin tamamını küçük harfe dönüştürür.
    // Böylece büyük-küçük harf duyarlılığını ortadan kaldırır.

    println("Ülke kodunuzu giriniz.")
    val countryCode = readln()

    when (countryCode.lowercase()) {
        "tr", "az" -> println("Türk vatandaşı")
        "ar" -> println("Arap vatandaşı")
        "fr" -> println("France vatandaşı")
        "ru" -> println("Russian vatandaşı")
        "uk" -> println("United Kingdom vatandaşı")
    }

    // Eger bunu if-else if seklinde yazacak olsaydik,her case'de karsilastirilacak ifadeyi yazmam gerekirdi.
    // Fakat when kullanımı,bunu bize bir kere yazmamızı saglar.
    // Bundan dolayi when kullanımı bize biraz daha temiz bir kullanim daglar.

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * when'in yanına karsilastirma ifadesi eklemeden,bunu case'lerin yanına da ekleyebiliriz.
     * Bunun artisi &&,||,and,or,xor gibi ifadeleri de kullanabilmemizi saglar.
     * Bu if-else if kullanımıyla aynı anlama gelir.
     * Yine bunları yazarken alakasız bir degiskeni eklememeliyiz.
     */

    when {
        countryCode.lowercase() == "tr" || countryCode.lowercase() == "az" -> println("Türk vatandaşı")
        countryCode.lowercase() == "ar" -> println("Arap vatandaşı")
        countryCode.lowercase() == "fr" -> println("France vatandaşı")
        countryCode.lowercase() == "ru" -> println("Russian vatandaşı")
        countryCode.lowercase() == "uk" -> println("United Kingdom vatandaşı")
    }

    if (countryCode.lowercase() == "tr" || countryCode.lowercase() == "az") {
        println("Türk vatandaşı")
    } else if (countryCode.lowercase() == "fr") {
        println("France vatandaşı.")
    } else if (countryCode.lowercase() == "ru") {
        println("Russian vatandaşı.")
    } else if (countryCode.lowercase() == "uk") {
        println("United Kingdom vatandaşı.")
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Expression kullanımını if else'lerde oldugu gibi whenlerde de yapabiliriz.
     */

    val countryCodeNumber: Int = when (countryCode.lowercase()) {
        "tr", "az" -> {
            println("Türk vatandaşı")
            50
        }

        "fr" -> {
            println("France vatandaşı")
            60
        }

        "ru" -> {
            println("Russian vatandaşı")
            70
        }

        "Uk" -> {
            println("United Kingdom vatandaşı")
            80
        }

        else -> {
            90
        }
    }
    println("Your country code number :$countryCodeNumber")

    val countryCodeNumber2: Int = when {
        countryCode.lowercase() == "tr" || countryCode.lowercase() == "az" -> {
            println("Türk vatandaşı")
            50
        }

        countryCode.lowercase() == "fr" -> {
            println("France vatandaşı")
            60
        }

        countryCode.lowercase() == "ru" -> {
            println("Russian vatandaşı")
            70
        }

        countryCode.lowercase() == "uk" -> {
            println("United Kingdom vatandaşı")
            80
        }

        else -> {
            90
        }
    }
    println("Your country code number2 :$countryCodeNumber2")

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * Karsilastirilacak sey "deger" yerine "degisken" de olabilir.
     */
    val trCode = "tr"
    val arCode = "ar"
    val ruCode = "ru"
    val frCode = "fr"
    val ukCode = "uk"

    when (countryCode.lowercase()) {
        trCode, "az" -> println("Türk vatandaşı")
        arCode -> println("Arab vatandaşı")
        ruCode -> println("Russian vatandaşı")
        frCode -> println("France vatandaşı")
        ukCode -> println("United Kingdom vatandaşı")
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * is !is ile bir class'in referansi olunup olunmadigi kontrol edilebilir.
     * İster if'in icerisinde ister when'in icerisinde,is keywordu verilen degiskenin hangi classa ait olup olmadigini sorgulatir.
     * Miras alınmanın yapıldıgı kodlamalarda kullanılabilir.
     */

    val phoneNumber = 2323232322

    when (phoneNumber) {
        is Long -> println("Long value")

        !is Long -> println("Not Long value.")
    }

    /*------------------------------------------------------------------------------------------------------------------*/
    println("-------------------------------------------------------------------------------------------------------------")

    /**
     * range'lerin in !in seklinde kontrolu yapılabilir.
     */

    val number = 3
    when (number) {
        in 0..10 -> println("Number is in range 0-10")
        in 11..20 -> println("Number is in range 11..20")
        !in 11..20 -> println("Number is not in range 11..20")

    }

}