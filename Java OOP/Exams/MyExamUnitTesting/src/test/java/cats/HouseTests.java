package cats;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTests {


    private Cat cat;

    private House house;

    @Before
    public void setUp() {
        this.cat = new Cat("Test");
        this.house = new House("Test", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull() {
        House farm = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsWhitespaces() {
        House farm = new House("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityLessThanZeroThrowException() {

        House farm = new House("test", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityIsFullThrowException() {
        House farm = new House("test1", 0);
        farm.addCat(cat);
    }

    @Test
    public void testAddCat() {
        house.addCat(cat);
        assertEquals(1, house.getCount());

    }

    @Test
    public void testRemoveCorrectly() {
        house.addCat(cat);
        house.removeCat("Test");
        assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void RemoveCat() {

        house.removeCat("Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void CatForSaleTest1() {

        house.catForSale("Pesho");
    }

    @Test
    public void CatForSaleTest2() {
        house.addCat(cat);
        assertTrue(cat.isHungry());
        house.catForSale("Test");
        assertFalse(cat.isHungry());

    }

    @Test
    public void getStatistics(){
        house.addCat(cat);
        String expected = "The cat Test is in the house Test!";
        String actual = house.statistics();
        assertEquals(expected,actual);
    }
}
