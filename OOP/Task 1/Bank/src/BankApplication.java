public class BankApplication {

    public static void main(String[] args) {
Bank b1 =new Bank();
b1.addAccount(new savingsAccount(2190210,"Ag",2500,0.3f));
b1.deposit(0,100);
b1.displayBalance(0);
    }
}
