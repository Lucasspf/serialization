package serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App5 {
    public static void main(String[] args)throws Exception {
        try(var in = Files.newBufferedReader(Path.of("letters.json"))){
//            var letters = JsonUtils.mapper().readValue(in, List.class);

//            var letters = JsonUtils.mapper().readValue(in, new TypeReference<>() {
//            });

            String[] letters = JsonUtils.mapper().readValue(in, String[].class);
            System.out.println(Arrays.toString(letters));

        }

    }
}
