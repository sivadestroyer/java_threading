class name extends Thread {
    public void run(){
        System.out.println("Thread"+ Thread.currentThread().getName());
    }
}
public class create_thread {
    public static void main(String[] args){
        for(int i=0; i<8;i++){
            name obj = new name(); 
            obj.start();

        }

    }
}