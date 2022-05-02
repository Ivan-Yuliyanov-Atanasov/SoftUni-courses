package bankSafe;


import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {
//    private BankVault bankVault;
//    private Item item;
//    @Before
//    public void setUp(){
//        item = new Item("Pesho","1");
//        bankVault = new BankVault();
//    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemTest1() throws OperationNotSupportedException {
        Item item = new Item("Pesho","1");
        BankVault bankVault = new BankVault();
        bankVault.addItem("VVV",item);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void addItemTest2() throws OperationNotSupportedException {
//        bankVault.addItem(null,item);
//    }

    //TODO: Write your tests here

}