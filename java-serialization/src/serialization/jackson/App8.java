package serialization.jackson;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class App8 {
    public static void main(String[] args) throws Exception {
        Range range = new Range(5,20);
        String json = JsonUtils.mapper().writeValueAsString(range);
        System.out.println(json);
    }
    @JsonSerialize(using = RangeSerializer.class)
    public record Range(int min, int max){}

    public static class RangeSerializer extends StdSerializer<Range>{

        public RangeSerializer(){
            this(null);
        }

        protected RangeSerializer(Class<Range> t) {
            super(t);
        }


        @Override
        public void serialize(Range range, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
            String rangeStr = String.format("%d..%d", range.min(), range.max());

            gen.writeStartObject();
            gen.writeStringField("range", rangeStr);
            gen.writeEndObject();
        }
    }
}
