package serialization.obj;

import serialization.SerializationUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ExRandomNumbers {

    public static void main(String[] args) {
        Path file = Path.of("numbers.out");

        List<Double> numbers = new ArrayList<>();

        if (Files.exists(file)){
            numbers = SerializationUtils.fromFile(file);
        }

        numbers.add(Math.random());
        SerializationUtils.toFile(numbers, file);
       numbers.forEach(System.out::println);
    }
}
