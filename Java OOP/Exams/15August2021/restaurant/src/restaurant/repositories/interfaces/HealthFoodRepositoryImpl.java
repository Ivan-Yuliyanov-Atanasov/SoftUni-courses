package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> foodEntities;

    public HealthFoodRepositoryImpl() {
        this.foodEntities = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        for (HealthyFood foodEntity : foodEntities) {
            if (foodEntity.getName().equals(name)){
                return foodEntity;
            }
        }
        return null;
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return this.foodEntities;
    }

    @Override
    public void add(HealthyFood entity) {
        this.foodEntities.add(entity);
    }
}
