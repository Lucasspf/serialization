package serialization.jackson;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class App6 {
    public static void main(String[] args) throws Exception {

        Car car = new Car(
                null,
                Car.Color.WHITE, LocalDate.of(2020,6,13),
                new Car.Engine(
                        "XPTO",
                        89.3
                )
        );

        try(var out = Files.newOutputStream(Path.of("car.json"))){
            JsonUtils.mapper().writeValue(out,car);
           // JsonUtils.mapper().writerWithDefaultPrettyPrinter().writeValue(out,car);
        }
    }
}
