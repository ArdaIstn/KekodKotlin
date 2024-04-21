package classes

interface TextWatcher {


    fun afterTextChanged(text: String)
    fun beforeTextChanged(text: String)
    fun onTextChanged(text: String)

    fun funWithBody() {}


    val text: String
    var text2: String

    companion object {
        var name: String = "Arda"
    }
}


interface ChildInterface : TextWatcher {
    override fun onTextChanged(text: String) {}

    override fun beforeTextChanged(text: String) {}

    override fun afterTextChanged(text: String) {}


}

class InterfaceSample() : ChildInterface {

    override fun beforeTextChanged(text: String) {
        super.beforeTextChanged(text)
    }

    override val text: String = "asdasd"

    override var text2: String = "xzczxc"


}

// Object expression kullanımında arka planda textWatcher'in(interfacenin) nesnesi olusturulur.
// Interface'in içerisine yazılan tum fonksiyonların override edilme zorunlulugu yoktur.
// Basitce o fonksiyona body verirsek override edilme zorunlulugu kalkar.
// Fonksiyonun body'si yok ise override edilme zorunlulugu vardir.
// Eger interface'nin icerisine body'si olan bir fonksiyon tanimlarsak,arka planda statik bir class icerisinde statik bir fonksiyon tanimlamis oluruz.

fun main(args: Array<String>) {

    val a = object : TextWatcher {
        override fun afterTextChanged(text: String) {
            TODO("Not yet implemented")
        }


        override fun beforeTextChanged(text: String) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(text: String) {
            TODO("Not yet implemented")
        }

        override val text: String
            get() = TODO("Not yet implemented")
        override var text2: String
            get() = TODO("Not yet implemented")
            set(value) {}

    }


}

