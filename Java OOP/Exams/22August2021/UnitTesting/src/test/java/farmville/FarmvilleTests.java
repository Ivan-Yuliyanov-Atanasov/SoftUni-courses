package farmville;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FarmvilleTests {

    private Farm farm;
    private Animal animal;

    @Before
    public void setUp(){
        this.farm = new Farm("test", 10);
        this.animal = new Animal("Gosho", 6.66);
    }

    @Test
    public void testGetCorrectCount(){
        farm.add(animal);
        assertEquals(1,farm.getCount());
    }
    @Test
    public void testGetCorrectCapacity(){

        assertEquals(10,farm.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityIsFullThrowException(){
        Farm farm = new Farm("test1", 0);
        farm.add(animal);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfAnimalAlreadyExistsThrowException(){

        farm.add(animal);
        farm.add(animal);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityLessThanZeroThrowException(){

        Farm farm = new Farm("test", -1);
    }
    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull(){
        Farm farm = new Farm(null,10);
    }
    @Test(expected = NullPointerException.class)
    public void testIfNameIsWhitespaces(){

        Farm farm = new Farm("   ",10);
    }

    @Test
    public void testRemoveCorrectly(){
        farm.add(animal);
        farm.remove("Gosho");
        assertEquals(0,farm.getCount());
    }

    @Test
    public void testIfReturnsTheRightName(){

        assertEquals("test",farm.getName());
    }
}
