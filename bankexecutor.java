import java.util.concurrent.*;
import java.util.concurrent.locks.*;
 class bankaccount{
    private int balance;
    private Lock lock;
    public bankaccount(){
        balance=0;
        lock= new ReentrantLock();
    }
    void deposit(int amount){
        lock.lock();
        try{
            balance+=amount;
            System.out.println("deposite"+balance);
        }finally{
            lock.unlock();
        }
    }
    void withdraw(int amount){
lock.lock();
if(balance>=amount){
    balance-=amount;
    System.err.println("withdraw"+balance);
}else{
    System.out.println("insufficient balance in your account");
}
lock.unlock();
    }
int getBalance(){
    return balance;


}
 }
class transaction implements Runnable {
    private bankaccount account;
    private Boolean type;
    private int amount;
    public transaction(bankaccount account,Boolean type,int amount){
        this.account = account;
        this.type = type;
        this.amount = amount;
    }
    public void run(){
        if (type){
            account.deposit(amount);
    } else{
            account.withdraw(amount);

    }
        }
    }

public class bankexecutor {
    public static void main(String[] args) throws InterruptedException{
        bankaccount account = new bankaccount();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++){
        executor.execute(new transaction(account,true,100));
        executor.execute(new transaction(account,false,50));
    }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);


     System.out.println("Final Balance: " + account.getBalance());
 
}
}
