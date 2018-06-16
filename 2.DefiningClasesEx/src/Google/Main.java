package Google;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> persons = new ArrayList<>();
        String line = reader.readLine();
        while (!"End".equals(line)){

            String[] data =line.split(" ");
            String personName = data[0];
            String className = data[1];

            Person person = new Person();

            boolean flag = true;
            for (Person person1 : persons) {
                if (person1.getName().equals(personName)){
                    person=person1;
                    flag = false;
                    break;
                }
            }

            if (flag){

                person.setName(personName);
                persons.add(person);
            }
            switch (className){
                case "company":
                    String compName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);

                    Company company = new Company(compName,department,salary);
                    person.setCompany(company);

                    break;
                case "pokemon":
                    String pokName = data[2];
                    String type = data  [3];
                    Pokemon pokemon = new Pokemon(pokName,type);
                    person.setPokemon(pokemon);

                    break;
                case "parents":
                    String parName = data[2];
                    String birthday = data  [3];
                    Parents parents = new Parents(parName,birthday);

                    person.setParents(parents);

                    break;
                case "children":
                    String chName = data[2];
                    String chBirthday = data  [3];

                    Children children = new Children(chName,chBirthday);
                    person.setChildren(children);

                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeet = Integer.parseInt(data[3]);

                    Car car = new Car(carModel,carSpeet);
                    person.setCar(car);
                    break;
            }
            line = reader.readLine();
        }

        line = reader.readLine();

        for (Person person : persons) {
            if (person.getName().equals(line)){

                System.out.println(person.getName());
                System.out.println("Company:");
                try {
                    System.out.printf("%s %s %.2f%n",person.getCompany().getName(),person.getCompany().getDepartment(),
                            person.getCompany().getSalary());
                }catch (Exception e){

                }


                System.out.println("Car:");
                try {
                    System.out.printf("%s %d%n",person.getCar().getModel(),person.getCar().getSpeed());
                }catch (Exception e){

                }
                System.out.println("Pokemon:");

                try {
                    List<Pokemon> tempPok = person.getPokemons();


                    for (Pokemon pokemon : tempPok) {
                        System.out.printf("%s %s%n",pokemon.getName(),pokemon.getType());
                    }
                }catch (Exception e){

                }

                System.out.println("Parents:");

                try {
                    List<Parents> tempPar = person.getParents();

                    for (Parents parents : tempPar) {
                        System.out.printf("%s %s%n",parents.getName(),parents.getBirthday());
                    }
                }catch (Exception e){

                }


                System.out.println("Children:");
                try {
                    List<Children> tempList = person.getChildren();


                    for (Children children : tempList) {
                        System.out.printf("%s %s%n",children.getName(),children.getBirthday());
                    }
                }catch (Exception e){

                }


            }
        }
    }
}
