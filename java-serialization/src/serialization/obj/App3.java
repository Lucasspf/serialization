package serialization.obj;

import serialization.Client;
import serialization.SerializationUtils;

import java.nio.file.Path;
import java.time.LocalDate;

import static serialization.SerializationUtils.toFile;

public class App3 {
    public static void main(String[] args) {

        Path file = Path.of("file.bin");

        Client client = new Client(10,"Maria", LocalDate.of(1980,6,1));
        toFile(client,file);

        Client client1 = (Client) SerializationUtils.fromFile(file);
        System.out.println(client1);
    }
}
