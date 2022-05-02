package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {

    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood food : models) {
            if(food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return models;
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);
    }
}
