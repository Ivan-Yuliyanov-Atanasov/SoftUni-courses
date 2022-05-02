package hotel;


import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(person);
        }
    }

    public int getCount() {
        return this.roster.size();
    }

    public boolean remove(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        for (Person currentPerson : this.roster) {
            if (currentPerson.getName().equals(name) && currentPerson.getHometown().equals(hometown)) {
                return currentPerson;
            }

        }
        return null;
    }

    public String getStatistics() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("The people in the hotel %s are:", this.name)).append(System.lineSeparator());
        for (Person person : roster) {
            report.append(person).append(System.lineSeparator());

        }
        return report.toString();
    }
}
