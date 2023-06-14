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
class access extends Thread{
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
        t1.start();
        t2.start();


    }
}
