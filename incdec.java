class counter{
    public int count;
    public counter(){
        count=0;
    }
    public synchronized void increment(){
        count++;
        System.out.println(count);
    }
    synchronized void decrement(){
        count--;
        System.out.println(count);
    }
}
class callcount extends Thread{
    private counter count;
    public callcount(counter count){
        this .count =count;
        
    }
    public void run() {
        for(int i=0; i<1000; i++){
        count.increment();
        count.decrement();
        }
    }
}
public class incdec {
    public static void main (String[] args) throws Exception{
        counter c = new counter();
        callcount t1 = new callcount(c);
        callcount t2 = new callcount(c);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(c.count);
        

    }
    
}
