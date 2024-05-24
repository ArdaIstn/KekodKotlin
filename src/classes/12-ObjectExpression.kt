package classes

/** MÜLAKAT SORUSU GELEBİLİR
 *  Objenin kaç farklı kullanımı vardır ?
 * Expression kullanımı,Declaration-State-Singleton Kullanımı,Companion Kullanımı
 */
/**
 * Bir objeyi expression olarak kullaniyorsak,isimsiz bir class oluşturuyoruz demektir.
 * Tek kullanımlık class olusturmak yerine objeyi expression formda kullanabiliriz.
 * Kullan at class şeklinde düşünebilirsin.
 * Aslinda basitce bir degiskene bir classı esitliyormusuz ve butun class ozellliklerini kullanabiliyormusuz gibi aciklanabilir.
 *
 * Object expression yapısını, isimsiz (anonymous) sınıflar oluştururken veya bir parametrede interface, class gibi yapılara ihtiyacımız oluyorsa onları sağlamak için kullanabiliriz.
 * Özetle object expression kullanımında,arka planda isimsiz(anonymous) classlar oluştururuz.(Show kotlin bytecode ile görebilirsin)
 */

/**
 *
 */
interface TextWatcherInterface {
    fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int)
    fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int)
    fun afterTextChanged(text: CharSequence) {}
}


open class TextWatcherClass() : TextWatcherInterface {

    override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(text: CharSequence) {
        TODO("Not yet implemented")
    }

}

fun main() {

    val textWatcher = object : TextWatcherInterface { // İnterfacelere de uygulayabiliriz.
        override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(text: CharSequence) {}
    }



    val textWatcher2 = object : TextWatcherClass(), TextWatcherInterface {

        override fun afterTextChanged(text: CharSequence) {
            super<TextWatcherInterface>.afterTextChanged(text)
        } // <> arayüz şeklinde class veya interfaceden hangisini belirtirsem onun fonksiyonuna gider.

    }

    val textWatcher3 = object : TextWatcherClass() {
        override fun beforeTextChanged(text: CharSequence, start: Int, count: Int, after: Int) {}
    } // Sadece lazım olan fonksiyonu override edip kullanabilirim.


    //Interfaceyi bir classa implement edip o class'da bütün fonksiyonları override ettikten sonra o class'ı miras alıp kullanabiliriz.
    // Ya da interfaceyi bir interfaceye implement edip,bütün fonksiyonları override ettikten sonra o interfaceyi classa implement edip kullanabiliriz.
    // Bu şekilde kullanmak bize kullanmayacağımız gereksiz fonksiyonları override etme zorunluluğundan kurtarır.Kodumuzu daha temiz gösterir.


    // Classlara da uygulayabiliriz.Burda isimsiz bir class var ve TextWatcherClass'ı miras alıyor,TextWatcherInterface'yi implement ediyor.
    // Tip belirtiminde ise örneğin textWatcher2'nin tipini  : ile belirleyebiliriz.
    // Eğer sadece bir class extend ediyorsak veya sadece bir interface implement ediyorsak type inference olduğundan dolayı tip belirtimine gerek yoktur.
    // IDE zaten otomatik olarak ilgili tipi atayacaktır.

}





