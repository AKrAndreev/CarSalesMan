package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static int DEFAULT_BADGES=0;
    String name;
    int bagdes;
    List<Pokemon> pokemons=new ArrayList<>();


    public Trainer(String name, Pokemon pokemon) {
    this(name,DEFAULT_BADGES,pokemon);
    }

    public Trainer(String name, int bagdes, Pokemon pokemon) {
        this.name = name;
        this.bagdes = bagdes;
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void setPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setBagdes(int bagdes) {
        this.bagdes +=bagdes;
    }

    public int getBagdes() {
        return bagdes;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.name,this.bagdes,this.pokemons.size());
    }
}
