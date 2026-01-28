package serialization.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App9 {
    public static void main(String[] args) throws Exception {
          ObjectMapper mapper = JsonUtils.mapper();

        System.out.println("SERIALIZATION");
        Birthday b = new Birthday(17, 5, 1995);
        System.out.println(mapper.writer().writeValueAsString(b));

        System.out.println("DESERIALIZATION");
        String str = """
                {"day" : 17, "month" : 5, "year" : 1995}
                """;
        System.out.println(mapper.readValue(str, Birthday.class));
    }
}
