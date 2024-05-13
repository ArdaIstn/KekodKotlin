package classes

fun main() {

    val homeFragment = HomeFragment()
    val dashBoardFragment = DashBoardFragment()

    homeFragment.callPrintParam()

    dashBoardFragment.callPrintParam()


}


abstract class BaseFragment() {

    fun <T> printParam(param: T) {
        println("Param:$param")
    }
    // T tipinde bir fonksiyon tanimliyorum,tipini bilmiyorum herseyi alabilir.
    // Bu fonksiyon ayni zamanda tanimladigim T tipinde bir parametre aliyor.
    // Bu fonksiyon oyle bir degisken tipi alacak ki Int,String,Any hersey olabilir.

    // Fonksiyonlara uygulayacaksak fun <T> printParam(param: T) {
    //        println("Param:$param")
    //    }  seklinde uygulayabilirim.
}

class HomeFragment() : BaseFragment() {

    fun callPrintParam() {
        printParam(10) // Int de verebilirim.
    }

}

class DashBoardFragment() : BaseFragment() {

    fun callPrintParam() {
        printParam("Arda") // String de verebilirim.
    }

}

/**
 * MÜLAKAT SORUSU GELEBİLİR
 * Neden Genericsler yerine Any kullanmamaliyiz ?
 *
 * Any herseyin yerine gectigi icin bize type safety(tip güvenliği) saglamaz.
 * Kodumuz derlenir compile time'da bir problem olmaz fakat runtime'de bir problem olabilir.
 * Örneğin bir fonksiyonda Any kullanıp 2 parametreye toplama işlemi yaptırıp,yanlış String bir parametre verdiğimizde hata alabiliriz.
 * Bir hatayi runtime yerine compile time'da almamiz development acisindan çok önemlidir.Generics'ler bize bunu sağlar.
 * Ayrıca Any kullanırsak herhangi bir kısıtlamaya gidemeyiz.Parametre olarak Int,Long,Boolean,String hepsini verebiliriz.
 * Generics kullandığımızda ise istediğimiz şekilde bir kısıtlamaya gidebiliriz.
 */
