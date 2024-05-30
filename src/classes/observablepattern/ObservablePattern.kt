package classes.observablepattern

/**
 * Observable pattern,yapılan bir işten yapan kişiyi haber etmektir.
 * Örneğin bir gözlemci olduğunu düşünürsek,bir değişkenin değeri değiştiğinde ve yeni bir değer atadığımızda bize yapılan
 * değişiklikleri haber verir.
 *
 * Android kısmında eğer ki kullandığımız değişkenle ilgili işlem belirli bir süre alacaksa ve o sürenin ne zaman tamamlanacağını bilmiyorsak,
 * arka planda observable pattern olan bir yapıyı kullanmamız gerekecektir.Değeri isteyeceğiz,değerin ne zaman geleceği belli değildir.
 * Örneğin değer setlendiği anda,UI'daki textview'a gidip işlemi tamamlamak gibi.
 */

interface PropertyObserver {
    fun onPropertyChanged(oldValue: Int, newValue: Int)
}

class ObservableProperty(var balance: Int) {
    val observers = mutableListOf<PropertyObserver>()

    fun setValue(newValue: Int) {
        if (newValue != balance) {
            val tempOldValue = balance // Eski değeri geçici olarak tempOldValue'ya verdik.
            balance = newValue  // Artık balance yeni değeri içerir.
            notifyObservers(tempOldValue, newValue)
        }
    }

    fun addObserver(observer: PropertyObserver) {
        observers.add(observer)
    }

    private fun notifyObservers(oldValue: Int, newValue: Int) {
        for (observer in observers) {
            observer.onPropertyChanged(oldValue, newValue)
        }
    }

}

class BankAccount : PropertyObserver {
    override fun onPropertyChanged(oldValue: Int, newValue: Int) {
        println("$oldValue -> $newValue") // Değeri değiştiğinde buraya haber verilir.
    }
}


fun main() {

    val observableProperty = ObservableProperty(0)
    val bankAccount = BankAccount()
    observableProperty.addObserver(bankAccount) // Bankaccountu eklediğimizde onun onPropertyChanged metodunu çağırırız.
    observableProperty.setValue(1000)
    // observableProperty.observers.clear()  Listeyi temizlediğimden dolayı for döngüsü herhangi bir değişkenin onPropertyChanged metodunu çağıramıyor.
    observableProperty.setValue(50)


}