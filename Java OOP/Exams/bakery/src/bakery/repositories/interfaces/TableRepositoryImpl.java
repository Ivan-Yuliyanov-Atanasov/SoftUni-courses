package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {

    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return models;
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {

        for (Table table : models) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
