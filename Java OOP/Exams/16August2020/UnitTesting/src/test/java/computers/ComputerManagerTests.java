package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerManagerTests {

    private Computer computer;
    private ComputerManager computerManager;

    @Before
    public void setUp(){
        computer = new Computer("Test", "Test", 666);
        computerManager = new ComputerManager();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerTest1(){
        computerManager.addComputer(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void addComputerTest2(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void addComputerTest3(){
        computerManager.addComputer(computer);
        Assert.assertEquals(1,computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerTest1(){
        computerManager.getComputer(null,"fdfdg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerTest2(){
        computerManager.getComputer("null",null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getComputerTest3(){
        computerManager.getComputer("null","null");
    }

    @Test
    public void getComputerTest4(){
        computerManager.addComputer(computer);
        Computer actual = computerManager.getComputer("Test", "Test");
        Assert.assertEquals(computer,actual);
    }

    @Test
    public void removeComputerTest1(){
        computerManager.addComputer(computer);
        Assert.assertEquals(1,computerManager.getCount());
        Computer actual = computerManager.removeComputer("Test", "Test");
        Assert.assertEquals(computer,actual);
        Assert.assertEquals(0,computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerByManufacturerTest1(){
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void getComputerByManufacturerTest2(){
        computerManager.addComputer(computer);
        Computer actual = computerManager.getComputersByManufacturer("Test").get(0);
        Assert.assertEquals(computer,actual);
    }
    // TODO: Test ComputerManager
}