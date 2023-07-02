import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class banking{
    private int account = 1000;
    private  static Lock lock = new ReentrantLock();
    public int Balance(){
        return account;
    }
    synchronized void deposit(int amount){
        lock.lock();
        try{
            int newaccount = account + amount;
            account = newaccount;
        }
        
        finally {
            lock.unlock();
        }
    }
    synchronized void withdrawl(int amount){
        lock.lock();
        try{
            int newaccount = account - amount;
            account = newaccount;
        }
        finally {
            lock.unlock();
        }
    }
}

class bank implements Runnable{
    private banking account;
    private int amount;
    private boolean choice; 
    public bank(banking account,boolean choice, int amount){
        this.choice = choice;
        this.amount = amount;
        this.account=account;
    }
    public void run(){
        if (choice){
            account.deposit(amount);
        }
        else{
            account.withdrawl(amount);
        }
    }
}


public class bank1 {
    public static void main(String[] args) throws InterruptedException {
        // banking c = new banking();
        // bank t1 = new bank(c,choice:true,amount:10000);
        // t1.start();
        // bank t2 = new bank(c,choice:false,amount:10);
        // t2.start();
        ExecutorService executor = Executors.newCachedThreadPool();
        banking c = new banking();
        for(int i = 0; i < 100; i++){
            executor.execute(new bank(c,true,1000));
            executor.execute(new bank(c,false,900));
        }
        executor.shutdown();
        while(!executor.isTerminated()){
            System.out.println(+ c.Balance());
        }
    }
}