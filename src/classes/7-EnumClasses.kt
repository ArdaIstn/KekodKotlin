package classes

/**
 * Enum Class'lari kullanmamizdaki amac ayni veri kumelerinin gruplanabilir olmasini saglamaktir.
 * Bize tip güvenligini saglar.(Type Safety)
 * Aynı zamanda opsiyonlarin tamaminin  neler oldugunu gormemizi saglayip hata yapmamizi engellemis oluruz.
 *
 */

/** ENUM CLASSLAR'IN OZELLİKLERİ
 *
 * Visibility Modifierlar ile ozel bir kisiti yoktur.
 * Primary Constructor tanimlanabiliyor.
 * Init blogu kullanilabiliyor.
 * Secondary constructor olusturulabilir.
 * Enum Class'lar baska bir class'i miras alamazlar.
 * Interface implement edilebilir.
 * Eger implement edilen interfacenin body'siz bir fonksiyonu varsa,bu durumda bu fonksiyon ya enum class'ının icerisinde ya da
 * enum sabitlerinin her birinin icerisinde ayri ayri override edilmek zorundadir
 * Enum Class'ların nesnesi olusturulamaz.Cunku primary constructor'ı mecburi olarak private tutulmak zorundadir.
 * Primary constructor'ın VM'si private disinda digerlerini kabul etmemektedir.
 * Companion object tanimi yapilabilir.
 * Sealed,open,abstract,inner enum class'lar yapılamıyolar.Default olarak final durumundadirlar.Degistirilemezler.
 * Baska bir enum class'ı da miras alamazlar.
 * İçerisine fun tanimi yapilabilir.
 * İçerisine abstract fun tanimi yapilabilir ancak bunu yaptigimizda tum enum  sabitleri bu fonksiyonu override etmek zorunda olacaktir.
 * Open bir fun da  tanimlanabilir,bu durumda enum sabitleri bu fonksiyonu override etmek zorunda kalmaz.Opsiyonel hale gelir.
 * Enum sabitlerinin constructor'lari bulunabilir fakat icerisinde direkt olarak property tanimlanamaz.
 * Ancak enum classı,kendi constructor'ında bir property'ye sahipse,tüm enum sabitleri bu property'ye kendi constructor'larında sahip olmak zorundalar.
 * Enum sabitleri tek basina bir class'i miras alamazlar yada bir interface'yi tek baslarina implement edemezler.
 * Sabitlerin onune class kw'u eklenemiyor.
 * Yapildiginda nested class gibi algilanir.
 * Sabitlerin icerisinde class tanımlanamıyor fakat inner kw kullanarak inner class seklinde tanimlanabilir.
 * Sabitlerin icerisinde düz bir fonksiyon veya property tanimlanabilir.
 * Enum classlar'ın entries ve values() fonksiyonlari bize o enum class'ın enum sabitlerinin listesini verir.
 * Kotlin 1.9'dan sonra entries values() fonksiyonunu yerini almistir.
 * valuesOf() fonksiyonu ise o enumdaki belli bir enum sabitini bize dondurur.Yanlis isimlendirme yapilirsa Illegal Argument Exception hatasi aliriz.
 * name ve ordinal diye 2 ayrı property'ye sahiptirler.
 * name enum sabitinin ismini doner,toString'den bagimsizdir.
 * name ve ordinal property'leri finaldir yani override edilemez.
 * ordinal ise enum sabitinin enum icerisindeki sirasini bize verir.(0'dan baslar.)
 * Enum sabitleri static class formunda bulunduklari icin,nesneleri uretilmeden icerisindeki fonksiyonlara ve property'lere erisebiliriz.
 * Enum sabitinin ismine direkt olarak eriseceksek,bir format kaygimiz yoksa zaten enum classlar'inin ozel bir property'si olan name'i kullanmaliyiz.
 * Eger bu sabit isminde bir degisiklik ya da format farkliligina gideceksek bu durumda toString() fonksiyonunu override etmemiz gerekir.
 * Enum classının constructor'ında da bir String property ile bunu yapabiliriz ama bu çok doğru olmaz.
 * Enum class'ının içerisine yazılabilen duz fonksiyonlara,static olmadiklari icin disaridan erisim yoktur.
 * Bu fonksiyonların amaci,enum sabitlerinin içerisindeki kodların okunaklığını arttırmak için kullanılırlar.
 */


interface someInterface {
    fun hoo()
}


enum class Team(val starCount: Int) : someInterface {
    FENERBAHCE(4) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }


    },
    GALATASARAY(4) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }
    },
    BESIKTAS(3) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return "Besiktas"
        }
    },
    TRABZONSPOR(2) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }
    },
    SIVASSPOR(0) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }
    },
    SAMSUNSPOR(0) {
        override fun someFoo() {
            TODO("Not yet implemented")
        }

        override fun hoo() {
            TODO("Not yet implemented")
        }
    };

    abstract fun someFoo()
    open fun deneme() {

    }

    companion object


}


fun main() {

    val fenerbahce = "Fenerbahce"
    val galatasaray = "Galatasaray"
    val besiktas = "Besiktas"
    val trabzonspor = "Trabzonspor"
    val sivasspor = "Sivasspor"
    val samsunspor = "Samsunspor"


    // Bu sekilde gruplanabilir veri kumeleri var ise enum class kullanmamiz daha iyi,okunabilir kod yazmamizi saglayacaktir.


//    val userType = student,teacher,manager,parent

    val isStudent = false
    val isTeacher = false
    val isManager = false
    val isParent = false

    val studentType = 0
    val teacherType = 1
    val managerType = 2
    val parentType = 3

    val userType = teacherType

    when (userType) {
        0 -> println("Student")
        1 -> println("Teacher")
        2 -> println("Manager")
        3 -> println("Parent")
    }
    // İlerleyen sureclerde koda baktigimizda 0,1,2,3'ün ne oldugunu anlamamiz zor olur.
    // 0,1,2 ve 3'ün kelime olarak veya anlam olarak ne ifade ettigini anlamamiz zorlasmis olur.
    // Bu gibi durumlarda enum classları kullanabiliriz.


    /*****************************************************************************************************************/

    println("****************************************************************************")

    println(Team.entries)
    println(Team.valueOf("FENERBAHCE"))

    println(Team.FENERBAHCE.name)


    println(Team.FENERBAHCE.ordinal)

    println(Team.BESIKTAS)

    getBestTeam(Team.FENERBAHCE)


}

fun getBestTeam(team: Team) {
    println("Best team is:${team.name}")
}

// Bu fonksiyonda eger bekledigim sey bir supertype ise childlarını da verebilirim.
// Bu ornekte ben team bekliyorum fakat Team.Fenerbahce verebilirim cunku enum sabitleri enum class'ini miras alirlar.
// Ayni zamanda supertype dedigimiz şey bir interface de olabilir.
// Bu durumda eğer ben parametre olarak someInterface bekleseydim de aynı şekilde Team.Fenerbahce'yi verebilecektim.
// Çünkü enum classı someInterface interfacesini implement ettiği için,child olan enum sabitleri de enum classını miras aldığından dolayı Team.Fenerbahce'yi verebilirim.
// Unutma,supertype dediğimiz şey ya bir Class ya da bir Interface'dir!!!!



