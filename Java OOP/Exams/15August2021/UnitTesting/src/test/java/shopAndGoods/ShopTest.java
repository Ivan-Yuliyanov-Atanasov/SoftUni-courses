package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ShopTest {

    private Shop shop;
    private Goods goods;

    @Before
    public void setUp() {
        this.shop = new Shop();
        this.goods = new Goods("testName", "testCode");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test1() throws OperationNotSupportedException {
        shop.addGoods("test", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test2() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test3() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test4() {
        shop.removeGoods("test", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test5() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        Goods goods1 = new Goods("testName", "testCode");
        shop.removeGoods("Shelves1", goods1);
    }

    @Test
    public void Test6() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void Test7() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        Assert.assertEquals(goods, shop.getShelves().get("Shelves1"));
    }

    @Test
    public void Test8() throws OperationNotSupportedException {
        String actual = shop.addGoods("Shelves1", goods);
        String expected = "Goods: testCode is placed successfully!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Test9() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        String actual = shop.removeGoods("Shelves1", goods);
        String expected = "Goods: testCode is removed successfully!";
        Assert.assertEquals(expected, actual);
    }
}