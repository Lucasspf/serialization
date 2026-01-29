package serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExShapes {
    public static void main(String[] args)throws Exception {
       ShapesConfig shapesConfig = ShapesConfig.create();

       ShapeConfig rectangleConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.RECTANGLE);

       var rectangle = new Rectangle(
               Integer.parseInt(rectangleConfig.getProperties().get("width")),
               Integer.parseInt(rectangleConfig.getProperties().get("width"))
       );
        System.out.println(rectangle);

        ShapeConfig squareConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.SQUARE);
        var square = new Square(Integer.parseInt(squareConfig.getProperties().get("size")));
        System.out.println(square);
        
        ShapeConfig circleConfig = shapesConfig.getConfig(ShapesConfig.ShapeType.CIRCLE);
        var circle = new Circle(Integer.parseInt(circleConfig.getProperties().get("radius")));
        System.out.println(circle);

    }

    private record Square(int size){}

    private  record  Rectangle(int width, int height){}

    private record  Circle(int radius){}

    private record ShapesConfig(List<ShapeConfig> configs) {
        public enum ShapeType {
            SQUARE, RECTANGLE, CIRCLE
        }

        public static ShapesConfig create() {
                try {
                    return new ShapesConfig(
                            JsonUtils.mapper().readValue(new File("shapesConfig.json"), new TypeReference<>() {
                            })
                    );
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public ShapeConfig getConfig(ShapeType type){
                return configs
                        .stream()
                        .filter(c-> c.type == type)
                        .findFirst()
                        .orElseThrow();
            }
        }
    private static class ShapeConfig{
        private ShapesConfig.ShapeType type;
        private Map<String, String> properties;

        public ShapesConfig.ShapeType getType() {
            return type;
        }

        public Map<String, String> getProperties() {
            return properties;
        }



        @Override
        public String toString() {
            return "ShapeConfig{" +
                    "type=" + type +
                    ", properties=" + properties +
                    '}';
        }
    }
}
