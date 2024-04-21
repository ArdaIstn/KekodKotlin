package classes

fun main(args: Array<String>) {

}

abstract class Human(val name: String) {

    abstract var surname: String
    abstract val middleName: String
    open val age: Int = 24
    val eyeColor: String = "Blue"


    fun normalFun() {

    }

    open fun openFun() {

    }

    abstract fun abstractFun()


}


abstract class Turk(override val middleName: String = "zxczxc") : Human("Arda") {
    abstract val skinColor: String
    override fun abstractFun() {
        TODO("Not yet implemented")
    }

    override var surname: String = "axczczxc"


}

open class Kurt() : Human("asdasd") {
    override var surname: String = "asdasdzxc"


    override val middleName: String
        get() = TODO("Not yet implemented")

    override fun abstractFun() {
        TODO("Not yet implemented")
    }

}

class ChildTurk(override var surname: String) : Turk() {
    override val skinColor: String = "axcasd"
}

class ChildKurt() : Kurt() {
    override var surname: String
        get() = super.surname
        set(value) {}
}











