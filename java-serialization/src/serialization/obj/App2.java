package serialization.obj;

import serialization.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class App2 {
    public static void main(String[] args) throws IOException {

        Path file = Path.of("file.bin");

       try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file))){
           Client client = (Client) ois.readObject();
           System.out.println(client);

       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

    }
}
