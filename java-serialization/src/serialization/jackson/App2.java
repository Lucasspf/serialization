package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App2 {
    public static void main(String[] args) throws IOException {
        var mapper = JsonUtils.mapper();

        Item item1 = new Item(1 , "A");
        Item item2 = new Item(2 , "B");
        var list = List.of(item1, item2);
       String json = mapper.writeValueAsString(List.of(item1, item2));
        System.out.println(json);


        try(var out = Files.newBufferedWriter(Path.of("item.json"))){
            mapper.writeValue(out,list);
        }
    }
}
