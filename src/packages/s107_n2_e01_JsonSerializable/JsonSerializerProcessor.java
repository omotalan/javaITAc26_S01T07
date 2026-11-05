package s107_n2_e01_JsonSerializable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonSerializerProcessor {

    // Override serialize method with standard directory path from the annotation
    // Uses Java Reflection to dynamically detect and read annotations at runtime.
    public static void serialize(Object object) {
        Class<?> cls = object.getClass();
        // Demonstration of Reflection: Check if JVM registered the annotation
        if (!cls.isAnnotationPresent(JsonSerializable.class)) {
            System.out.printf("The class {%s} is not annotated with @JsonSerializable", cls.getSimpleName());
            return;
        }

        // Demonstration of Reflection: Extracting annotation parameters dynamically
        JsonSerializable annotation = cls.getAnnotation(JsonSerializable.class);
        System.out.printf("[Reflection] Success! Found @JsonSerializable annotation target directory: '%s'\n", annotation.directory());

        serialize(object, annotation.directory());
    }


    public static void serialize(Object object, String directoryPath) {
        Class<?> cls = object.getClass();

        if (!cls.isAnnotationPresent(JsonSerializable.class)) {
            System.out.printf("The class {%s} is not annotated with @JsonSerializable", cls.getSimpleName());
            return;
        }

        try {
            String jsonContent = formatJsonInput(object);
            File directory = createDirectory(directoryPath);
            String fileName = String.format("%s.json", cls.getSimpleName().toLowerCase());

            File outputFile = new File(directory, fileName);

            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(jsonContent);
                System.out.printf("Successfully serialized object to: %s", outputFile.getAbsolutePath());
            }
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Critical failure: Could not serialize object", e);
        }
    }

    static String formatJsonInput(Object object) {
        Class<?> cls = object.getClass();

        return Arrays.stream(cls.getDeclaredFields())
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(object);

                        String formattedValue = (value instanceof String) ? "\"" + value + "\"" : String.valueOf(value);
                        return String.format("\"%s\": %s", field.getName(), formattedValue);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(",\n", "{\n", "\n}"));
    }

    static File createDirectory(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }
}
