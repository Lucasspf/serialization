package serialization.obj;

import serialization.Client;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class App1 {
    public static void main(String[] args) throws IOException {

        Client client = new Client(1,"Pedro", LocalDate.of(1980,5,10));

        Path file = Path.of("file.bin");

       try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file))){
           oos.writeObject(client);
       }
    }
}
