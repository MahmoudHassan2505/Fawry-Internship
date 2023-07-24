public class Account {
    private int accountNumber;
    private String accountName;
    private float accountBalance;



    public Account(int accNum, String accName, float accBalance){
        setAccountNumber(accNum);
        setAccountName(accName);
        setAccountBalance(accBalance);

    }

    public void deposite(float amount){
        if(amount<0)
            throw new RuntimeException("unvalid Number");
        else
            setAccountBalance(getAccountBalance()+amount);

    }
    public void withdraw(float amount){
        if(amount<0)
            throw new RuntimeException("unvaild Number");
        else
            setAccountBalance(getAccountBalance()-amount);
    }

    public void setAccountBalance(float accountBalance) {
        if (accountBalance >= 0)
            this.accountBalance = accountBalance;
        else
            throw new RuntimeException("unvaild Number");
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName=" + getAccountName() +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", accountBalance=" + getAccountBalance() +
                '}';
    }
}
