package basics

/**
 * Ozellikle challenglarda degiskenleri tanimlarken,veri tiplerindeki araliklara uygun degiskenler tanimlamayliz.
 * Bu,bir mobil uygulama icin cok buyuk bir problem degil,
 * fakat daha buyuk veri tipleri ile calisacaksak o durumda memoryde kapladiklari alan bakimindan farkeder.
 *
 */
/* -------------------------------------------------------------------------------------------------------------------------*/

/**
 * Degiskene deger atamasi yapilirken,maksimum performans icin dogru degisken tipini kullanmak onemlidir.
 * Bunun icin degiskenlerin deger araliklarini kontrol edebiliriz.
 * Type Inference sirasinda eger sayi Int ifadeden buyuk degilse,tipi default olarak Int set edilir.
 * Type Inference sirasinda eger sayi Int ifadeden buyık ise,tipi default olarak Long set edilir.
 */


fun main() {
    val minByteValue: Byte = Byte.MIN_VALUE
    val maxByteValue: Byte = Byte.MAX_VALUE
    println(minByteValue)
    println(maxByteValue)
    println("***************")

    val minShortValue: Short = Short.MIN_VALUE
    val maxShortValue: Short = Short.MAX_VALUE
    println(minShortValue)
    println(maxShortValue)
    println("***************")

    val minIntValue: Int = Int.MIN_VALUE
    val maxIntValue: Int = Int.MAX_VALUE
    println(minIntValue)
    println(maxIntValue)
    println("***************")

    val minLongValue: Long = Long.MIN_VALUE
    val maxLongValue: Long = Long.MAX_VALUE
    println(minLongValue)
    println(maxLongValue)
    println("***************")

    val minFloatValue: Float = Float.MIN_VALUE
    val maxFloatValue: Float = Float.MAX_VALUE
    println(minFloatValue)
    println(maxFloatValue)
    println("***************")

    val minDoubleValue: Double = Double.MIN_VALUE
    val maxDoubleValue: Long = Long.MAX_VALUE
    println(minDoubleValue)
    println(maxDoubleValue)
    println("***************")

    /* -------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Long       Degiskenler icin sayinin sonuna 'L' konularak deger atamasi yapilabir.
     * Float      Degiskenler icin 'F' veya 'f' harfi konularak deger atamasi yapilabilir.
     * Double     Degiskenler icin geleneksel gosterim desteklenir.
     * Decimal    tanimi yapilabilir  [0-9]
     * Octal      tanimi yapilamiyor  [0-7]
     * Hexadecimal tanimi yapilabilir.
     * Binary     tanimi yapilabilir. [0-1]
     */

    val longNumber: Long = 1586
    println(longNumber)
    val floatNumber = 19.90F
    println(floatNumber)
    val floatNumber2 = 13f
    println(floatNumber2)
    val doubleNumber = 3.14
    val doubleNumber2 = 3.14e10
    val decimalNumber = 1907
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b01000010


    /* -------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Number degisken tanimi yapilirken  underscor "_" kullanilabilir.
     */

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_345L

    /* -------------------------------------------------------------------------------------------------------------------------*/
    /**
     * Boxed : Degiskenin obje referansi olarak tutulmasidir.
     * UnBoxed : Degiskenin primitive olarak tutulmasidir.
     * === : operatoru degiskenlerin referansini karsilastirilirken kullanilir.
     * == :  operatoru degıskenlerin degerini karsilastirirken kullanilir.
     */

    //Eger biz bir primitive bir degiskeni null yapiyorsak,bu degisken artik primitive tip degil,buyuk class tiplerine donusur.

    // Byte araligi icin asagidaki gibi olur.Özel optimizasyonlar bizim ayni referans alanina isaret ettigimizi gosterir.
    // Yani,farkli degiskenler gibi gozukse de aslinda bunlar ayni degiskenlerdir.
    // Stack'de tutulur.

    val number: Int = 100 // primitive tip
    val boxedNumber: Int? = number // class tipi
    val anotherBoxedNumber: Int? = number
    println(boxedNumber === anotherBoxedNumber) // true


    //Fakat byte disinda bi araliga cikiyorsa,asagidakiler farkli memory alanlarina isaret ediyorlar demektir.
    val number2: Int = 10000
    val boxedNumber2: Int? = number2
    val anotherBoxedNumber2: Int? = number2
    println(boxedNumber2 === anotherBoxedNumber2) // false

    /**
     * Stack ve Heap denen 2 adet memory alanımız vardır.Memory dediğimiz şey temelde bu 2 yapıdan oluşur.
     * Biz bir primitive(unboxed) değişken oluşturduğumuz zaman,hem değişkenin kendisi hem de değeri için stackde yer ayrılır.
     * Bu ikisi toplamda bir Int kadar yer kaplar.Stack alanı,heap alanından daha hızlı çalışır.
     * Primitive tipler,hem değişkenin kendisini hem de içerdiği değeri aynı stack alanında,daha performanslı çalışan alanda tutarlar.

     * Eğer referans tipli bir değişkenle çalışıyorsak,o değişkenin ismi stackde tutulur,değeri heap'de tutulur.
     * Örneğin val age : Int? yapıp herhangi bir değer atarsak,age'in kendisi stackde tutulur içerdiği değer ise heapde tutulur.
     * Eğer bu değişkene null değerini verirsek,heapde kullandığı alan boşalır fakat stackde değişkenin ismi için yer kaplanmaya devam edilir.
     * Dolayısıyla,değişkeni nullamamız,değişken için memory'de herhangi bir alan tutulmuyor anlamına gelmez.
     * Değişkenin kendisi için bir alan tutulur fakat değeri için bir alan tutulmuyor anlamına gelir.
     * Sonrasında bir değer atarsak,heapde değişkenin değeri,stack'de ise değişkenin kendisi tutulmaya devam edilir.
     */

    /**
     * Backend'ten donen Double ve Float degiskenleri kullanırken dikkatli olmamız gerekiyor.
     * Eger backendden donen deger uzerinde "." isaretine gore bir split isi yapacaksak basimiz agriyabilir.
     * Cunku backend'den donen Double ve Float degiskenleri her zaman "." ile ayrismiyor olabilir.
     * Database dilinin farkli olmasına gore (turkce-ingilizce gibi) "." yerine "," ile de ayrisiyor olabilir.
     */

    //bitwise operators
    val bitValue = 0b00100101
    val bitValue2 = 0b10110011

    println(bitValue)
    println(bitValue2)


    val resultAndBit = bitValue.and(bitValue2)
    println("ResulAndBit:$resultAndBit") // 0b00100001 = 33(hex)

    val resultOrBit = bitValue.or(bitValue2)
    println("ResultOrBit:$resultOrBit") // 0b10110111 = 183

}