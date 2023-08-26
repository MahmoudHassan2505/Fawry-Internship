package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

class StoreTest {

    private Customer customer;
    private AccountManager accountManager;

    @BeforeEach
    void arrange() {
        customer = new Customer();
        accountManager = Mockito.mock(AccountManager.class);

    }

    @Test
    void successfullBuy() {
        // arrange
        when(accountManager.withdraw(eq(customer), anyInt())).thenReturn("success");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(5);

        // act
        myStore.buy(product, customer);

        // assert
        Assertions.assertEquals(4, product.getQuantity());

    }

    @Test()
    void outOfStock() {
        // arrange
        when(accountManager.withdraw(eq(customer), anyInt())).thenReturn("success");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(0);

        // act,assert
        Assertions.assertThrows(RuntimeException.class, () -> myStore.buy(product, customer));

    }

    @Test()
    void whenWithdrawFails() {
        // arrange
        when(accountManager.withdraw(eq(customer), anyInt())).thenReturn("fails");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(5);

        // act, Assert
        Assertions.assertThrows(RuntimeException.class, () -> myStore.buy(product, customer));

    }

    @Test()
    void whenWithdrawFailsAndQuantitynotChanged() {
        // arrange
        when(accountManager.withdraw(eq(customer), anyInt())).thenReturn("fails");

        Product product = new Product();
        product.setQuantity(5);

        // act,assert
        Assertions.assertEquals(5, product.getQuantity());

    }

}
// Notes
// AssertJ
// soft Assertion
// @BeforeAll