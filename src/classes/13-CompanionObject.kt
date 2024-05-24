package classes

/**
 *  Companion obje dedigimiz sey nesnesi static olarak memoryde yer kaplayan,classin ismi ve . diyerek icerisindeki herhangi bir fonksiyona
 *  veya degiskene erisebildigimiz yapidir.
 *  İstersek isim de verebiliriz.
 *  Bizim companinon objemiz,hem bir classi miras alabilir hem de bir interfaceyi implement edebilir.
 *  İsterse companion'a isim verebiliriz.
 *  Bir class içerisinde birden fazla companion object tanımlayamayız.
 *  İsim vermez isek Companion adini alir.
 *  Companion object kullanımı yaparken bağlı olduğu sınıfla alakalı anlamlı işlemler yapmalıyız.

 */

/**
 * Companinon object ile object singleton farkı nedir ?(MÜLAKAT SORUSU)
 * Companion kullanımda bir class'ın içerisinde olduğu için statiktir.
 * Ayrıca düz object kullandığımızda kendi nesnesi kendi içerisinde bulunur,companion kullanımında kendi nesnesi kendi içerisinde değil,
 * bağlı olduğu sınıfın içerisinde bulunur.
 * Yani biz sınıfımıza eşlik eden bir singleton oluşturmuş oluyoruz.
 * Object kullanımında statik tutulduğu için lifecycle'ına bizim karar vermemiz gerekiyor.(Uygulamanın lifecycle'ı)
 * Companinon kullanımında aynı şekilde object statik tutulur,fakat bir class'ın içerisinde olduğu için o class'ın lifecycle'ına bağlıdır.
 * Companinon kullandığımızda daha özelleştirilmiş,sınıfa bağlı bir singleton kullanım yapmış oluruz.
 * Object kullanımında object'in kendisi singleton iken,companion object kullanımında ise sadece companion object singleton'dır.İçerisinde bulunduğu class singleton değildir.
 * Özetle Companinon object kullanımında class'ın tamamını değil,belli bir kısmını Singleton yapmak için kullanırız.
 */


open class MyBaseFragment()

interface SomeFragmentFun {
    fun foo()

}

class MyHomeFragment {

    var valueList: List<Pair<String, Any>> = listOf()

    companion object : MyBaseFragment(), SomeFragmentFun {

        const val pi = 3.14

        fun newInstance(valueList: List<Pair<String, Any>>): MyHomeFragment {
            val fragment = MyHomeFragment()
            fragment.valueList = valueList
            return MyHomeFragment()
        }

        override fun foo() {
            TODO("Not yet implemented")
        }
    }

}

object SomeSingleton {

    val name: String = "Arda"

}


fun main() {
    val homeFragment = MyHomeFragment()
    homeFragment.valueList = listOf()

    SomeSingleton.name


    MyHomeFragment.newInstance(listOf())

    // Burda newInstance'ye direkt olarak erişemem çünkü statik değildir.
    // Erişirken gözükmeyen bir Companion nesnesi vardır,bunday dolayı erişebilirim.


}