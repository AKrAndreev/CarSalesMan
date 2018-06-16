package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyres tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyres tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format("%s",this.model);
    }
}
