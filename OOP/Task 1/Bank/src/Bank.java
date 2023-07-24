import java.util.ArrayList;

public class Bank {

    private ArrayList<Account>accounts;
    public Bank(){
        accounts=new ArrayList<Account>();
    }
    public void addAccount(Account a) {
        accounts.add(a);

    }
    public void deposit(int num,float amount){
     if (num>= accounts.size())
         throw new RuntimeException("User Not Found");
     else
         accounts.get(num).deposite(amount);
    }
    public void withdraw(int num,float amount){
        if (num>= accounts.size())
            throw new RuntimeException("User Not Found");
        else
            accounts.get(num).withdraw(amount);    }
    public void displayBalance(int num){
        if (num>= accounts.size())
        throw new RuntimeException("User Not Found");
        else
            System.out.println(accounts.get(num).getAccountBalance());    }
}
