package s107_n2_e01_JsonSerializable;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Juan", "Quixote", 33);
        JsonSerializerProcessor.serialize(person);
    }
}
