package CarSalesMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Engine> engines = new ArrayList<>();

        List<Car> cars = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            String[] data = reader.readLine().split(" ");
            int size = data.length;
            switch (size){
                case 2:
                    String type = data[0];
                    int power = Integer.parseInt(data[1]);
                    Engine engine = new Engine(type,power);
                    engines.add(engine);
                    break;
                    case 3:
                        type = data[0];
                        power = Integer.parseInt(data[1]);
                        try {
                            int displ = Integer.parseInt(data[2]);
                            Engine engine1 = new Engine(type,power,displ);
                            engines.add(engine1);
                        }catch (Exception e){
                            String dis = data[2];
                            Engine engine1 = new Engine(type,power,dis);
                            engines.add(engine1);
                        }

                    break;
                case 4:
                    type = data[0];
                    power = Integer.parseInt(data[1]);
                    int displ = Integer.parseInt(data[2]);
                    String eff = data[3];
                    Engine engine2 = new Engine(type,power,displ,eff);
                    engines.add(engine2);
                    break;

            }
        }

         int m = Integer.parseInt(reader.readLine());

        for (int i = 0; i <m ; i++) {

            String [] carInfo =reader.readLine().split(" ");
            int size = carInfo.length;

            switch (size){
                case 2:
                    String carModel = carInfo[0];
                    String engineModel = carInfo[1];

                    Engine newEngine = new Engine();
                    for (Engine engine : engines) {
                        if (engine.getModel().equals(engineModel)){
                            newEngine = engine;
                        }
                    }


                    Car car = new Car(carModel,newEngine);
                    cars.add(car);

                    break;
                case 3:
                    try {
                        int carWeigth = Integer.parseInt(carInfo[2]);
                        carModel = carInfo[0];
                        engineModel = carInfo[1];
                         newEngine = new Engine();
                        for (Engine engine : engines) {
                            if (engine.getModel().equals(engineModel)){
                                newEngine = engine;
                            }
                        }

                        Car car1 = new Car(carModel,newEngine,carWeigth);
                        cars.add(car1);
                    }catch (Exception e){
                       carModel = carInfo[0];
                        engineModel = carInfo[1];
                        String carColor = carInfo[2];

                        newEngine = new Engine();
                        for (Engine engine : engines) {
                            if (engine.getModel().equals(engineModel)){
                                newEngine = engine;
                            }
                        }
                        Car car1 = new Car(carModel,newEngine,carColor);
                        cars.add(car1);

                    }

                    break;
                case 4:
                    carModel = carInfo[0];
                    engineModel = carInfo[1];
                    int carWeigth = Integer.parseInt(carInfo[2]);
                    String carColor = carInfo[3];

                   newEngine = new Engine();
                    for (Engine engine : engines) {
                        if (engine.getModel().equals(engineModel)){
                            newEngine = engine;
                        }
                    }
                    Car car1 = new Car(carModel,newEngine,carWeigth,carColor);
                    cars.add(car1);
                    break;
            }

        }

        for (Car car : cars) {
            System.out.print(car.toString());
        }
    }
}
