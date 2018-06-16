package Google;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Parents> parents = new ArrayList<>();
    private List<Children> children =new ArrayList<>();
    private Car car;

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setParents(Parents parents) {
        this.parents.add(parents);
    }

    public void setChildren(Children children) {
        this.children.add(children);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }
}
