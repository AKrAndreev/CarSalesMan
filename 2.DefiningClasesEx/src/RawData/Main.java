package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <n ; i++) {

            String[] data = reader.readLine().split(" ");

            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            double tyrePress1 = Double.parseDouble(data[5]);
            int tyreAge1 = Integer.parseInt(data[6]);
            double tyrePress2 = Double.parseDouble(data[7]);
            int tyreAge2 = Integer.parseInt(data[8]);
            double tyrePress3 = Double.parseDouble(data[9]);
            int tyreAge3 = Integer.parseInt(data[10]);
            double tyrePress4 = Double.parseDouble(data[11]);
            int tyreAge4 = Integer.parseInt(data[12]);

            Tyres tyres = new Tyres(tyrePress1,tyreAge1,tyrePress2,tyreAge2,tyrePress3,tyreAge3,tyrePress4,tyreAge4);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Engine engine = new Engine(engineSpeed,enginePower);
            Car car = new Car(carModel,engine,cargo,tyres);

            cars.add(car);

        }

        String type = reader.readLine();

        switch (type){
            case "fragile":
                cars.stream().filter(car -> {
                    double t1 = car.getTyres().getTyre1();
                    double t2 = car.getTyres().getTyre2();
                    double t3 = car.getTyres().getTyre3();
                    double t4 = car.getTyres().getTyre4();
                    String c = car.getCargo().getType();

                    return t1 < 1 || t2 < 1 || t3 < 1 || t4 < 1 && c.equals(type);
                }).forEach(c-> System.out.println(c.toString()));

                break;
            case "flamable":
                cars.stream().filter(car -> {
                    String c = car.getCargo().getType();
                    int p = car.getEngine().getPower();

                    return c.equals(type) && p>250;
                }).forEach(c-> System.out.println(c.toString()));
                break;
        }
    }
}
