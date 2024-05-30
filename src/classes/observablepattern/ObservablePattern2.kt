package classes.observablepattern

interface Observable { // Neyi kontrol ettirmek istiyorsak o fonksiyonları yazarız.
    fun onGetValue(value: Int)
    fun onValueChanged(oldValue: Int, newValue: Int)
}

class BankAccount2(val observable: Observable) {

    var balance: Int = 0
        get() {
            observable.onGetValue(field)
            return field
        }
        set(value) {
            val tempValue = field
            field = value
            observable.onValueChanged(tempValue, value)
        }

}

class BankAccount3(val onGetValue: (Int) -> Unit, val onValueChanged: (Int, Int) -> Unit) {

    var balance: Int = 0
        get() {
            onGetValue(field)
            return field
        }
        set(value) {
            val tempValue = field
            field = value
            onValueChanged(tempValue, value)
        }

}


fun main() {

    // Interface kullanarak

    val bankAccount = BankAccount2(object : Observable {
        override fun onGetValue(value: Int) {
            println("Value is $value")
        }

        override fun onValueChanged(oldValue: Int, newValue: Int) {
            println("Old Value:$oldValue,New Value:$newValue")
        }
    })
    bankAccount.balance = 100
    bankAccount.balance = 200

    println(bankAccount.balance)

    println("****************************")

    //Higher Order Function Kullanarak

    val bankAccount3 = BankAccount3({ value ->
        println("Value is $value")
    }, { oldvalue: Int, newValue: Int ->
        println("Old Value:$oldvalue New Value:$newValue")
    })

    bankAccount3.balance = 300
    bankAccount3.balance = 400
    println(bankAccount3.balance)


}