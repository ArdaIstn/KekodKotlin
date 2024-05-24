package classes

/**
 * Şöyle düşünebiliriz, örneğin elimizde bir data class var,data object kullanımı ise bu data class'ın singleton halidir.
 * data object kullanımında arka planda toString(),hashCode() ve equals fonksiyonu otomatik olarak yazılır.
 * data object ve singleton object kullanımında, classlar arka planda statik olarak yazılır.
 * Bunun sebebi 2 class'ın da nested olarak yazılmasından kaynaklıdır.
 */

sealed class MySealedClass() {
    data object myDataObject : MySealedClass() {}
    object myObject : MySealedClass()
}




fun main() {

    val dataObject = MySealedClass.myDataObject
    val normalObject = MySealedClass.myObject

    println(dataObject)
    println(normalObject)


}