package StrategyPattern_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> byAge = new TreeSet<>(new ComparatorByAge());
        TreeSet<Person> byName = new TreeSet<>(new ComparatorByName());

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = reader.readLine().split(" ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            byAge.add(person);
            byName.add(person);

        }
        byName.forEach(p -> System.out.println(p.getName() + " " +  p.getAge()));
        byAge.forEach(p -> System.out.println(p.getName() + " " +  p.getAge()));
    }
}
