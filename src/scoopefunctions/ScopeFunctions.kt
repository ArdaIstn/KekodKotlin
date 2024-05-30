package scoopefunctions

/**
 * Scoope fonksiyonlar kodlarımızı daha düzgün,derli toplu ve gruplanabilir bir şekilde yazmamızı sağlar.
 * Teknik olarak tüm bu fonksiyonlar birbirleri yerine kullanılabilirler.
 * Ama bu fonksiyonları doğru kullanmadığımızda,kodumuzu çok daha okunmasını zor bir noktaya doğru çekebiliriz.
 * 5 adet scoope fonksiyon vardır.
 * Bunlar(Let,Run(2 kullanımı vardır),With,Apply,Also)
 * Scoope fun kullanmanın avantajları:
 * 1)Null checkleri daha kolay yönetebilmemizi sağlar.
 * 2)Değişkenin isminde değişikliğe gittiğimiz zaman tek bir yerde değiştirmemizi sağlar.
 * 3)Kodumuzdaki mantık bloklarını ayrımamızı sağlar.
 * 4)Değişken özelinde kullandığımızda o değişkenle ilgili bir gruplama yapıp,bütün işlemleri o scoope içerisinde yapmamızı sağlar.
 *
 */

/**
 * Kullanırken 2 adet soru sormamız gerekir.
 * 1)Önüne eklediğim veya parametre olarak kullandığım(with) bu fonksiyonun body'si içerisinde yaptığım işlemler extend ettiğim veya parametre olarak kullandığım
 * değişkenin sonucunu veya içeriğini değiştirecekmi yani onun üzerine bir manipülasyon olacaksa bu durumda Apply veya Also kullanmamız gerekir.
 * Çünkü manipüle edilmiş halini geri döndürmem gerekir,bu durumda fonksiyonun geri dönüş tipinin T'nin kendisi olması gerekiyor.
 *
 * 2)Bu nesne nullable bir  nesne mi yoksa not nullable bir nesne mi ?
 * Eğer not nullable bir nesneyse with,nullable bir değişkense ve null gelme ihtimali varsa let veya run kullanmalıyız.Çünkü with kullanımında içeride null check yapmazsak,
 * null pointer exception hatası alırız.Ekstradan içeride null check yapmak durumunda kalırız.
 */

// Lambda Result:R,Context Object:T


fun main() {

    val name: String? = "Arda"


    // T=Önüne gelen değişken
    // R = son satır,yani geri dönüş değeri.
    // Lambda Param = T,this = yok,çünkü extension yok.
    val returnValueLet = name?.let { name: String ->
        println("Let:$name")
        "ReturnValueLet"
    }
    println(returnValueLet)

    /*******************************************************************************************************************/

    // T = Önüne gelen değişken
    // R = son satır,yani geri dönüş değeri.
    // Lambda Param = Yok,this = T
    // T'yi this diyerek alabiliriz.Çünkü Higher order'ın parametresindeki fonksiyon T'yi extend etmiştir.
    // Higher order'ın içerisindeki fonksiyonun parametresi boştur.

    val returnValueRun = name?.run {
        println("Run:$this")
    }
    println(returnValueRun)

    /*******************************************************************************************************************/


    // T = Yok,extension işlemi yok.
    // R = son satır,yani geri dönüş değeri.
    // Lambda Param = Yok, this = Yok,çünkü extension yok.
    val returnValueRun2 = run {
        println("Run2")
    }
    println(returnValueRun2)


    /*******************************************************************************************************************/


    // T = Fonksiyon'un birinci parametresi(değişken parametresi),extension işlemi yok.
    // R = son satır,yani geri dönüş değeri.
    // Lambda Param = Yok, this = T,çünkü extension fonksiyon.T'yi this diyerek alabilirim.

    val returnValueWith = with(name) {
        println("with:$this")
    }
    println(returnValueWith)


    /*******************************************************************************************************************/


    // T = Önüne gelen değişken
    // R = Yok,çünkü higher order fun içerisindeki fonksiyon Unit tipini dönüyor,yani geri dönüş değeri yok.Onun yerine T geri döndürülüyor.
    // Yani T olarak ne verirsem onu bana geri döner.
    // Lambda Param = Yok, this = T,çünkü extension fonksiyon.T'yi this diyerek alabilirim.

    val returnValueApply = name?.apply {
        println("apply:$this")
    }
    println(returnValueApply)


    /*******************************************************************************************************************/


    // T = Önüne gelen değişken
    // R = Yok,çünkü higher order fun içerisindeki fonksiyon Unit tipini dönüyor,yani geri dönüş değeri yok.Onun yerine T geri döndürülüyor.
    // Yani T olarak ne verirsem onu bana geri döner.
    // Lambda Param = T, this = Yok,çünkü extension yok.

    val returnValueAlso = name?.also { name ->
        println("also:$name")
    }

    println(returnValueAlso)


}