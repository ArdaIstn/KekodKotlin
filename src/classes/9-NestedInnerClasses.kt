package classes

/**
 * Nested classlarda ön eke gerek yoktur,fakat inner classlarda ön ek koymamız gerekir.
 * Aslında kullanmamın amacı iç içe classlar birbiriyle bağlantılı olacağından harici bir dosya açmamak için kullanılır.
 * Kullanacaksak nested yerine inner class kullanmak daha mantıklıdır.
 */

/**
--Class icinde class yaziyorsak bunun ismi nested class oluyor (adi farkli olabilir)


---Nested class'lar outer class'in uye property'lerine ya da fonksiyonlarina erisemezler
Nested class'lar static olarak tutulurlar. Bundan dolayi da outer class uzerinden nested class ulasmak istemeniz durumunda ;

--Outer.NestedClass()
seklinde erisilebilir.

------------------------------------------------------------------------------------------------------------------------

+++Inner class'lar static olarak tutulmazlar.Bundan dolayi erisim yapmak istedigimizde
--Outer().InnerClass()
seklinde outer class'in da instance'ini olusturmamiz gerekmektedir.
bundan dolayi inner class outer class'in tum elemanlarina ulasabilir, private olsa dahi.




--- Inner class'in icerisinde yeni bir nested class eklenememektedir. Ancak yine inner class ekleyebiliriz.

+++ Nested class'in icerisine yeni bir nested ya da inner class ekleyebiliriz.




--!!-- NOT --!!--
Static tutulan class islem bitse de CPU'dan otomatik temizlenmez (garbage collector), performansi etkiler.Bundan dolayı statik olarak tutulan  nested classda
biz Outer classının property veya fonksiyonlarını kullanamayız.Kullanabilseydik Outer classını da memoryde tutuyor olacaktık.
Erişebilseydik,bi anlamda nested classının statikliği Outer classina yapismis olacakti.Bu da Memory Leak'e sebep olurdu.
Outer 2'de ise Inner Class static olmadığı için Outer2'dekilere erişmesinde  bir problem yoktur.Zaten Kullanımı bittiğinde memoryden silinecektir.
Outer 2 'de memoryden silinecektir.

 */

class RecycleView {

    val outerName: String = "RecycleView"

    class ViewHolder { // Nested kullanimdir,static class seklinde durur.
        val nestedName: String = "ViewHolder"

//        fun getOuterName(): String {
//            return outerName
//        } Erisemeyiz.
    }

}

class RecycleView2 {
    val outerName: String = "RecycleView2"

    inner class ViewHolder2 { // Inner kullanimdir,public final class seklinde bulunur.
        val innerName: String = "ViewHolder2"

        fun getOuterName(): String {
            return outerName
        }
    }

}

/**
 * Nested kullanimlarda nested class statik olacagi icin outer class'inin nesnesine ihtiyaç yoktur.
 * Ama inner class kullanıyorsak,inner class statik olmadığı için outer class'inin nesnesine ihtiyac duyariz.
 */


fun main() {
    val recycleView = RecycleView()
    val viewHolder = RecycleView.ViewHolder()

    val recycleView2 = RecycleView2()
    val viewHolder2 = RecycleView2().ViewHolder2()


}



