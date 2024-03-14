package basics.functions

/**
 * fun keywordu ile fonksiyonlar baslar.
 * fonksiyon ismi verilir.
 * parametre parantezleri acilir ve parantezler girilir.
 * : operatoru ve geri donus degeri yazilir.
 * fonksiyon bodysi acilir ve kapanir.
 * Geri donus degeri verilmeyen fonksiyonlar Unit tipini geri dondurur.
 */


fun main(): Unit {

    /**
     * Fonksiyon cagirilirken ismi ve parametreleri kullanilir.
     * Eger bir geri donusu varsa bir degiskene aktarilir.
     */

    takeSquare(2)
    val squareValue = takeSquare(2)
    println("SquareValue:$squareValue")

    /*---------------------------------------------------------------------------------------------------------------------*/

    /**
     * Bir classin fonksiyonunu cagirirken ise nokta isaretini kullaniriz.
     */

    Math.pow(2.0, 3.0)

    /*---------------------------------------------------------------------------------------------------------------------*/
    /**
     * Default degeri olan parametrelere sahip bir fonksiyon cagrilirken,default degeri olan parametrelere deger atamak
     * sart degildir.Default degeri olan bu parametreler opsiyonel parametrelerdir.
     * Default degeri olan parametrelere deger atanmadan fonksiyon cagirilacaksa,bu durumda parametre sirasi degisir.
     * Ide'ye hangi parametreye deger atadigimizi soylemek icin Named Arguments'leri kullanmamiz gerekir.
     * name argumentleri verdigimizde siralamanin bir onemi yoktur.
     */

    reformatMessage("Message", true, 7, "tr")
    reformatMessage("Message", size = 7, lang = "tr")
    reformatMessage("Message", true, 7)
    reformatMessage("Message", size = 7)

    /*---------------------------------------------------------------------------------------------------------------------*/

    // Bu vararg orneginde,key = 3'den onceki parametreler vararg parametresine denk gelir.
    // Key'i name argument olarak soylemem gerekir.
    // IDE'ye vararg'in artik bittigini soylemem gerekir

    getUserInfo1("Arda", "Işıtan", "Türkiye", "İstanbul", "", "", "", key = 3)

    // vararg parametresi olarak arrayOf kullanılmak istenirse,* operatoru eklenmelidir.(spread operatoru)
    // Bu operator diger dillerde olan pointer kullanımı degildir.Kotlinde pointerlar yoktur.

    getUserInfo1(*arrayOf("Arda", "Işıtan", "İstanbul", "Türkiye"), key = 3)

    getUserInfo2(*arrayOf("Arda", "Işıtan", "İstanbul", "Türkiye"))

    getUserInfo3(key = 3, "Arda", "Işıtan", "İstanbul", "Türkiye")

    getUserInfo4(3, "Arda", "Işıtan", true, 3.14, "")
}

/*---------------------------------------------------------------------------------------------------------------------*/

/**
 * parametre  olan number,degisken tanimlanir gibi tanimlanir.
 * Fonksiyon parametresi tanimlanirken,val veya var kullanilmaz.
 *
 */
fun takeSquare(number: Int): Int {
    return number * number
}

/*---------------------------------------------------------------------------------------------------------------------*/

/**
 * = ile fonksiyonlara default degerler verilebilir.(Default Argument)
 * Default degeri atamasi yapmak,function overload islemi yapmamizi saglar.
 * Tekrar tekrar ayni fonksiyonun farkli varyasyonlarini yazmak zorunda kalmayiz.
 * Özetle biz kotlinde bir adet default deger alan fonksiyon olusturuyorsak,arka planda 2 adet fonksiyon olusur.
 * Biri bu fonksiyonun bos hali,digeri ise parametre alan halidir.
 * Aynı fonksiyon ismini kullanarak,parametre sayılarını degistirerek ya da parametre tiplerini degistirerek birden fazla kez
 * kullanilmasina function overload denir.(İs görüsmelerinde cikabilir)
 *
 */

fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {
    println("Message:$message, isUpperCase:$isUpperCase Size:$size, Lang:$lang")
}

/*---------------------------------------------------------------------------------------------------------------------*/

/**
 * Cok uzun sayida parametremiz olacaksa "variable number of arguments"- vararg tanimlanabilir.
 * Vararg parametre sayisi belli olmayan durumlarda kullanilir.
 * Parametre sayisi cok fazla oluyor diye kullanmamiz gereken bir durum degildir.
 * Bu sayede fonksiyon tek bir parametre aliyor gibi gozukurken,kendisine cok miktarda degisken alabilir.
 * Bu degiskenlere array'e erisir gibi erisebiliriz. " [index]" ya da .get(index) seklinde.
 */

/**
 * vararg tek ya da son parametre olarak yazilirsa,Jvm'e hazirlanirken,javadaki "String.. " gibi ayni kod derlenir.
 * Ancak vararg parametresi birden fazla tanimlanirken,ortada ya da basta yer alirsa,Jvm'e hazirlanirken Array'e donusturulur.
 * Bu kullanımda hangi tipte bir vararg kullanıyorsak arka planda o tipte array'e donusturulur..
 * Bu da performans farki olusturur demektir.
 * Bu performans farki  dert edilmeyecek bir farktir.
 * Ama mülakatta show yapmak istiyorsak,
 * Akademik levelda ,String.. 'lı kullanım Array'li kullanıma gore ufak da olsa daha performansli olacaktir diyebiliriz :)
 */

fun getUserInfo1(vararg userInfo: String, key: Int) {
    userInfo[3]
    userInfo.get(3)

    val array = IntArray(3)
}

fun getUserInfo2(vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo3(key: Int, vararg userInfo: String) {
    userInfo[3]
    userInfo.get(3)
    println(key)
}

fun getUserInfo4(vararg userInfo: Any) {
    userInfo[3]
    userInfo.get(3)

}

/**
 * Ayni fonksiyon icerisinde,birden fazla vararg tanimi yapilmasina izin verilmez.
 * Asagidaki kod calismayacaktir.
 */

//fun getUserInfo5(vararg userInfo : String,vararg userInfo2:String){
//
//}


/**
 * @JvmOverloads annotation'i default degeri olan parametrelere sahip bir fonksiyon varsa bu fonksiyonu java tarafından cagirilabilmesi icin elimizle bu fonksiyonu
 * coklamamiza gerek kalmadan arka planda kendisi assembly koduna cevirirken bu fonksiyonu coklar.Eger calisilan projede hem java hem kotlin kodlari var ise kullanılır.
 * Javada default arguments ve name arguments yoktur.Olmayan bir ozelligi cagirmamizi saglar.O fonksiyonun javadan cagirilabilir olmasi icin birden fazla
 * oldugu seklinde yani overload edilmis seklini otomatik olarak yazacaktir.Uretecegi assembly kodu javadaki kodun benzeri olacagi icin java tarafindan cagirilabilir olacaktir.
 */

@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}


/**
 * Bir class extend edilebilir olup, yavru(child) sinif tarafindan miras(inherit) alinirsa ve bu sinifin override edilebilir open bir metodu varsa,bu method
 * default argumente sahip olursa ve bu sinifi miras alan sinifta method override edilirse,override edilen methodun parametresine default argument tanimlanamz.
 * Ust sinifin methodundaki default argument gecerli olur.
 */
open class A {
    open fun foo(i: Int = 10) {

    }
}

class B() : A() {
    /*   override fun foo(i: Int = 5 ) {
       }*/

    //no default value allowed
}


/**
 * Bir fonksiyon = koyularak return edecegi deger yazilabilir.(Single Expression Kullanimi)
 */
val userList = arrayOfNulls<String>(5)

fun getListCount(): Int = userList.size
fun getListCount2() = userList.size // Bu sekilde tipini belirtmesek bile type inference oldugu icin tipi otomatik olarak algılanır.

fun getListCount3(): Int {
    return userList.size
}

