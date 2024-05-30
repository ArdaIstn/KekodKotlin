package classes

class DataBase {
    private val data = mutableMapOf<String, String>()

    fun saveData(key: String, value: String) {
        data[key] = value
        println("Saved:$value with key:$key to the database.")
    }

    fun getData(key: String): String {
        return data[key] ?: "Not data found"
    }
}

class User(private val db: DataBase) {
    private var _name: String? = null
    private var _email: String? = null

    var name: String
        get() {
            if (_name == null) {
                _name = db.getData("name")
            }
            return _name ?: "Not data found"
        }
        set(value) {
            _name = value
            db.saveData("name", value)
        }


    var email: String
        get() {
            if (_email == null) {
                _email = db.getData("email")
            }
            return _email ?: "Not data found"
        }
        set(value) {
            _email = value
            db.saveData("email", value)
        }

}

fun main() {

    val dataBase = DataBase()
    val user = User(dataBase)

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