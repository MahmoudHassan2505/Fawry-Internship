import java.util.ArrayList;

public class Bank {

    private ArrayList<Account>accounts;
    public Bank(){
        accounts=new ArrayList<Account>();
    }
    public void addAccount(Account a) {
        accounts.add(a); 

    }
    public void deposit(int accountnubmer,float amount){
        int index=getindex(accountnubmer);

     if (index> accounts.size()) throw new RuntimeException("User Not Found3"+index);
     accounts.get(index).deposite(amount);
    }
    public void withdraw(int accountnubmer,float amount){
        int num=getindex(accountnubmer);
        if (num>= accounts.size()) throw new RuntimeException("User Not Found2");
        accounts.get(num).withdraw(amount);    }

    public void displayBalance(int accountnubmer){
        int num=getindex(accountnubmer);
        if (num>= accounts.size()) throw new RuntimeException("User Not Found1");
        System.out.println(accounts.get(num).getAccountBalance());    }
        public int getindex(int num){
            for(int i=0;i<accounts.size();i++){
                if(accounts.get(i).getAccountNumber()==num) return i;
            }
            return 100000;

            
        }
}
