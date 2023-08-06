public class BankApplication {

    public static void main(String[] args) {
Bank b1 =new Bank();
b1.addAccount(new savingsAccount(211902109,"Mahmoud",2500,0.3f));
b1.deposit(211902109,100);
b1.displayBalance(211902109);
    }
}
