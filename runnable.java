class name implements Runnable {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
public class runnable {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <8;i++){
            name obj=new name();
            Thread r =new Thread(obj);
            r.start();
        }

    }
}
