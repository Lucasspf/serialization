package serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;

public class App3 {
    public static void main(String[] args) throws JsonProcessingException {
        String json = """
                    {"min": 5, "max": 10};
                """;

        Range range = JsonUtils.mapper().readValue(json, Range.class );
        System.out.println(range);

    }
    private record Range (int min, int max){
    }
}
