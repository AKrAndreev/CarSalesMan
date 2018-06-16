package Problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i <n ; i++) {

            String[] data = reader.readLine().split(" ");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name,age);

            persons.add(person);



        }

        persons.stream()
                .filter(a-> a.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.println(p.toString()));
    }
}
