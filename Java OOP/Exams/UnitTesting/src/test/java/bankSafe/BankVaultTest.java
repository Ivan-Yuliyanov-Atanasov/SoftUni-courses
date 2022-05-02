package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {
    private BankVault bankVault;
    private Item item;

    @Before
    public void setUp() {
        item = new Item("Pesho", "1");
        bankVault = new BankVault();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemTest1() throws OperationNotSupportedException {

        bankVault.addItem("VVV", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addItemTest2() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("A1", item);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addItemTest3() throws OperationNotSupportedException {
        bankVault.addItem("A1", item);
        bankVault.addItem("B1", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemTest1() throws OperationNotSupportedException {

        bankVault.removeItem("VVV", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemTest2() throws OperationNotSupportedException {


        bankVault.removeItem("A1", item);
    }

    @Test
    public void removeItemTest3() throws OperationNotSupportedException {

        bankVault.addItem("A1", item);
        Assert.assertEquals(item, bankVault.getVaultCells().get("A1"));
        bankVault.removeItem("A1", item);
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
    }
    @Test
    public void removeItemTest4() throws OperationNotSupportedException {

        bankVault.addItem("A1", item);

        String actual = bankVault.removeItem("A1", item);
        String expected = "Remove item:1 successfully!";
        Assert.assertEquals(expected,actual);
    }
    //TODO: Write your tests here

}