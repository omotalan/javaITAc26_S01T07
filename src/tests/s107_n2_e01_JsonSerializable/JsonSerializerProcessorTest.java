package s107_n2_e01_JsonSerializable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerProcessorTest {

    @JsonSerializable(directory = "custom_test_dir")
    record AnnotatedClass(String item, int quantity) {}
    record UnannotatedClass(String name) {}
    record EmptyClass() {}

    // Annotation
    @Test
    void shouldExtractCorrectDirectoryFromAnnotation() {
        Class<?> cls = AnnotatedClass.class;
        assertTrue(cls.isAnnotationPresent(JsonSerializable.class));

        JsonSerializable annotation = cls.getAnnotation(JsonSerializable.class);
        assertEquals("custom_test_dir", annotation.directory());
    }

    @Test
    void shouldHandleUnannotatedClassWithoutCrashing() {
        UnannotatedClass cls = new UnannotatedClass("No Annotation");
        assertDoesNotThrow(() -> JsonSerializerProcessor.serialize(cls));
    }

    // JSON formatting
    @Test
    void shouldFormatStringFieldsWithQuotes() {
        record OnlyStrings(String text) {}
        OnlyStrings obj = new OnlyStrings("Hello");

        String result = JsonSerializerProcessor.formatJsonInput(obj);
        assertTrue(result.contains("\"text\": \"Hello\""), "Strings must be wrapped in quotes");
    }

    @Test
    void shouldFormatNumbersWithoutQuotes() {
        record OnlyNumbers(int nbr) {}
        OnlyNumbers obj = new OnlyNumbers(12);

        String result = JsonSerializerProcessor.formatJsonInput(obj);
        assertTrue(result.contains("\"nbr\": 12"), "Numbers must not be wrapped in quotes");
    }

    @Test
    void shouldHandleEmptyClassWithoutCrashing() {
        EmptyClass obj = new EmptyClass();

        String result = JsonSerializerProcessor.formatJsonInput(obj);
        assertEquals("{\n\n}", result);
    }

    // File system
    @Test
    void shouldCreateDirectoryOnDisk(@TempDir Path tempDir) {
        Path targetPath = tempDir.resolve("new_sub_folder");
        File createdDir = JsonSerializerProcessor.createDirectory(targetPath.toString());

        assertTrue(createdDir.exists(), "Directory should exist on disk");
        assertTrue(createdDir.isDirectory(), "Target path should be a proper directory");
    }

    @Test
    // Run test serialization on temp dir, so disk directory is not affected
    void shouldCompleteSerializationEndToEnd(@TempDir Path tempDir) {
        Person person = new Person("Juan", "Quixote", 33);
        // Use temp dir instead of standard, hardcoded dir
        JsonSerializerProcessor.serialize(person, tempDir.toString());

        File expectedFile = new File(tempDir.toFile(), "person.json");
        assertTrue(expectedFile.exists());
    }
}
