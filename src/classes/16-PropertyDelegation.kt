package classes

import kotlin.reflect.KProperty


// Seperation of Concern -> User sınıfı verileri yönetirken,Delegate sınıfı veritabanı işlemlerini,DataBase sınıfı  ise sadece veritabanının implemantasyonunu yönetir.
// Property'de sadece get ve set fonksiyonlarını delegate edebiliriz.
class DataBase2 {
    private val data = mutableMapOf<String, String>()

    fun saveData(key: String, value: String) {
        data[key] = value
        println("Saved:$value with key:$key to the database.")
    }

    fun getData(key: String): String {
        return data[key] ?: "Not data found"
    }
}

class DataBaseDelegate(private val db: DataBase2, private val key: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return db.getData(key)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        db.saveData(key, value)
    }


}

class User2(db: DataBase2) { // name ve email bilgilerini DataBaseDelegate sınıfından al diyoruz.
    var name: String by DataBaseDelegate(db, "name") //name'in get fonksiyonunu getValue,set fonksiyonunu setValue()'ya devretmiş,atamış oluruz.
    var email: String by DataBaseDelegate(db, "email")//email'in get fonksiyonunu getValue,set fonksiyonunu setValue()'ya devretmiş,atamış oluruz.
    //Eğer tüm değişkenler için get ve set işlemleri aynıysa bu şekilde yapılabilir.
    // Burda User2 sınıfı datanın nasıl alındığından haberdar değildir.
    // Bu şekilde kod daha okunabilir,temiz ve yönetilebilir olur.
    // get ve set fonksiyonlarını DataBaseDelegate sınıfına delegate ediyoruz.
}

fun main() {

    val dataBase = DataBase2()
    val user = User2(dataBase)

    //Getting Values
    println("User Name: ${user.name}")
    println("User Email: ${user.email}")

    //Setting Values
    user.name = "Arda"
    user.email = "Arda@example.com"


    //Getting Values Again
    println("User Name: ${user.name}")
    println("User Email: ${user.email}")
}