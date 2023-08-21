package org.example.account;

public class AccountManagerImpl implements AccountManager {
    private static int MAX_CREDIT = 1000;
    @Override
    public String deposit(Customer customer, int amount) {
        if(amount<0)
            return "Amount can't be negative";
        else {
            customer.setBalance(customer.getBalance() + amount);
            return "success";
        }
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = customer.getBalance() - amount;

        if (expectedBalance < 0) {
            if (!customer.isCreditAllowed()) {
                return "insufficient account balance";
            } else if (Math.abs(expectedBalance)> MAX_CREDIT && !customer.isVip()) {
                return "maximum credit exceeded";
            }
        }
        customer.setBalance(expectedBalance);
        return "success";
    }
}
