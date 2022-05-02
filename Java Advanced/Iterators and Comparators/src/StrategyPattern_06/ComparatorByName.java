package StrategyPattern_06;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getName().length() - p2.getName().length();
        if(result == 0){
            result = Character.toLowerCase(p1.getName().charAt(0)) - Character.toLowerCase(p2.getName().charAt(0)) ;
        }
        return result;
    }
}
