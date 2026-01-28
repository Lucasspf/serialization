package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public class App4 {
    public static void main(String[] args) throws JsonProcessingException {
        String json = """
                    {"min": 5, "max": 10};
                """;

//        var range = JsonUtils.mapper().readValue(json, Map.class );

        Map<String,Integer> range = JsonUtils.mapper().readValue(json,new TypeReference<>(){});
       System.out.println(range);

    }

}
