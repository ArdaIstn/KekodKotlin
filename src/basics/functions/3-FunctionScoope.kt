package basics.functions


/**
 * Bir fonksiyon herhangi bir sinifin icerisinde degil de bir dosyanin icerisinde boslukta tanimlaniyorsa top level
 * function adini alir.
 *
 * Bir fonksiyon olusturulurken top level tanimlama yapilamiyor,sadece bir sinifa ait fonksiyonlar yazilabiliyorsa
 * bunlara fonksiyon degil,method denir.Bir fonksiyona fonksiyon diyebilmemiz icin top level tanimlaniyor olmasi lazimdir.
 */


fun main() {
    calculateAtomPhysics()// Buna erisebilirim


    // getValuesFromUserAndPrint() Buna erisemem


}/*------------------------------------------------------------------------------------------------------------------*/

/**
 *      Fonksiyon icerisinde fonksiyon tanimi kotlin'de yapilabilir. Bu fonksiyonlara Local Functions denir.
 *      Sebebi ise, yazdiginiz fonksiyonun kendi sinifinizdan dahi cagrilmasini istemeyebilirsiniz.
 *      Bu fonksiyonunun herhangi bir baska fonksiyon ya da sinif icinden degistirilmesini istemeyebilirsiniz.
 *      Reflection ile fonksiyonlariniz erisilirken gizli kalsin isteyebilirsiniz.
 *      Bu gibi durumlarda bu cok onemli fonksiyonunuzu baska bir fonksiyon icerisine yazabilirsiniz.
 *      Ekstra gizli bir fonksiyonunuz varsa o durumda kullanilabilir.
 * **/

fun calculateAtomPhysics() {


    val userName = "Codemy"
    println("Initialize Process...")


//    val numberOne = readLine()!!.toInt()
//    val numberTwo = readLine()!!.toInt()
//    val result = numberOne + numberTwo
//    println("$result")
//
//    val numberThree = readLine()!!.toInt()
//    val numberFour = readLine()!!.toInt()
//    val result2 = numberOne + numberTwo
//    println("$result2")

    //getValuesFromUserAndPrint() Tanimi asagida yaptigim icin fonksiyonun yukarisindan cagiramam.

    fun getValuesFromUserAndPrint() {
        userName.length
        val numberOne = readln().toInt()
        val numberTwo = readln().toInt()
        val result = numberOne + numberTwo
        println("$result")
    } // Kotlinin aslinda bize sagladigi ekstra bir ozellik olarak dusunebiliriz.



    getValuesFromUserAndPrint() // Sadece burada erisebilirim.Local fonksiyona sadece yazildigi fonksiyonun icinde erisebilirim.
    println("Process has been done")
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir sinifin icersindeki fonksiyonlara uye fonksiyonlar denir.
 * **/
class Car {
    fun setColor(colorCodeId: Int) {

    }
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Bir fonksiyon Generic tip aliyorsa, Generic Function olarak adlandirilir.
 * **/
fun <T> setColor(colorCodeId: T) { //Burada oyle bir degisken var ki,bunun tipini bilmiyorum diyoruz.

}

