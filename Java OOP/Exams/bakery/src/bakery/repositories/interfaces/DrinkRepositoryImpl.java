package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository<Drink>{

    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {

        for (Drink drink : models) {
            if(drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)){
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return models;
    }

    @Override
    public void add(Drink drink) {
this.models.add(drink);
    }
}
