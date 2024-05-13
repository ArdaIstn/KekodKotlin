package classes

sealed class SealedTeams(val starCount: Int) {
    object Fenerbahce : SealedTeams(3)
    object Galatasaray : SealedTeams(4)
    object Besiktas : SealedTeams(2)
}


sealed class SealedTeams2(val starCount: Int)

object Fenerbahce : SealedTeams2(3)
object Galatasaray : SealedTeams2(4)
object Besiktas : SealedTeams2(2)


enum class Teams2(val starCount: Int) : printInterface {
    FENERBAHCE(4) {
        override fun print() {
            TODO("Not yet implemented")
        }
    },
    GALATASARAY(3) {
        override fun print() {
            TODO("Not yet implemented")
        }
    },
    BESIKTAS(2) {
        override fun print() {
            TODO("Not yet implemented")
        }
    }
}

interface printInterface {
    fun print()
}

fun main() {
    val sealedFB = SealedTeams.Fenerbahce.starCount

    val sealedFB2 = Fenerbahce.starCount // SealedTeams2

    val enumFB = Teams2.FENERBAHCE.starCount

    /**
     * Sealed class'ın içerisinde veya dışarısında SADECE object kullanımı yapıyorsak,SealedTeams2 orneginde arka planda
     * static gibi durmasalar da,class'ının tanımının yapıldıgı yerde static instance'ye sahiptirler bundan dolayi
     * kullanim olarak static kullanımı yapabiliriz.Zaten Enum class'larin da sabitleri statictir.
     * Üçünün de teknik anlamda kullanimi aynidir.
     *
     * Eger ki Sealed Class'lari kendi icerisinde SADECE object barindiracak seklinde kullaniyorsak,bunu enum class
     * seklinde kullanabiliriz.Ayni kullanimdir.
     */

}