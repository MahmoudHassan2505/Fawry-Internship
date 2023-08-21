package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;


 class StoreTest {
    @Test
    void successfullBuy(){
        //arrange
        Customer customer = new Customer();

        AccountManager accountManager =Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(eq(customer),anyInt())).thenReturn("success");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(5);


        //act
        myStore.buy(product,customer);

        //assert
        Assertions.assertEquals(4,product.getQuantity());

    }

    @Test()
    void outOfStock(){
        //arrange
        Customer customer = new Customer();

        AccountManager accountManager =Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(eq(customer),anyInt())).thenReturn("success");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(0);


        //act
        Assertions.assertThrows(RuntimeException.class,()->myStore.buy(product,customer));


    }

    @Test()
    void whenWithdrawFails(){
        //arrange
        Customer customer = new Customer();

        AccountManager accountManager =Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(eq(customer),anyInt())).thenReturn("fails");

        MyStore myStore = new MyStore(accountManager);

        Product product = new Product();
        product.setQuantity(5);


        //act
        Assertions.assertThrows(RuntimeException.class,()->myStore.buy(product,customer));

    }
    @Test()
    void whenWithdrawFailsAndQuantitynotChanged(){
        //arrange
        Customer customer = new Customer();

        AccountManager accountManager =Mockito.mock(AccountManager.class);
        when(accountManager.withdraw(eq(customer),anyInt())).thenReturn("fails");

        Product product = new Product();
        product.setQuantity(5);


        //act
        Assertions.assertEquals(5,product.getQuantity());

    }


}
