package classes

fun main() {
    val initDemo = InitOrderDemo("arda")
    Customer("arda")
    Person("Arda", "Işıtan", 24, true)
    // DontCreateMe()

    myInfo("Arda", "Işıtan", 24, "USA", "White")
    myInfo("Burak","Kaya",24, skinColor = "Black")


}


class Person(val firstName: String, val lastName: String, var age: Int, var isEmployed: Boolean = true) {

}

fun myInfo(name: String, surname: String, age: Int, country: String = "Turkey", skinColor: String) {

}

class Person2(val name: String) {
    val children: MutableList<Person2> = mutableListOf()

    constructor(name: String, parent: Person2) : this(name) {
        parent.children.add(this)
    }
}

class Empty


class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: $name".also(::println)

    init {
        println("Second initializer block that prints $name")
    }
    // Print edilme sirasi yazilma sirasina gore degisir.
}

class Customer(name: String) {
    val customerKey: String = name.uppercase().also(::println)
}

class DontCreateMe private constructor()
// Bir class'i abstract kw kullanmadan nesnesinin olusturulmasini nasil engelleyebilirim ?
// Default olan bos constructor'ını private'e cekip,herhangi bir secondary constructor yazmaz isek engelleyebiliriz.



