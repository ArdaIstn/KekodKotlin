package basics.functions


import java.util.*
import kotlin.concurrent.schedule

//fun `6 Classes`.main(args: Array<String>) {
//    printName("Gökhan")
//
//    printTotalName("${printName("Gökhan")}")
//    printTotalName("String")
//    printTotalName({
//        return  "Ad : $name"
//    })
//}
//
//
//fun printName(name: String): String{
//    return  "Ad : $name"
//}
//
//fun printTotalName(totalName: String){
//    println(totalName)
/*


 */


fun main() {

    val name = "Arda"
    val surName = "Işıtan"
    val fullName = name + surName
    // Degiskeni bir degiskene parametre olarak verdim.Degiskenler de bir first class citizendir.


    fun deneme(fullname: String): String {
        return fullname
    }


    fun deneme2(fullname: String): String {
        return fullname
    }
    //Deneme ve Deneme2 fonksiyonlari local fonksiyonlardir.Bir fonksiyonun icerisine yazilmistir.UNUTMA bir fonksiyonun
    // body'sinin calisabilmesi icin cagirilmasi gerekir.

    val welcomeMessage = deneme(fullName)
    // Degiskenlere deger olarak atanabilir.

    deneme(deneme2(fullName))
    //  Bu sekilde verilebilir fakat asagida bahsedilen kisim bu kisim degildir.Bunlar cepte dursun.
    //    Burada bir fonksiyonu parametre olarak vermedim,fonksiyonun geri dondurdugu degeri parametre olarak verdim.Higher order
    //    functions'larda ise direk fonksiyon body'sini parametre olarak verebiliriz,guzelligi de burdadir.


    /**
     *  Onemli bilgilerden biri ise yazilim hayatinda bir seyi anlamadiginda suslu parantezlerin icine ilk satıra  debug key koyarak
    daha net anlayabilirsin.En temiz anlama yollarindan biridir UNUTMA!.

     *      Fonksiyon'lar Kotlin'de "First Class Citizen"dır. Yani degiskenlere deger olarak atanabilir, baska fonksiyonlara
     *      parametre olarak verilebilir ya da bir fonksiyonun geri donus degeri olabilir demektir.
     *
     *      Higher Order Function'lar basitce bir fonksiyonu parametre olarak alan fonksiyonlardır. Parametre olarak
     *      almasindan kasit, fonksiyonun cagriminin parametre kisminda yapilmasi degil, fonksiyonun govdesinin (body)
     *      yani suslu parantezler arasinda kalan gorev alaninin baska bir fonksiyona parametre olarak verilmesidir.
     *
     *      Higher Order Functionlar daha da basitce fonksiyon body'sidir.
     *
     *      Yapisal olarak;
     *
     *      fun foo(normalFunction: (message: String) -> Unit){ foo bir higher order fonksiyondur.Çünkü bir fonksiyonu parametre olarak almistir.
     *          normalFunction("Codemy")
     *          }
     *          Parametreden gelen fonksiyonu biryerde cagirmam lazim
     *          Cagirirken codemy vermemin sebebi benden message:String istemesidir.
     *
     *          Fonksiyon ismi,iki nokta,sonrasinda parametreleri olmasi lazim.
     *          Sonrasinda ise fonksiyonun geri donus tipini vermem lazim.
     *
     *      fun boo(boo: String){
     *      }
     *
     *      Cagrilirken;
     *
     *      fun main(){
     *      boo("Merhaba")
     *
     *          foo({ message -> Suslu parantezlerden sonraki  kisim  fonksiyonun parametresi olacaktir.
     *              println("Message : $message")   (Cagirirken fonksiyonun parantezleri arasina bodysini veriyoruz.)
     *          } )
     *      }
     */

    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Higher Order Function'larda parametre olarak bekledigimiz fonksiyonlari cagirirken,tanimlamanin 3 yolu vardir.
     */

    // Bir degiskene atayarak fonksiyon tanimlayabilirsiniz,bir fonksiyon bodysini bir degiskene atayabilirsiniz.
    // Bu degisken gibi gozukse de aslinda bir fonksiyodur.
    // Bu durumda suslu parantezlerin yanina fonksiyonun aldigi parametreler lambda okundan once aralarina virgul
    // koyularak yazilir.Eğer fonksiyon tek parametre aliyorsa, bu parametreleri yazmak zorunda degilsiniz.
    // Bu durumda fonksiyon size "it" kelimesi ile fonksiyonun parametresi tipinde bir degisken verecektir.


    val higherOrderFunction = { surName: String ->//(Lambda Oku)
        "surName : $surName" // Return edilen yer.Fonksiyon (string,string) oldu.Son satir beklenen geri donus tipinde olmalidir
        // String bir ifade bekledigimiz icin,string bir ifade yazmamiz lazim.
    }


    //  Ismi olmayan "anonymous function" tanimlamalari da Higher Order Function olarak, normal bir fonksiyona parametre
    //  olarak verilebilir.Fakat bir degiskenin esitligi olarak yazman gerek.Higher order'in geri dondurdugu deger string turunde
    //  ama degiskenin turune string veremem.Cunku Degisken string degil artik bir fonksiyondur.Degisken gibi dursada bu bir fonksiyondur.
    //  Bir fonksiyonun bodysini bir degiskene veriyorum.Geri dondurdugu degeri vermiyorum.

    val anonymousFunction = fun(surName: String): String {
        return "surName : $surName"
    }


    // Anonymous Function'in expression kullanimini da yine Higher Order Function olarak normal bir fonksiyona parametre
    // olarak verilebilir.
    val anonymousFunction2 = fun(surName: String): String = "surName : $surName"


    // En dogru ve en basit syntaxidir.

    fun logPrint(messagee: String): String { //Duz bir fonksiyon da higher order fonksiyon olabilir.Normal bir fonksiyona parametre olarak yazilmistir.
        return "log:$messagee"//Asil isi yapan kod burasidir.
    }
    // Tahterevalli gibi düşün.Biz biryerden etkide bulunuyoruz fakat başka bir yerde bir sonuç meydana geliyor.Buradaki örnekte de
    // aslinda foo fonksiyonunu çağırdık fakat günün sonunda logPrint fonksiyonu calisti.Çünkü parametre olarak gelen higher order logPrint fonksiyonuydu.
    //RecycleViewlarda örnegini göreceksin.Bir nevi tünel görevi görür gibi düşünebiliriz.
    //Higher orderda ne zaman ki biz o fonksiyonun icerisinde fonksiyonu cagiririz o zaman  verdigimiz fonksiyonun bodysi çalışır.


    fun foo(normalFunction: (message: String) -> String) {
        normalFunction("Codemy")

        // logPrint("Codemy")//Aslinda bunu cagirmis gibi dusunebiliriz.
    }


    //Fonksiyonun body'si icinde baska bir fonksiyon body'sini cagirmis oluyoruz.
    // Kullanabilmek icin higher order fonksiyonun parametresindeki normal fonksiyonun,diğer fonksiyonla aynı parametre tipine,aynı parametre sayisina ve ayni geri donus
    // tipine sahip olmasi gerekir.Parametre siralamalarinin da ayni olmasi gerekir.
    //Basitce ıdeye ben burda bir higher order fonksiyon bekliyorum ve bekledigim fonksiyonun aynisini parametre olarak verebilirim.
    foo(::logPrint)
    // En temiz sytnaxi budur.Kullanirsan isine yarar.Bu sekilde yazmak onemlidir.Profosyonel hayatta da kullanilir.
    // foo(::logPrint("Good") Boyle kullanilmaz.
    // foo(logPrint("Good")) Boyle kullanilmaz.


    // Higher Order Function'ın icindeki normal fonksiyonla ayni parametre sayisina sahip ve bu parametrelerin hepsinin tipleri diğer fonksiyonun
    // parametre tipleri ile ayni ve geri donus tipi de ayni ise,bu normal fonksiyon da Higher Order Function'un parametresinde bulunan  normal bir fonksiyona parametre
    // olarak verilebilir. Bunu yapmak icin sadece basina :: isareti koymak yeterlidir.


    val news = News()

    news.read(::println)

    news.read {
        println("asdsgf")
    }


    news.read {
        println(it)
    }


    val titleFun = fun(title: String): Unit { // Isimsiz(Anonymous) bir fonksiyon,
       println(title)
    }
    news.read(titleFun) //Read fonksiyonu string tipinde ve  geri donus degeri unit olan bir higher order fonksiyon istiyor.
    //Tiklayip bakabilirsin.

    //**********************************************************************************************************************

    printUserInfo(getName(), higherOrderFunction, getAge())

    printUserInfo(getName(), anonymousFunction, getAge())

    printUserInfo(getName(), fun(surName: String): String {
        return "surName : $surName"
    }, getAge()) // Çirkin bir kullanım,yukarıdaki kullanım daha mantıklıdır.

    // Suslu parantezler (body) direkt olarak Higher Order Function'in parametre olarak beklendigi alana da yazilabilir.
    printUserInfo(getName(), {
        "surname : $it"
    }, getAge())

    getItemClickListener { buttonName ->
        println("$buttonName tıklandı..")
    }


    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *       Eger bir fonksiyon parametreleri icerisinde bir  Function son parametre olarak tanimlandiysa, bu durumda
     *       isteniyorsa, bu  Function, fonksiyon parametrelerinin disina da yazilabilir. Daha temiz bir kullanim
     *      yapmis oluruz.
     */
    val newsType = NewsType()
    news.getNewsFromServer("FoxTv", newsType, {
        println(this.toString())
    }) // Higher Order Function, fonksiyon parametrelerinin icerisinde tanimlanmistir.

    news.getNewsFromServer("FoxTv", newsType) {
        println(this.toString())
    } // Higher Order Function, fonksiyon parametrelerinin disinda tanimlanmistir.

    /* -------------------------------------------------------------------------------------------------------------------*/

    /**
     *      Higher Order Function birde fazla parametre iceriyorsa, aralarina virgul koyarak lambda isareti ile tanimlamak zorunlu.
     *      Tek parametreye sahipse bu durumda parametre ismi ve lambda isareti koyulmayabilir. Bu durumda ilgili parametre "it"
     *      kelimesi ile cagrilabilecektir.
     *      Eger bir higher order fonksiyon, parametre olarak sadece bir fonksiyon aliyorsa bu durumda fonksiyon parantezlerini hic yazmayabilirsiniz.
     */
    news.filterNews { filterType, getFilterName ->
        println("asdsgf")
    }
} // Main bitti.

/* -------------------------------------------------------------------------------------------------------------------*/


// Normal Fonksiyon
fun getName(): String {
    return "Gökhan"
}

// Normal Fonksiyon, expression kullanima ornek
fun getAge(): Int = 29

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      2. parametre Higher Order Fonksiyon olarak tanimlanmistir.
 *      Higher Order Fonksiyonlar default deger alabilirler. Bunun icin basitce suslu parantezler acmak yeterlidir.
 *      Dikkat edilmesi gereken konu bu suslu parantezler icine, Higher Order Function parametre bekliyorsa, bunlar verilmelidir.
 */
fun printUserInfo(name: String, getSurName: (surName: String) -> String = { surName -> "" }, age: Int): Unit {
    println("name: $name ,  age : $age")


    println(getSurName("Işıtan"))//Bir fonksiyon cagirimi yaptigim icin surname burda kullanilmaz.Higher order fonksiyonun parametresidir.
    //Direk value olarak atanir.Bunun ismine o yüzden gerek duymayiz.Ama boyle de kullanabilirsin,nasıl istersen.

}
// "" Kullanmamizin sebebi higher order fonksiyonun geri donus tipinin string olmasidir.

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Higher Order Function icerisindeki fonksiyona parametre tanimlarken sadece degisken tipini tanimlayarak da (degisken adi olmadan) kullanilabilir.
 *      Bunun sebebi ise o degiskeni kullanmamamizdandir.Kotlin bir uyari vermez fakat profosyonel hayatta sadece degisken tipi kullanilir.
 *
 */
fun getItemClickListener(onClick: (String) -> Unit) {

    println("Tiklama islemi baslatiliyor")

    Timer().schedule(3000) {

        // Bir higher order fonksiyonun parametresindeki fonksiyon, parametre olarak yazildiktan sonra,bu parametrenin normal fonksiyon icerisinde
        // cagirilmasi gerekmektedir. Aksi halde bu  fonksiyonu tanimlamak mantiksiz olur. Normal fonksiyonunun
        // cagrildigi alandaki  body kismi hicbir zaman cagrilmaz demek olur.
        onClick("Login")



        println("Tiklama islemi bitti")
    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

class News {
    fun getNewsType(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "Breaking"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }
}

class NewsType {
    companion object {
        val breakingNews = "BreakingNews"
        val urgent = "Urgent"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"
    }
}

/**
 *      Bir Higher Order Function'ina parametre verirken Class ismi.() seklinde tanimlama yapilabilir.
 *      Bu sayede ilgili class da parametre parantezi icerisine yazilabilir.
 *      Gercek hayat projelerinde denk gelebilirsin,sasirma cok bilinen bir bilgi degildir.
 */
fun News.getNewsFromServer(
    channelType: String,
    newsType: NewsType,
    getNews: NewsType.(Int) -> Unit
) { //(NewsType,Int) yaziyormusuz gibi dusun.
    when (channelType) {
        "KanalD" -> {
            getNews(newsType, 1)
        }

        "ShowTv" -> {
            getNews(newsType, 2)
        }

        "Tv8" -> {
            getNews(newsType, 3)
        }

        "FoxTv" -> {
            getNews(newsType, 3)
        }

        "CNN" -> {
            getNews(newsType, 3)
        }
    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir Higher Order Function'sın parametresi de yine Higher Order Function olabilir.
 */


infix fun News.filterNews(getFilter: (filterType: String, getFilterName: () -> String) -> Unit) {


    val getFilterNameHo = {  // 1. tanimlama sekli.
        "String return label"
    }


    val getFilterNameHo2 = fun(): String { //Anonymous fonksiyon kullanimi.2.tanimlama sekli.
        return "String return label"
    }

    val getFilterNameHo22 = fun(): String = "String return label"//Anonymous kullanimin expression seklidir.

    fun getFilterNameHo3(): String { // Normal bir fonksiyon tanimlayip kullanabilirsin.3. tanimlama sekli
        return "String return label"
    }//Bunu local olarak degil de asagida bir yerde yazarim,local icin gerekli bir gizlilik yok.

    fun getFilterNameHo33(): String = "String return label"//Yukaridakinin expression  seklidir.

    getFilter("filterName") {
        "String return label"
    }
    getFilter("filtername", getFilterNameHo)
    getFilter("filtername", getFilterNameHo2)
    getFilter("filtername", getFilterNameHo22)
    getFilter("filtername", ::getFilterNameHo3)
    getFilter("filtername", ::getFilterNameHo33)
}

infix fun News.read(readTitle: (title: String) -> Unit) {
    readTitle("Codemy is Awesome")
} //Higher order fonksiyonu parametre olarak alan bir Extension fonksiyondur,İnfix de yapabiliriz.1 tane higher order
// parametresi vardir.title'in yanina count:Int eklesem de infixligi bozulmaz cunku fonksiyonun kendisi 1 parametredir.
//Higher order fonksiyonun kendisinin alacagi parametre sayisi infixligi bozmaz.Cunku hala tekil bir parametredir.
// Vararg gibi degildir.New'si silsem infixligi bozulur.Cunku infixligin sartlarinda extension fonksiyon olmasi vardir.
//Top level fonksiyonlari infix yapamam.