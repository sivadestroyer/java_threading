class banking{
    private double occount;
    public banking(){
        occount=1000;
    }
    synchronized void deposite(double money){
        occount+=money;
        System.out.println(occount);
    }
    synchronized void withdraw (double money){
        if (occount>=money){
            occount-=money;
             System.out.println(occount);
        }
        else {
            System.out.println("you money is low");
        }
    }
}
class access implements Runnable{
    
    private banking occount;
    private double money;
    private boolean choice;
    public access(banking occount , boolean choice,double money){
        this.occount=occount;
        this.choice=choice;
        this.money=money;
    }
    public void run ()
    {
    if (choice){
        
        occount.deposite(money);
    }
    else{
        occount.withdraw(money);
    }
}
}
public class bank {
    public static void main(String[] args){
        banking c = new banking();
        access t1 = new access(c,true,1000000);
        access t2 = new access(c,false,100000);
        Thread t1_ = new Thread(t1);
        Thread t2_ = new Thread(t2);
        t1_.start();
        t2_.start();


    }
}
