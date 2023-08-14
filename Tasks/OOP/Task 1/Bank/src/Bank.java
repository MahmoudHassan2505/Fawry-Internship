import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private ArrayList<Account>accounts;
    public Bank(){
        accounts=new ArrayList<Account>();
    }
    public void addAccount(String accName,float accBalance) {
        accounts.add(new Account(generateAccountNumber(),accName,accBalance));

    }
    public void deposit(String accNumber,float amount){
        findAccount(accNumber).deposite(amount);
    }
    public void withdraw(String accNumber,float amount){
        findAccount(accNumber).withdraw(amount);
    }

    public void displayBalance(String accNumber){
        System.out.println(findAccount(accNumber).getAccountBalance());
    }

    public Account findAccount(String accNumber){
        for (Account account:accounts) {
            if (account.getAccountNumber().equals(accNumber))
                return account;
        }
        throw new RuntimeException("Can't Find Account");
    }
    public String generateAccountNumber(){
        String accNumber ="2505 ";
        Random random = new Random();

        for (int i=0;i<4;i++){
            accNumber += Integer.toString(random.nextInt(10));
        }

        System.out.println("generated Number is :" + accNumber);

        return accNumber;
    }


}
