package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import serialization.Client;

import java.time.LocalDate;

public class App1 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        Client client = new Client(10, "Pedro", LocalDate.of(1990, 4,10), "123");
        String json = mapper.writeValueAsString(client);

        System.out.println(json);
    }
}
