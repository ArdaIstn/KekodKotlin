package basics.basictypes

fun main() {

    /**
     * 8 bit kadar alan kaplarlar.
     * true ya da false degeri atamasi icin kullanilir.Nullable versiyonlari null deger alir.
     * 0 ya da 1 boolean olarak kullanilamaz.
     */

    val isStudent: Boolean = true
    val isTeacher: Boolean = false
    val isFirstStudentMale: Boolean? = null

    /*--------------------------------------------------------------------------------------------------------------------*/


    /**
     * ||(or) , &&(and) !(not) gibi operatorlerle birlikte kullanilir.
     */
    if (isStudent && isTeacher) {
        println("Student and teacher")
    }
    if (isStudent and isTeacher) {
        println("Student and teacher")
    }
    if (isStudent || isTeacher) {
        println("Student or teacher")
    }

    if (isStudent.or(isTeacher)) {
        println("Student or teacher")
    }

    if (isStudent or isTeacher) {
        println("Student or teacher")
    }

    if (isStudent.not()) {
        println("Not student")
    }
    if (!isTeacher) {
        println("Not teacher")
    }

    /*--------------------------------------------------------------------------------------------------------------------*/


    /**
     * Boolean degerinin true olmasini kontrol ettirmek icin == true seklinde bir yazima ihtiyac yoktur.
     * Zaten ifade true ise suslu parantezlerin icerisine gircektir.Nullable kullanıyorsak bunu yapmak zorunludur.
     */

    if (isStudent == true) {

    }
    if (isStudent) {

    }

    /*if (isFirstStudentMale){
        Bu sekilde kullanamayiz,cunku artik 3 adet ihtimalimiz var.Null olmasi,true olmasi ve false olmasi.
    }*/

    if (isFirstStudentMale == true) {
        // Bu sekilde kullanmaliyiz.
    }


    /*--------------------------------------------------------------------------------------------------------------------*/


    /**
     * // ve && operatorleri lazily calisma mekanizmasina sahiptir.Performans acisindan onemlidir.
     * Eger || opearatorunun solu true ise sagdaki degere bakmaya gerek duymaz ve true olarak kabul eder.
     * Eger && operatorunun solu false ise sagdaki degere bakmaya gerek duymaz ve false olarak kabul eder.
     */

}