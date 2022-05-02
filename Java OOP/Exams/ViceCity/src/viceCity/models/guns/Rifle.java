package viceCity.models.guns;

public class Rifle extends BaseGun{

    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        int countInBarrel = getBulletsPerBarrel() - 5;
        if (countInBarrel < 0){
            int totalBullets = getTotalBullets() - 50;
            if(totalBullets < 0){
                setCanFire(false);
                return 0;
            }
            setBulletsPerBarrel(50);
            setTotalBullets(totalBullets);
            return 5;
        }

        setBulletsPerBarrel(countInBarrel);
        return 5;
    }
}
