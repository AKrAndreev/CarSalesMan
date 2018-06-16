package CarSalesMan;

public class Engine {
    private static String DEFAULT_EFFICIENCY="n/a";
    private static int DEFAULT_DISPLACEMENT=-1;
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine() {
    }

    public Engine(String model, int power) {
        this(model,power,DEFAULT_DISPLACEMENT,DEFAULT_EFFICIENCY);
    }

    public Engine(String model, int power, int displacement) {
        this(model,power,displacement,DEFAULT_EFFICIENCY);
    }

    public Engine(String model, int power, String efficiency) {
        this(model,power,DEFAULT_DISPLACEMENT,efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }


    public String getModel() {
        return model;
    }

    public int getDisplacement() {
        return displacement;
    }

    @Override
    public String toString() {

        int displ = getDisplacement();
        String dis = "";
        if (displ<0){
            dis="n/a";
        }else {
            dis=String.valueOf(displ);
        }
        return  String.format("Power: %d%nDisplacement: %s%nEfficiency: %s",this.power,dis,this.efficiency);
    }
}
