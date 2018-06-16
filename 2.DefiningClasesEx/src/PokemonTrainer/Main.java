package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        List<Trainer> trainers = new LinkedList<>();

        while (!"Tournament".equals(line)){
            String [] data = line.split(" ");
            String trainerName = data[0];
            String pokemantName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemantName,element,health);

            Trainer trainer = new Trainer(trainerName,pokemon);
            if (trainerExist(trainers,trainer)){

                updateTrainer(trainers,pokemon,trainerName);
            }else {
                trainers.add(trainer);
            }
            line=reader.readLine();
        }

        line = reader.readLine();
        while (!"End".equals(line)){

            switch (line){
                case "Fire":
                    checkElem(trainers,line);
                    break;
                case "Water":
                    checkElem(trainers,line);
                    break;
                case "Electricity":
                    checkElem(trainers,line);
                    break;
            }

            line = reader.readLine();
        }

        trainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getBagdes).reversed())
                .forEach(t-> System.out.println(t.toString()));



    }

    private static void checkElem(List<Trainer> trainers, String line) {

        for (Trainer trainer : trainers) {

            boolean flag = false;
            List<Pokemon> tempPokemons = trainer.getPokemons();

            for (Pokemon tempPokemon : tempPokemons) {
                if (tempPokemon.getElement().equals(line)){
                    flag=true;

                    trainer.setBagdes(1);
                    break;
                }
            }
            if (flag){
                continue;
            }else {
                for (Pokemon tempPokemon : tempPokemons) {
                    tempPokemon.setHealth(10);

                }

                tempPokemons.removeIf(p->{
                    return p.getHealth()<=0;
                });


            }

        }




    }

    private static void updateTrainer(List<Trainer> trainers, Pokemon pokemon, String trainerName) {
        for (Trainer trainer : trainers) {

            if (trainerName.equals(trainer.name)){
                trainer.setPokemons(pokemon);
            }
        }

    }

    private static boolean trainerExist(List<Trainer> trainers, Trainer trainer) {

        String currName = trainer.getName();
        for (Trainer trainer1 : trainers) {
            String tempName = trainer1.name;
            if (tempName.equals(currName)){
                return true;

            }
        }
        return false;
    }
}
