package classes

import kotlin.properties.Delegates

//Kotlindeki kullanımı ise bu şekildedir.

class User3 {

    //Observable'da kullanıcı hangi değeri verirse versin atama işlemi gerçekleşir.
    var name: String by Delegates.observable("No Name") { property, oldValue, newValue ->
        println("Old Value: $oldValue New Value: $newValue")
    }

    var surname: String by Delegates.observable("No Surname") { property, oldValue, newValue ->
        println("Old Value: $oldValue New Value: $newValue")
    }


    //Vetoable'de ise son satiri true ise atama işlemini gerçekleştirir.
    var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        println("Age wanted to changed  $oldValue to $newValue")
        newValue >= 18
    }
}

fun main() {

    val user = User3()

    //Lambda kısmı değer değiştiği anda haber verir.

    user.name = "John"
    user.surname = "Wick"
    user.age = 20

    println("Age: ${user.age}")

    println("************************************")

    user.name = "Alice"
    user.surname = "inBorderland"
    user.age = 25
    println("Age: ${user.age}")


}