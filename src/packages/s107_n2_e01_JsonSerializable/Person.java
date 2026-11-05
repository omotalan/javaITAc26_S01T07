package s107_n2_e01_JsonSerializable;

@JsonSerializable(directory = "output_json")
public record Person(String name, String surname, int age) {
}
