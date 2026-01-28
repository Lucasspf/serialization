package serialization.jackson;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.File;
import java.io.IOException;

public class App7 {
    public static void main(String[] args) throws IOException {
       Range range =  JsonUtils.mapper().readValue(new File("ramdomConfig.json"), Range.class);
        System.out.println(range);
    }
        @JsonDeserialize(using = RangeDeserializer.class)
    public record Range(int min, int max){}

    public static class RangeDeserializer extends StdDeserializer<Range>{

        public RangeDeserializer(){
            this(null);
        }

        protected RangeDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Range deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
           JsonNode node =  parser.getCodec().readTree(parser);
            String rangeStr = node.get("range").asText();
            String[] tokens =  rangeStr.split("\\.\\.");
         return  new Range(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
    }
}
