package org.example.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class AccountManageImplTest {

    private AccountManager accountManager;
    private Customer customer;

    @BeforeEach
    public void arrange(){
        //arrange
         accountManager = new AccountManagerImpl();
         customer = new Customer();
    }

    @Test
    public void deposit_Amount(){
        //act
        accountManager.deposit(customer,100);

        //assert
        assertThat(customer.getBalance()).isEqualTo(100);

    }

    @Test
    public void deposit_Amount_with_initial_money(){
        //act
        accountManager.deposit(customer,100);
        accountManager.deposit(customer,500);

        //assert
        assertThat(customer.getBalance()).isEqualTo(600);
    }

    @Test
    public void withdraw_With_EnoughMoney(){
        //arrange
        accountManager.deposit(customer,5000);

        //act
        String result = accountManager.withdraw(customer,1000);

        //assert
        assertThat(result).isEqualTo("success");

    }

    @Test
    public void Withdraw_notEnoughMoney_NotAllowedCredit(){
        //arrange
        accountManager.deposit(customer,5000);
        customer.setCreditAllowed(false);

        //act
        String result = accountManager.withdraw(customer,8000);

        //assert
        assertThat(result).isEqualTo("insufficient account balance");

    }

    @Test
    public void withdraw_notEnoughMoney_AllowedCredit_ExceedMax_NotVIP(){
        //arrange
        accountManager.deposit(customer,5000);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        //act
        String result = accountManager.withdraw(customer,6500);

        //assert
        assertThat(result).isEqualTo("maximum credit exceeded");


    }

    @Test
    public void withdraw_notEnoughMoney_AllowedCredit_ExceedMax_IsVIP(){
        //arrange
        accountManager.deposit(customer,5000);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        //act
        String result = accountManager.withdraw(customer,6500);

        //assert
        assertThat(result).isEqualTo("success");


    }

    @Test
    public void Withdraw_notEnoughMoney_AllowedCredit_NotExceedMax_NotVIP(){
        //arrange
        accountManager.deposit(customer,5000);
        customer.setVip(false);
        customer.setCreditAllowed(true);

        //act
        String result = accountManager.withdraw(customer,5500);

        //assert
        assertThat(result).isEqualTo("success");


    }
}
