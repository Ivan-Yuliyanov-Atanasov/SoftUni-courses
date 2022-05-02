package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    private Hero hero;
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.hero = new Hero("testName", 99);
        this.heroRepository = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void test1_create() {

        Hero hero = null;
        heroRepository.create(hero);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test2_create() {
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    @Test(expected = NullPointerException.class)
    public void test1_remove() {


        heroRepository.remove(null);
    }
    @Test(expected = NullPointerException.class)
    public void test2_remove() {


        heroRepository.remove("   ");
    }
    @Test
    public void test3_remove() {

        assertFalse(heroRepository.remove("Pesho"));
        heroRepository.create(hero);
        assertTrue(heroRepository.remove("testName"));
    }

    @Test
    public void test_getHeroWithHighestLevel() {

        Hero hero1 = new Hero("testName2",1);
        heroRepository.create(hero);
        heroRepository.create(hero1);

        assertEquals(hero,heroRepository.getHeroWithHighestLevel());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void test_getList() {


        heroRepository.getHeroes().clear();
    }
    @Test
    public void test_getHero() {

        Hero hero1 = new Hero("testName2",1);
        heroRepository.create(hero);
        heroRepository.create(hero1);

        assertEquals(hero,heroRepository.getHero("testName"));
    }
    @Test
    public void test1_getHero() {



        assertNull(heroRepository.getHero("testName"));
    }
    @Test
    public void test2_getHero() {



        assertNull(heroRepository.getHeroWithHighestLevel());
    }
    @Test
    public void test_getCount() {

        Hero hero1 = new Hero("testName2",1);
        heroRepository.create(hero);
        heroRepository.create(hero1);

        assertEquals(2,heroRepository.getCount());
    }
}
