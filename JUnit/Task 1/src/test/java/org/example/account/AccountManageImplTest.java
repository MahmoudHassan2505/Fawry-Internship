package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountManageImplTest {





    @Test
    public void withEnoughMoney(){
        //arrange
        AccountManager accountManager =new AccountManagerImpl();
        Customer customer=Mockito.mock(Customer.class);
        when(customer.getBalance()).thenReturn(5000);

        //act
        String result = accountManager.withdraw(customer,1000);

        //assert
        Assertions.assertEquals("success",result);

    }

    @Test
    public void notEnoughMoneyAndNotAllowedCredit(){
        //arrange
        Customer customer=Mockito.mock(Customer.class);
        AccountManager accountManager =new AccountManagerImpl();
        when(customer.getBalance()).thenReturn(5000);
        when(customer.isCreditAllowed()).thenReturn(false);

        //act
        String result = accountManager.withdraw(customer,8000);

        //assert
        Assertions.assertEquals("insufficient account balance",result);

    }

    @Test
    public void notEnoughMoney_AllowedCredit_ExceedMax_NotVIP(){
        //arrange
        Customer customer=Mockito.mock(Customer.class);
        AccountManager accountManager =new AccountManagerImpl();
        when(customer.getBalance()).thenReturn(5000);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(false);


        //act
        String result = accountManager.withdraw(customer,6500);

        //assert
        Assertions.assertEquals("maximum credit exceeded",result);


    }

    @Test
    public void notEnoughMoney_AllowedCredit_ExceedMax_IsVIP(){
        //arrange
        Customer customer=Mockito.mock(Customer.class);
        AccountManager accountManager =new AccountManagerImpl();
        when(customer.getBalance()).thenReturn(5000);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(true);


        //act
        String result = accountManager.withdraw(customer,6500);

        //assert
        Assertions.assertEquals("success",result);


    }

    @Test
    public void notEnoughMoney_AllowedCredit_NotExceedMax_NotVIP(){
        //arrange
        Customer customer=Mockito.mock(Customer.class);
        AccountManager accountManager =new AccountManagerImpl();
        when(customer.getBalance()).thenReturn(5000);
        when(customer.isCreditAllowed()).thenReturn(true);
        when(customer.isVip()).thenReturn(false);


        //act
        String result = accountManager.withdraw(customer,5500);

        //assert
        Assertions.assertEquals("success",result);


    }
}
