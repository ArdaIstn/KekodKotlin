package scoopefunctions

data class User(val name: String, val age: Int)

class Student {
    var name: String = ""
    var age: Int = 0

    fun someUserFun(user: User?) {

        val foo =
            user?.let { // Zaten varolan bir nesne üzerinde null check yapacaksak run veya let kullanabiliriz.Ama let önerilir.
                5
                null
            } ?: run {
                4
            } // Burda elvis operatörünün kontrölü user nesnesiyle ilgili değil,let'in süslü parantezlerinin son satırında ne döndüğüyle ilgilidir.
        // Bundan dolayı burda user eğer null değilse hem let bloğuna hem run bloğuna girer.

        val boo = user?.also {
            5
            null
        } ?: run {
            3
        } // Burda run bloğu hiç çalışmaz,also'nun geri döndürdüğü user'ın kendisi yani T'dir.

        // Sonuc olarak elvis operatörünü kullanırken,null check yapacaksak ve bu null check'in içerideki son satır değilde değişkenin kendisine
        // bagli olmasını istiyorsak,let'i değil also'yu tercih etmeliyiz.

        user?.run {

        }
        println("Foo:$foo")
        println("Boo:$boo")
    }
}


fun main() {

    val student = Student().apply {
        name = "John"
        age = 29
    }

    val student2 = Student().also {
        it.name = "John"
        it.age = 29
    }

    val user = User("Max", 32).apply {

    }
    println(user.name)
    println(user.age)

    val user2 = User("Mike", 38).also {
        println("Also do this.")
    }

    println(user2.name)
    println(user2.age)


    /*
   * Nesne oluşturma işlemlerinde genellikle apply kullanılır ama also da kullanılabilir.
    Burda geri dönüş değeri olarak aldığım şey Student() nesnesidir.

   * Bir öneri olarak normal class'larda apply,data class'larda ise also kullanılabilir.
    Anlamsal olarak düşündüğümüzde de data class ile oluşturduğumuz zaman değişkenlerin değerini atarız ve bunun yanında,
    ek olarak bir işlem yaptırmak için also kullanılabilir.Ama apply kullansak da herhangi bir problem olmaz.
     */

    println(student.name)
    println(student2.name)

    /*******************************************************************************************************************/

    val student3 = Student().run {
        name = "Mike"
        age = 29
        this
    } // Burda boşken Unit değerinde geri döner.
    // Eğer this verirsek run'ın extend ettiği şeyi alırız o da Student nesnesine denk gelir.
    // Bunun yerine apply veya also kullanımı daha mantıklı olacaktır.

    /*******************************************************************************************************************/

    val student4 = Student().let { _student ->
        _student.name = "George"
        _student.age = 32
        _student
    } // let kullanımında da aynı mantık geçerlidir.

    println(student3.name)
    println(student3.age)

    println(student4.name)
    println(student4.age)

    /*******************************************************************************************************************/

    val student5: Student =
        with(Student()) { // Nullable bir ifade varsa kullanmamak gerekir.Ekstra null check yapmamız gerekir.Nullable değilse with'i kullanmaliyiz.
            name = "Paul"
            age = 35
            this
        } // With kullanımında da aynı mantık geçerlidir.

    student.someUserFun(user)


    /**
     * Özet olarak,
     * Nesne oluşturma işlemi yapıyorsak Apply veya Also kullanmamız gerekir.
     * Daha çok düz classlar için apply,data class ise also kullanmayı tercih edebiliriz.(Nesneyi oluşturduk yanında bişeyler daha yapacaksam also)
     * Elimizde bir nesne var ve nullable ise let veya run,nullable değilse yani null değer alma ihtimali olmayan bir değişkense with kullanabiliriz.
     * run'ın extension olmayan halini de gruplamak isteyip,fonksiyonlara ayırmak istemediğimiz zamanlarda kullanabiliriz.
     * Eğer elimizde nullable bir değişken var ama expression kullanım da yapıyorsak let-run,Eğer bir değişkene atama yapmıyorsak,daha az hatayla uğraşmak için also-run yapabiliriz.(let-run da yapılabilir )
     * Expression kullanım yaparken de let'in son satırının null olmaması gerektiğine dikkat etmemiz gerekir.Eğer null gelirse let'den sonra run bloğu da çalışır.(Elvis operatörüyle kullanırsak)
     *
     *
     */
}