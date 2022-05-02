package viceCity.models.guns;

public class Pistol extends BaseGun{


    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {

        int countInBarrel = getBulletsPerBarrel() - 1;
        if (countInBarrel < 0){
            int totalBullets = getTotalBullets() - 10;
            if(totalBullets < 0){
                setCanFire(false);
                return 0;
            }
            setBulletsPerBarrel(9);
            setTotalBullets(totalBullets);
            return 1;
        }

        setBulletsPerBarrel(countInBarrel);
        return 1;
    }
}
