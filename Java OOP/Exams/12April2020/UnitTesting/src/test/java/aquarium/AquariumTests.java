package aquarium;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    private Aquarium aquarium;
    private Fish fish1;
    private Fish fish2;
    @Before
    public void setUp(){
        this.aquarium = new Aquarium("testName",10);
        this.fish1 = new Fish("fish1Name");
        this.fish2 = new Fish("fish2Name");
    }

    @Test(expected = NullPointerException.class)
    public void testNullName(){
        this.aquarium = new Aquarium(null,10);
    }
    @Test(expected = NullPointerException.class)
    public void testEmptyName(){
        this.aquarium = new Aquarium("   ",10);
    }

    @Test
    public void testName(){
        assertEquals("testName",aquarium.getName());
    }
    @Test
    public void testCapacity(){
        assertEquals(10,aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroCapacity(){
        this.aquarium = new Aquarium("test",-1);
    }

    @Test
    public void testCount(){
        assertEquals(0,aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFishEx(){
        this.aquarium = new Aquarium("test",0);
        aquarium.add(fish1);
    }

    @Test
    public void addFish(){

        aquarium.add(fish1);
        assertEquals(1,aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNullFish(){

        aquarium.remove("fish1");
    }

    @Test
    public void remove(){

        aquarium.add(fish1);
        aquarium.remove("fish1Name");
        assertEquals(0,aquarium.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void sellNullFish(){

        aquarium.sellFish("fish1");
    }
    @Test
    public void sellFish(){

        aquarium.add(fish1);
        assertTrue(fish1.isAvailable());
        aquarium.sellFish("fish1Name");
        assertFalse(fish1.isAvailable());

    }

    @Test
    public void testReport(){
        aquarium.add(fish1);
        aquarium.add(fish2);
        String expected = "Fish available at testName: fish1Name, fish2Name";
        assertEquals(expected, aquarium.report());
    }
}

