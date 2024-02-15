package basics

fun main() {
    /**
     * Implicit Type Conversion:Ortulu -> Belirgin olmayan sekilde tip donusumu
     * Explicit Type Conversion:Acik -> Belirgin tip donusumu
     */

    /**
     * Kotlinde implicit type conversion yoktur.
     */

    /**
     * Tip donusumu icin kullanabilecegim fonksiyonlar
     * toByte(),toShort(),toInt(),toDouble(),toFloat(),toChar(),toString(),
     * toUByte(),toUShort(),toUInt(),toDuration(),toBigDecimal(),toBigInteger()
     */

    /**
     * Deger araliklarini iyice incelemeliyiz.
     * Deger araligi kucuk olan tipler buyuk olan tiplere,sorunsuz,acik olarak(explicit) donusuturlebilirler.
     */

    val schoolNumber = 126.toByte()
    val convertedValue: Short = schoolNumber.toShort()

    println("School Number:$schoolNumber")
    println("Converted Value:$convertedValue")

    /* ------------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Deger araligi buyuk olan tipler,kucuk olan tiplere acik olarak(explicit) donusturulurken dikkatli olunmalidir.
     * Ust tipten bir degiskenin degeri,alt tipin deger araligindan pozitif yonda fazla buyuk,
     * negatif yonde fazla kucuk ise tip donusumu sirasinda yanlis deger atamalari yapilacaktir.
     */

    val tcIdentityNumber = 12345678912
    val convertedInt = tcIdentityNumber.toInt()
    println("Converted Int: $convertedInt")

    /* ------------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Kapalı(implicit) tip donusumu olmasa bile,iki member arasinda matematiksel islem yapilirsa,sonuc degeri cikan degerin tipinde olacaktir.
     */

    val totalValue: Long = tcIdentityNumber + schoolNumber //Long : Long + Byte

    /*   val longNumber = 1_000_000_000_000L
       val dividedNumber = 1_000_000_000_00L
       val resultNumber = longNumber / dividedNumber*/

    //Burdaki islemlerin sonucunda degisken tipinin ne olacagini,iki degiskenden tipi buyuk olan hangisiyse o belirler,islemin sonucu belirlemez.


    val IntNumber1 = 2_100_000_000
    val IntNumber2 = 2_100_000_000

    val resultNumber2 = IntNumber1 * IntNumber2
    println(resultNumber2)

    // Yukaridaki ornege baktigimizde 2 adet Int sayisini carpma islemine soktugumuzda sonucun Long olmasini bekleriz.
    //Fakat Ide boyle calismaz.2 adet Int sayiyi carptigimizde,IDE sonucun Int olmasini bekler ve tipini Int'e set eder.
    //Ama sonuç Int deger araligini asdigi  icin print ettigimizde anlamsiz bir sonuc goruruz.
    // Bunun icin islemlerimizde dikkatli olmaliyiz.ToLong() diyerek sayimizi longa cevirebiliriz.


    /* ------------------------------------------------------------------------------------------------------------------------------------------------*/




}
