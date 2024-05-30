package classes


interface Printer {
    fun printDocument()
    fun changeColor()

}

interface Scanner {
    fun scan()
}

class FancyScanner() : Scanner {

    override fun scan() {
        println("FancyScanner!")
    }


}

class InkPrinter : Printer {

    override fun printDocument() {
        println("Ink")
    }

    override fun changeColor() {
        println("Ink Color")
    }


}

class LaserPrinter : Printer {
    override fun printDocument() {
        println("Laser")
    }

    override fun changeColor() {
        println("LaserColor")
    }


}

class MixedPrinter : Printer {
    override fun printDocument() {
        println("Mixed")
    }

    override fun changeColor() {
        println("Mixed Color")
    }


}

class MixedPrinterUltra : Printer, Scanner {
    override fun printDocument() {
        println("UltraMixed")
    }

    override fun changeColor() {
        println("UltraMixed Color")
    }


    override fun scan() {
        TODO("Not yet implemented")
    }

}


class DocumentPrinterManuel(private val printer: Printer, private val scanner: Scanner) {
    // Printer interface'sini beklediğimiz için bu interfaceyi implement eden tum child classlar'ı verebiliriz.
    // Manuel olarak delegation yaptık,bu kısım çok büyüyebilir.
    fun printDocument() {
        printer.printDocument()
    }

    fun changeColor() {
        printer.changeColor()
    }

    fun scan() {
        scanner.scan()
    }

}

class DocumentPrinterD(printer: Printer, scanner: Scanner) : Printer by printer, Scanner by scanner
// Bu interface'ye sahip class'ların yaptığı işi DocumentPrinterD class'ına devretmiş olduk.
// Yani bu constructor'da ne veriyorsak,verdiği şeyi bu class'a devrediyoruz anlamına gelir.
// Burda Printer ve Scanner interfacelerine sahip herhangi bir class'ın yaptığı işi,fonksiyonları herşeyi bu classa devretmiş oluruz.
// Eklenecek olan yeni bir child için ekstra bir kontrole gerek bıraktırmıyor.
// Arka planda by kw'du  printer ve scanner nesnesinin oluşturulmasını sağlıyor.
// Bu nesne sayesinde de parametreye hangisi geliyorsa onun printDocument(),changeColor() ve scan() fonksiyonlarının çağırılmasını sağlar.
// Aslında yukarıdaki kullanımla aynıdır,sadece nesne oluşturma işlemleri yoktur zaten onu da biz kendimiz aşağıda oluşturuyoruz.
// Sonuçta bu class'ın içi boş ama DocumentPrintManuel classı'nın yaptığı işleri ben bu classta da yapabiliyorum.


fun main() {

    val inkPrinter = InkPrinter()
    inkPrinter.printDocument()

    val scanner = FancyScanner()


    val documentManuelInkPrinter = DocumentPrinterManuel(inkPrinter, scanner)
    documentManuelInkPrinter.printDocument()
    documentManuelInkPrinter.scan()


    val laserPrinter = LaserPrinter()
    val documentManuelLaserPrinter = DocumentPrinterManuel(laserPrinter, scanner)
    documentManuelLaserPrinter.printDocument()

    val mixedPrinter = MixedPrinter()
    val documentManuelMixedPrinter = DocumentPrinterManuel(mixedPrinter, scanner)
    documentManuelMixedPrinter.printDocument()

    val mixedPrinterUltra = MixedPrinterUltra()
    val documentManuelMixedUltraPrinter = DocumentPrinterManuel(mixedPrinterUltra, scanner)
    documentManuelMixedUltraPrinter.printDocument()




    println("****************************")

    val inkPrinterD = InkPrinter()
    val documentInkPrinter = DocumentPrinterD(inkPrinterD, scanner)
    documentInkPrinter.printDocument()
    documentInkPrinter.changeColor()
    documentInkPrinter.scan()


    val laserPrinterD = LaserPrinter()
    val documentLaserPrinter = DocumentPrinterD(laserPrinterD, scanner)
    documentLaserPrinter.printDocument()
    documentLaserPrinter.changeColor()
    documentLaserPrinter.scan()


    val mixedPrinterD = MixedPrinter()
    val documentMixedPrinter = DocumentPrinterD(mixedPrinterD, scanner)
    documentMixedPrinter.printDocument()
    documentMixedPrinter.changeColor()
    documentMixedPrinter.scan()

    val mixedPrinterUltraD = MixedPrinterUltra()
    val documentUltraMixedPrinter = DocumentPrinterD(mixedPrinterUltraD, scanner)
    documentUltraMixedPrinter.printDocument()
    documentUltraMixedPrinter.changeColor()
    documentUltraMixedPrinter.scan()


}
