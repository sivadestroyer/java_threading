import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
        }finally{
            lock.unlock();
        }
    }
    void withdraw(int amount){
lock.lock();
if(balance>=amount){
    balance-=amount;
}else{
    System.out.println("insufficient balance in your account");
}
lock.unlock();
    }
}
class transaction implements Runnable {
    private bankaccount account;
    private transactiontype type;
    private int amount;
    public transaction(bankaccount account,transactiontype type,int amount){
        this.account = account;
        this.type = type;
        this.amount = amount;
    }


public class bankexecutor {
    public static void main(String[] args){
        bankaccount account = new bankaccount();

        
    }
    
}
