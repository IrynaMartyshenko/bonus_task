package csv_parser.src.main.java.com.iryna.utils.generators;

import csv_parser.src.main.java.com.iryna.CsvSerializable;

public interface ObjectGenerator<T extends CsvSerializable> {
    T generate();
}
