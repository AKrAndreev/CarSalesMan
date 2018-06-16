package CarSalesMan;

public class Car {

    private static int DEFAULT_WEIGHT = -1;
    private static String DEFAULT_COLOR = "n/a";
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
     this(model,engine,DEFAULT_WEIGHT,DEFAULT_COLOR);
    }

    public Car(String model, Engine engine, String color) {
        this(model,engine,DEFAULT_WEIGHT,color);
    }

    public Car(String model, Engine engine, int weight) {
        this(model,engine,weight,DEFAULT_COLOR);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        String we ="";
        int weig = this.weight;
        if (weig<0){
            we="n/a";
        }else {
            we=String.valueOf(weig);
        }
        return String.format("%s:%n%s:%n%s%nWeight: %s%nColor: %s%n",this.model
                ,this.engine.getModel()
                ,this.engine.toString()
                ,we
                ,this.color);
    }
}
