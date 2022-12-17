public class KronometreThread implements Runnable {

    /*
           1.Bir class in thread olabilmesi icin Runnable sinifina implements edilmelidir.
           2.Thread nasil olusturulur ?
             i.private thread nesnesi olusturulmali -->   private Thread t;
             ii.thread leri birbirinden ayirabilmek icin bir isim verilmeli private olarak --> private String threadName;
             iii.thread in ismini olusturmak için constructor ya da get set olmalidir.

     */


    private Thread t; // thread nesnesi
    private String threadName; // thread leri birbirinden ayirabilmek icin bir isim verdik

    public KronometreThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Oluşturuluyor." + threadName);
    }

    @Override
    public void run() {
        System.out.println("Çalıştırılıyor." + threadName);
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(threadName + ":" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread bitti : " + threadName );
    }
    public void start(){
        System.out.println("Thread nesnesi olusuyor.");
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }


}
