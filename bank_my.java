class banking {
    private int account;
    public banking(){
        account=1000;
    }
    synchronized void deposit(int money){
        account+=money;
        System.out.println(account);  // ctrl shift L to modify all same variables

    }
    synchronized void withdraw(int money){
        if (account>=money){
            account-=money;
            System.out.println(account);
        }
        else{
            System.out.println("no money left");
        }
    }
}

class access1 extends Thread{
    private banking bank;
    private int money;
    private boolean choice;
    public access1(banking bank,int money,boolean choice){
        this.bank=bank;
        this.money=money;
        this.choice=choice;
    }
    public void run(){
        if (choice){
            bank.deposit(money);
        }
        else{
            bank.withdraw(money);
        }
    }

    }

public class bank_my {
    public static void main(String[] args){
        banking c = new banking();
        access1 t1 = new access1(c,90,true);
        access1 t2 = new access1(c,1000,false);
        t1.start();
        t2.start();
    }
}