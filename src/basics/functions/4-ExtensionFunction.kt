package basics.functions


/**     Javada extension functionslar yoktur.
 *      Uzerinde degisiklik yapamadigimiz (readOnly:Sadece okuma yapabildigimiz siniflardir) siniflara, ya da yapmak istemedigimiz siniflara, bu siniflarin
 *      icerisine yazmadan fonksiyon tanimlayabilmemizi saglar. Boylece o sinifa uye bir fonksiyon kazandirabiliriz.
 *      Performansa bir artisi veya eksisi yoktur.
 *
 *      Kendi yazdigim bir sinif varsa ve eger o sinif cok buyuyorsa yeni yazacagim bir fonksiyonu,ozelligi o dosyaya yazmak istemem.
 *      Daha yonetilebilir olmasi icin yine o sinifin icerisine yazmak istemedigim ekstra fonksiyonlari,ozellikleri extension fonksiyon olarak yazabilirim.
 *
 *      Bunu yaparken unutmamaniz gereken; yazdiginiz extension fonksiyon aslinda o sinifin gercek bir fonksiyonu olmayacaktir.
 *      Sad but true story. Olsundu. Extension fonksiyonlar kalbinize girecekler. Bir sinifa ait olmalari gerekmez :)
 *
 *      Degistiremedigimiz bir sinifa ekstra ozellik katıyoruz gibi dusunebiliriz..
 *      Extension function'u herhangi bir classin kendi fonksiyonuymus gibi davranmasini istiyorsak kullanmalyız.
 *
 *           KULLANIMI:
 *
 *           Extension Functions, "Receiver" diye adlandiracagimiz bir
 *           classa ihtiyac duyar. "Receiver", Extension Function
 *           yazacagimiz sinifi ifade eder yani basitce extend edilecek
 *           classa "Receiver" denilir.
 *           Extension Functions, IDE tarafindan mavi renklendirilir.
 *
 *
 *      Yapisal olarak;
 *
 *      fun String.extPrint(handsomeValue : HandsomeOne) : Unit { //Sadece onune hangi sinifi buyutmek istiyorsam onu yazip . koyuyorum
 *
 *      }
 * **/

/** ****** ÖNEMLİ ******
 * Ek olarak şunu ekleyebiliriz,
 * Extension fonksiyonlar arka planda yani java tarafında static fun olarak tutulurlar.Java tarafındaki fonkiyonun ilk parametresi extend ettiğimiz class'ın instancesini,yani asıl degiskeni
 * ikinci parametresi ise normal vermek istediğimiz parametreyi içerir.
 * Aslında baktığımızda bu yeni birşey degildir,kotlinde yazımı daha kolay ve daha rahattır.
 * Mülakatta show yapmak icin bu bilgi eklenebilir.
 *
 */

/**
 * Kotlinde herhangi bir fonksiyon extension olup olmasın,top level yazılıyorsa yani bir classın icerisinde degilse bu fonksiyona dısaridaki heryerden erisilebilir.(Statik olur)
 * Java tarafındaki statik keywordunun olmasının sebebi fonksiyonun top level olmasıdır.Extension olarak yazılması degildir.
 *
 */
fun main() {


    val pi: Double = 3.14
    println("DoubleNumber:$pi")

    val schoolNumber: Int = 1341
    println("IntNumber:$schoolNumber")

    val tcIndentityNumber: Long = 123456789123
    println("LongNumber:$tcIndentityNumber")

    println("*********************")
    /*----------------------------------------------------------------------------------------------------------------*/

    // Yukardakilerin yerine normal bir log2 fonksiyonu yazilabilir.
    // Aslinda bu kullanim javadaki util fonksiyonlarının kullanımı gibidir.
    // Kotlinde bu kullanım yerine extension kullanımı yapabiliriz.
    // Teknikte log fonksiyonu ile log2 fonksiyonu ayni anlama gelecektir.
    log2(pi, "DoubleNumber")
    log2(schoolNumber, "IntNumber")
    log2(tcIndentityNumber, "LongNumber")

    println("*********************")
    /*----------------------------------------------------------------------------------------------------------------*/

    //Bu sekilde Number classını extend ederek kullanabiliriz.
    //Aslında temelde ayni anlama gelir,yukaridaki fonksiyonda verdigimiz ilk parametreyi basa alıp o classı extend ederiz.
    // 2. parametreyi ise fonksiyon icerisinde verebiliriz.
    // Aslinda yukaridaki log2 kullanımıyla asagidaki extension kullanımı birebir aynıdır diyebiliriz.
    // Aradaki fark,log2 fonksiyonunda nesneye yonelimli yaklasimi kullaniriz,log fonksiyonunda ise fonksiyonel programlama yaklasimini kullaniriz.
    // Fakat teknik olarak arka planda log ve log2 fonksiyonları  aynıdır.

    pi.log("DoubleNumber")
    schoolNumber.log("IntNumber")
    tcIndentityNumber.log("LongNumber")

    println("*********************")
    /*----------------------------------------------------------------------------------------------------------------*/

    // extension fonksiyonlar  direkt value'lar uzerinden cagrilabilir.
    (3 + 0.14).log("5")
    1341.log("")
    1341.toFloat()
    18608268888.log("")

    (3 + 0.14) log ""

    // isterseniz de degiskenler uzerinden.
    pi.log("")
    schoolNumber.log("")

    println("*********************")
    /*----------------------------------------------------------------------------------------------------------------*/


}

fun log2(param: Number, message: String) {
    println("$message:$param")
}

/*----------------------------------------------------------------------------------------------------------------*/

/**
 * Number(receiver) sinifina extension olarak yazilmis bir log fonksiyonudur.
 * Ayni zamanda infix yapilmistir.
 * this ifadesi,extension yapilan degeri verir.
 * 3 log "4" yaparsak,
 * Asagidaki kod bize emptyParam = "4",this = 3 olarak verilir.
 *
 */

infix fun Number.log(emptyParam: String) {
    println("$emptyParam:$this")
}

/*----------------------------------------------------------------------------------------------------------------*/

/**
 * Infix extension fonksiyon,expression formda kullanilabilir
 */
infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()

/*----------------------------------------------------------------------------------------------------------------*/

open class Shape {

    var intNumber = 0

    fun setNumber(intNumber: Int) {
        this.intNumber = intNumber
    }

    fun main() {
        intNumber.extToString()
        intNumber.log("")
        this.extToString()
    }


    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Bir sinifin icinde, farkli bir sinifa ait extension fonksiyon yazilirsa, bu sinifin icinde ayni isimde normal
     *      bir fonksiyon olsa bile, extension fonksiyonun icerisinde, ayni isme sahip fonksiyon cagrilirsa, bu extension
     *      fonksiyona isaret eder demektir. Sinifin ayni isimdeki uye fonksiyonunu extension fonksiyon icersinde cagirmak icin
     *      this@sinifismi.uyefonksiyon() seklinde cagirim yapilmalidir.
     * **/
    open fun Int.extToString() {
        println("")

        // Int.extToString() methodunu isaret eder.
        /*
        extToString()
        this.extToString()

         */
        this.extToString()

        // Shape'e ait asagidaki uye methodu isaret eder.
        this@Shape.extToString()

        println("Awesome class printi")
    }


    fun extToString() {
        println("Keko class printi")
    }
    //Gercek hayat projelerinde extend ettigim fonksiyonun ismi ile classin icindeki fonksiyonun ismi ayni olmaz ama
    // good to know olarak bak :)
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir sinifin icine  yazilmis extension fonksiyonun aynisini (isim ayni, parametre sayisi ve tipleri ayni, ayrica geri donus tipi de ayni olmali),
 *      kendi icinde barindiriyorsa, bu durumda yazilan extension fonksiyon gecersizdir. Sinifin uye fonksiyonu cagirilir.
 *      Bu yok hükmündedir.
 * **/
fun Shape.setNumber(intNumber: Int) {
    this.intNumber = intNumber
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir sinifa extension fonksiyon yazilabildigi gibi extension property de yazilabilir.
 *      Bir degisken de extend edilebilir ama sarti get ve seti mutlaka yazmamiz lazim.
 *      COK ONEMLI bir konudur.Is gorusmeleri icin de onemlidir.
 *      Bunun sebebi aslinda property'lerin get() ve set() methodlarindan olusmasindan dolayidir.
 *      Bu extension property'lerin icerisinde field tanimlanamaz.
 *      Dolayisiyla aslinda gercek anlamda bir degisken extension yapilamaz.
 *      = ile deger atamasi yapamiyoruz.
 *      Arka planda getType ve setType fonksiyonlarini goruruz fakat  deger atamasi yapamayiz.
 *      Bu fonksiyonlar oldugu icin extend olabiliyor.
 *      Ayrıca arka planda backing fieldi yoktur.
 *      Bu konu property vs field konusu ile beraber sinif'lar islenirken detayli anlatilacaktir.
 * **/

var Shape.type: String
    get() = type // Bu fonksiyon,bana ne doner bunu verir.
    set(value) { // Disardan deger atamasi yapmayi saglar.
        type = value
        // field=value yapamayiz.Cunku backing fieldi arka planda yoktur.
    }

/*fun Shape.getType: String(){
    return type
}*/

/*fun Shape.setType(value: String) {
    type = value
}*/

// Property'i extension yaparken basitce yaptigimiz sey aslinda budur. O yuzden bir propertyi de extend edebiliriz.


/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Open (Extend edilebilir) bir sinifa, sinifin icinde bir open (override edilebilir) extension fonksiyon yazilirsa,
 *      bu sinifi miras (inherit) alan siniflar, ilgili extension fonksiyonu override edebilirler.
 * **/
class Rectangle : Shape() {
    override fun Int.extToString() {
    }

}


/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      NOTES :
 *      Nullable extension function da yazilabilir.
 *      Companion object'lere de extension yazilabilir. Siniflar'da ornegini yapacagiz.
 * **/

