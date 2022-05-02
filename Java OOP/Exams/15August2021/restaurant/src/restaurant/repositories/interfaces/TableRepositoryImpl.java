package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> tableEntities;

    public TableRepositoryImpl() {
        this.tableEntities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return this.tableEntities;
    }

    @Override
    public void add(Table entity) {
        this.tableEntities.add(entity);

    }

    @Override
    public Table byNumber(int number) {

        for (Table tableEntity : tableEntities) {
            if (tableEntity.getTableNumber() == number) {
                return tableEntity;
            }
        }
        return null;

    }
}
