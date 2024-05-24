package classes.singletonjava;

/**
 * Sadece bu sınıftan 1 tane nesne oluşturulacak.
 */


public class RetrofitDemo {

    public static void main(String[] args) {

        System.out.println("Hello Retrofit");

        Retrofit retrofit1 = Retrofit.getNewInstance();
        Retrofit retrofit2 = Retrofit.getNewInstance();
        Retrofit retrofit3 = Retrofit.getNewInstance();
        retrofit1.setCounter(10);
        retrofit1.setCounter(10);
        retrofit1.setCounter(10);

        System.out.println(retrofit1.getCounter());
        System.out.println(retrofit2.getCounter());
        System.out.println(retrofit3.getCounter());

        retrofit2.setCounter(10);
        retrofit3.setCounter(10);

        System.out.println(retrofit1.getCounter());
        System.out.println(retrofit2.getCounter());
        System.out.println(retrofit3.getCounter());

        // Buradan da anlıyoruz ki,biz aslında hep aynı nesneye erişmiş oluyoruz.
        // retrofit1,2,3 nesneleri aslında aynı nesnedir.
        // Bundan dolayı biz örneğin retrofit1'in setCounter'ini arttırdığımızda diğerlerininin de counter bilgisi değişmiş olur.
        // Hepsi de aynı ve tek olan objeyi bize geri dönerler.


    }

}
