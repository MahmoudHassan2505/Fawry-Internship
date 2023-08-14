public class savingsAccount extends Account{
   private float interestRate;

   public savingsAccount(String accNum, String accName, float accBalance,float interestRate){
       super(accNum,accName,accBalance);
       setInterestRate(interestRate);
   }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        if(interestRate>1||interestRate<0)
            throw new RuntimeException("Rate should be between 0 to 1");
        this.interestRate=interestRate;
    }
    public float accountInterest(){
       return getAccountBalance()*getInterestRate();
   }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountName=" + getAccountName() +
                ", accountNumber='" + getAccountNumber() + '\'' +
                ", accountBalance=" + getAccountBalance() +
                ", interestRate=" + getInterestRate() +
                ", interestAmount=" + accountInterest() +
                '}';
    }
}
