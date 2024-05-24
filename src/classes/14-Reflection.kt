package classes

import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible


/**
 * Reflection kullanımı,class içerisinde private bir halde bulunun değişkenlere ve fonksiyonlara dışarıdan class referansı üzerinden erişimi sağlar.
 * Private olan constructor'una da erişebilirim.
 * Kotlin'de kullanabilmemiz için kütüphane eklememiz gerekir.
 * Ama kütüphane eklemezsek Kotlin'den Java,Java'dan Kotlin çağrılabildiği için class.java şeklinde erişebiliriz.
 * Gerçekten gerekmiyorsa kullanmamamız gerekiyor,çünkü pahalı bir işlemdir.
 * Kütüphane yazarken dışarıya kapatmak fakat kendi projemiz içerisinde kullanmamızı gerektiren yapılar varsa reflection ile erişebiliriz.
 */

/**
 * ProGuard 2 tane işlem yapar.
 * 1)Class'daki isimleri tanınmaz hale getirir,her bir gördüğü ismi anlamsız bir harf veya harf bütünüyle değiştirir.(obfuscate)
 * Bunun karşılığında bize bir mapping file verir.
 * Reflection yaparken isimlerle eriştiğim için ve ProGuard da bu isimleri tanınmaz hale getirdiği için reflection yaptığımız yerleri ProGuard'ın dışında tutmamız gerekiyor.
 * Bu sebeple reflection kullandığımız kısımların,ProGuard dosyasında saklanmadığından,obfuscate edilmediğinden emin olmamız lazım.
 *
 * 2)Kullanmadığımız fonksiyonları,classları,resource dosyalarını vs siler.Release modunda aldığımız apk'nın boyutuyula,debug modunda aldığımız apk'nın boyutu
 * arasında ciddi fark görürüz.Release modunda daha da küçülür.
 */


open class Account private constructor(val branchName: String, val branchCode: Int) {
    private var balance: Long = 123123123123

    private val accountName: String = "My Rich Account"

    private fun sentMoneyFromBalance(sentMoney: Long) {
        balance -= sentMoney
    }


}


fun main() {

//    val accountConstructor = Account::class.isOpen // Bu şekilde class'ın özelliklerini görebiliyoruz.
//    println(accountConstructor)

    val constructor = Account::class.primaryConstructor
    constructor?.isAccessible = true

    val account = constructor?.call("Samsun", 5555) as Account


    println(account.branchName)
    println(account.branchCode)

    // Constructor'ı privatedir.
    // Primary Constructor'ına erişip,isAccessible'yi true yaptık.
    // Class'ın nesnesini oluşturup içerisindeki parametrelere eriştik.


    Account::class.memberProperties.forEach {
        it.isAccessible = true
        print("${it.name} ") // İçerisindeki bütün member property'lere erişebilirim.
    }


}