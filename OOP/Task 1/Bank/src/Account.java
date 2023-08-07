public class Account {
    private String accountNumber;
    private String accountName;
    private float accountBalance;



    public Account(String accNum, String accName, float accBalance){
        setAccountNumber(accNum);
        setAccountName(accName);
        setAccountBalance(accBalance);

    }

    public void deposite(float amount){
        negativeNumber(amount);
        setAccountBalance(getAccountBalance()+amount);

    }
    public void withdraw(float amount){
        negativeNumber(amount);
        setAccountBalance(getAccountBalance()-amount);
    }

    public void setAccountBalance(float accountBalance) {
        negativeNumber(accountBalance);
        this.accountBalance = accountBalance;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
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
    private void negativeNumber(float Number){
        if(Number<0)
            throw new RuntimeException("inCompleted operation because Amount is Negative");
    }
}
