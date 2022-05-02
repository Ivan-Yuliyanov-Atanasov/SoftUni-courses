package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private Collection<Beverages> beverageEntities;

    public BeverageRepositoryImpl() {
        this.beverageEntities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        for (Beverages beverageEntity : beverageEntities) {
            if(beverageEntity.getName().equals(drinkName) && beverageEntity.getBrand().equals(drinkBrand)){
                return beverageEntity;
            }
        }
        return null;
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return this.beverageEntities;
    }

    @Override
    public void add(Beverages entity) {
        this.beverageEntities.add(entity);
    }
}
