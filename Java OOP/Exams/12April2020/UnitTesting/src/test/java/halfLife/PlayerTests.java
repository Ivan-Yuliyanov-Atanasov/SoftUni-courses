package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

    private Gun gun;
    private Player player;

    @Before
    public void setUp(){
        gun = new Gun("Makavor",10);
        player = new Player("Test",10);
    }

    @Test(expected = NullPointerException.class)
    public void setUsernameTest1(){
        Player player1 = new Player(null,2);
    }

    @Test(expected = NullPointerException.class)
    public void setUsernameTest2(){
        Player player1 = new Player("   ",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHealthTest1(){
        Player player1 = new Player("hthth",-2);
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageTest1(){

        player.takeDamage(10);
        player.takeDamage(10);
    }

    @Test
    public void takeDamageTest2(){

        player.takeDamage(11);
        Assert.assertEquals(0,player.getHealth());
    }

    @Test
    public void takeDamageTest3(){

        player.takeDamage(2);
        Assert.assertEquals(8,player.getHealth());
    }
    @Test(expected = NullPointerException.class)
    public void addGunTest1(){
        player.addGun(null);
    }

    @Test
    public void addGUnsTest2(){

        player.addGun(gun);
        Assert.assertEquals(gun,player.getGuns().get(0));
    }
@Test
    public void removeGunTest1(){

        player.addGun(gun);
        Assert.assertEquals(gun,player.getGuns().get(0));
        player.removeGun(gun);
        Assert.assertEquals(0,player.getGuns().size());
    }

    @Test
    public void getGunTest1(){

        player.addGun(gun);
        Assert.assertEquals(gun,player.getGun("Makavor"));

    }



    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
}
