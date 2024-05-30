package classes

import kotlin.concurrent.thread

/**
 * İŞ GÖRÜŞMESİ SORUSU
 * Soru:By lazy ve Lateninit farkı nedir ?
 *
 * Lateinit sadece var değişkenler  ile kullanılabilir,by lazy sadece val değişkenler ile kullanılabilir.
 *
 * Lateinit primitive tip değişkenler için kullanılamaz,by lazy primitive tip değişkenler ile de kullanılabilir.
 *
 * Lateninit ile kullandığımız değişkenler nullable değildir,by lazy ile kullandığımız değişkenler nullable olabilir.
 * Bundan kaynaklı lateinit ile kullandığımız değişkenler bize kesin olarak null safety sağlar.(NPE almayız)

 * Lateinit default olarak thread safe değildir fakat by lazy default olarak thread safe'dir.
 * Ama biz bunu değiştirebiliriz.(Default olarak SYNCHRONIZED fakat PUBLICATION ve NONE ile bu durumu değiştirebiliriz)
 *
 * Lateinit kullanımında ilk başta bir değer atamadığımızdan dolayı,ilgili değişkene değer atamadan önce erişmek istediğimizde exception alırız.
 * Fakat by lazy kullanımında süslü parantezler içerisine inital değerini veririz,kullanımında ise ilgili değişkene ne zaman
 * erişilirse atama işlemi o zaman gerçekleşmiş olur.
 */

/**
 * By lazy ile tanımlanan bir değişken,ilk erişildiğinde,kullanıldığı anda değerlendirilir ve değeri hesaplanır.
 * Sonraki erişimlerde ise hesaplanan değer doğrudan döndürülür.
 * Yani by lazy kullanımında,ilk erişimde süslü parantezlerin içerisi sadece 1 kere çalışır,2. erişimde atanan değer geri döndürülür.
 * Bu,özellikle hesaplanması maliyetli ve zaman alan işlemler için performans avantajı sağlar.
 * Gereksiz,kullanma ihtiyacımız olmayan değişkenlere sınıfların ilk ayağa kalktığı zaman kullanmasak bile değer ataması yapmak ciddi bir probleme yol açar.
 * val değişkenler için -> by lazy
 * var değişkenler için -> lateinit
 * Bu değişkenler sınıfın ayağa kaldırıldığı anda görev almayacaksa,bu kw'leri kullanarak değerlerinin memory'de daha sonradan yer kaplamasını sağlayabiliriz.
 */

/**
 * Null Safety:by lazy ile tanımlanan değişkenler,null olabilir.Bu nedenle kullanmadan önce değerinin null olup olmadığına
 * bakmamız gerekebilir.
 */

/**
 * Thread Safety:by lazy default olarak thread safe'dir.Yani,aynı değişkene birden fazla thread aynı anda eriştiğinde,
 * doğru değer güvenli bir şekilde döndürülür.
 *
 */

/**
 * Kullanım Durumu:Genellikle,hesaplanması maliyetli olan,ancak her zaman kullanılmayabilecek değerler için tercih edilir.
 * Özellike sınıf ilk ayağa kalktığında,yüklenirken kullanmayacağımız class global değişkenler için tercih edilir.
 * Örneğin,bir konfigürasyon dosyasını okumak veya bir ağ isteği yapmak gibi işlemler için idealdir.
 */

class Foo2() {


    init {
        println("Object initialized")
    }
}


fun demo() {
    val lazyObject: Foo2 by lazy() {
        println("Lazy Object initialized")
        Foo2()

    }//Bu lazyObject'e ne zaman erişirsek o zaman memory'de yer kaplar.


    /**
     * SYNCHRONIZED: lazy değerine ilk erişimde tüm threadler'i bloklar ve value alanının oluşturulmasını tek bir threadle sınırlar.
     * Default yöntem budur.
     *
     * PUBLICATION:value alanının oluşturulmasını tek bir thread'e sınırlama getirmez.
     * Birden fazla thread value alanını aynı anda oluşturabilir,ancak oluşturma işlemi tamamlandıktan sonra sadece
     * bir thread'e value alanına erişim izni verilir.Diğer threadler oluşturma işlemi tamamlanana kadar bekler.
     *
     * NONE:Thread güvenliği sağlamaz.Birden fazla thread aynı anda value alanını oluşturabilir ve bu oluşturma işlemi
     * sırasında herhangi bir senkronizasyon yapılmaz.Bu nedenle bu mod,yalnızca tek thread'in erişimine uygun olan durumlarda kullanılmalıdır.
     * SYNCHRONIZED ve PUBLICATON'a göre daha performanslıdır ama multithread bir kullanım yapıyorsak NONE'yi kullanamayız.
     * Bu durumda thread kullanımını developer kontrol etmelidir.
     */


    val lazyObject2: Foo by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Foo()
    } // Burda hangi tipi veriyorsak onu geri döndürmek zorundayız.

    // ilk erişimde init bloğu çalışır.
    println("First access")
    println(lazyObject)


    //İkinci erişimde init bloğu çalışmaz,sadece önceki nesne döndürülür.
    println("Second access")
    println(lazyObject)


}

class LazyPublicatonExample {
    val lazyValue: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("lazy value is being computed")
        Thread.sleep(2000)
        "Hello world"

    }
}


fun main() {
//    demo()

    val example = LazyPublicatonExample()

    //İlk erişimde değer hesaplanır
    val thread1 = thread { println("Thread1:${example.lazyValue}") }

    //İkinci erişimde tekrar değer hesaplanmaz,daha önceki değer kullanılır
    val thread2 = thread { println("Thread2:${example.lazyValue}") }


    Thread.sleep(5000)
    val thread3 = thread { println("Thread3:${example.lazyValue}") }

    //Threadler'in tamamlanmasını bekler.
    thread1.join()
    thread2.join()

    /**
     * Özetle PUBLICATION VEYA SYNCHRONIZED süslü parantezler içerisine aynı anda birden fazla thread'in girip giremeyeceğini gösterir.
     * Ama by lazy'yi kullandığımzda 3'ünden biri olsun hiç farketmez,değer bir kere atandıktan sonra erişen herhangi bir thread,
     * zaten değeri olduğu için süslü parantez içerisini çalıştıramıyor,sadece atanan değeri bize geri döndürür.
     */

}