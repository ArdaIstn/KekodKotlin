package classes

/**
 * Lateinit ile tanımlanan değişkenler başlangıçta değer atanmadan tanımlanır.
 * Değer,kodun ilerleyen bir noktasında atanmalıdır.Sadece var olan değişkenler için kullanılabilir,val olan değişkenler
 * için zaten by lazy kullanılır.
 *
 * Null Safety:lateinit ile tanımlanan değişkenler,null olamaz.(non-nullable)
 * Bu,güvenli bir şekilde kullanılabileceklerini garanti eder.
 *
 * Lateinit primitive tipler ile kullanılamaz.
 *
 * Thread Safety:lateinit default olarak thread-safe değildir.Eğer birden fazla thread aynı anda erişirse beklenmedik
 * sonuçlar ortaya çıkabilir.
 *
 * Kullanım Durumu:Genellikle,yaşam döngüsü boyunca dışarıdan atanacak olan değişkenler için tercih edilir.
 * Örneğin,bir dependency injection framework'u tarafından atanacak olan veya aktivitenin onCreate() metoduda atanacak olan
 * değişkenler için idealdir.Kullanmadan önce ilk değer atamasını mutlaka yapmış olmamız lazım.
 */
class MySuperClass {
    lateinit var lateInitializedProperty: String

    fun initializeProperty() {
        lateInitializedProperty = "Initialized!!"
    }

    fun printProperty() {
        if (::lateInitializedProperty.isInitialized) { // Exception'ları önlemek için bu yöntem kullanılabilir.
            println("Value of lateInitializedProperty:$lateInitializedProperty ")
        } else {
            println("lateInitializedProperty has not been initialized yet !")
        }
    }
}


fun main() {
    val mySuperClass = MySuperClass()
    mySuperClass.printProperty()
    mySuperClass.initializeProperty()
    mySuperClass.printProperty()
    println(mySuperClass.lateInitializedProperty)


//    println(mySuperClass.lateInitializedProperty) lateinit property lateInitializedProperty has not been initialized.


}