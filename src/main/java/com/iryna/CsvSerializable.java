package csv_parser.src.main.java.com.iryna;

public interface CsvSerializable {
    String serializeToString();
    void deserialize(String text);
}
