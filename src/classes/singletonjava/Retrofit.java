package classes.singletonjava;


public class Retrofit {

    private volatile static Retrofit newInstance;// 2. olarak 1 adet nesneye ihtiyacımız oldugundan dolayı sınıfın içerisinde bir nesne oluşturdum.
    // Static fonksiyon içerisinde kullandığım üye değişkenin de static olmasından dolayı bu nesneyi static yaptım.
    // Bir degisken statik degilse statik olan bir fonk icerisinde kullanilamaz bu yuzden bu degiskeni statik olarak yazdik.
    // Statik olmasinin bir amaci ise memoryden silinmesin istiyoruz cunku uygulamanin lifecycle'ı boyunca herhangi bir t aninda ben bu objeye eristigimde
    //  her zaman dogru sekilde o objeyi alacagimdan emin olmam lazim.Static koyarak,memoryden silinmesini engelliyorum.


    private Retrofit() {

    } // 1. olarak default boş constructor'ını private yaparak dışarıdan nesne oluşturulmasını engelledim.Başka public constructor bulundurma.


    public static synchronized Retrofit getNewInstance() {
        // Static kw vererek bu fonksiyon artik bu classin instancesi olmadan da erisilebilir hale gelir.
        if (newInstance == null) { // Javada bir deger atamazsan default olarak bir classin instancesinin degeri nulldur.
            newInstance = new Retrofit(); // Eger null ise ilk kez erisiyorum anlamina gelir.
            // Retrofit'in nesnesini olustur ve newInstance'ye bu nesneyi ata deriz ve geri don deriz.
        }
        return newInstance;
    }

    // İçerisine üye değişkenler veya fonksiyonlar da tanımlayabiliriz.

    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int increaseValue) {
        counter += increaseValue;
    }


}
//3. olarak o nesneyi döndürecek olan public bir fun tanımladım.Sonrasında dışarıdan nesnesini oluşturamadigim için,
// bu fonksiyona erişemem.Bundan dolayı fonksiyonu static yaparak dışarıdan nesnesini oluşturmadan erişebilirim.

//synchronized:Fonksiyonlar icin birden fazla threadin ayni anda erisimini kapatmak icin kullaniriz.Ayni anda tek bir thread'in bu fonksiyona erisebilmesini saglar.
// volatile : Değişkenin değeri değiştiği anda üzerinde çalışan tüm threadlere bu değişkenin değerinin değiştiğini haber verir.Ekstra güvenlik için kullanılır.

