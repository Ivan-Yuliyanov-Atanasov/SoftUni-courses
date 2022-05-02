package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    private Spaceship spaceship;
    private Astronaut astronaut;
    @Before
    public void setUp(){
        astronaut = new Astronaut("Test", 666);
        spaceship = new Spaceship("Test",1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addTest1(){
        Spaceship spaceship1 = new Spaceship("sadsad",0);
        spaceship1.add(astronaut);
    }
    @Test(expected = NullPointerException.class)
    public void setNameTest1(){
        Spaceship spaceship1 = new Spaceship(null,1) ;
    }
    @Test(expected = NullPointerException.class)
    public void setNameTest2(){
        Spaceship spaceship1 = new Spaceship("   ",1) ;
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityTest1(){
        Spaceship spaceship1 = new Spaceship("sadsad",-1);
    }



    @Test(expected = IllegalArgumentException.class)
    public void addTest2(){
        Spaceship spaceship1 = new Spaceship("sadsad",5);
        spaceship1.add(astronaut);
        spaceship1.add(astronaut);
    }
    @Test
    public void removeTest1(){

        spaceship.add(astronaut);
        Assert.assertTrue(spaceship.remove("Test"));

    }

    @Test
    public void removeTest2(){
        Assert.assertFalse(spaceship.remove("Pesho"));

    }
    @Test
    public void addTest3(){
        spaceship.add(astronaut);
        Assert.assertEquals(1,spaceship.getCount());
    }

    @Test
    public void setNameTest3(){
        String name = spaceship.getName();
        Assert.assertEquals("Test",name);
    }

    @Test
    public void setCapacityTest2(){
        int capacity = spaceship.getCapacity();
        Assert.assertEquals(1,capacity);
    }

    @Test
    public void addTest4(){
        String name = astronaut.getName();
        Assert.assertEquals("Test",name);
    }

    @Test
    public void addTest5(){
        double oxygenInPercentage = astronaut.getOxygenInPercentage();

        Assert.assertEquals(666,oxygenInPercentage,0.01);
    }
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
}
