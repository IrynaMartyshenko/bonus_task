package csv_parser.src.main.java.com.iryna;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import csv_parser.src.main.java.com.iryna.utils.generators.ObjectGenerator;

public class CsvManager<T extends CsvSerializable> {
    private File file;
    private List<T> items;

    public CsvManager(String fileName, ObjectGenerator<T> generator) {
        this.file = new File(fileName);
        this.items = new ArrayList<T>();
    }

    public ArrayList<T> getAll() {
        return new ArrayList<T>(items);
    }

    public T findByIndex(int index) {
        return items.get(index);
    }

    public Collection<T> filter(Predicate<T> filterPredicate) {
        ArrayList<T> filteredItems = new ArrayList<T>();
        for (T item : items) {
            if (filterPredicate.test(item)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    private void addInternal(T item, boolean appendToFile) {
        items.add(item);
        
        try (FileWriter fr = new FileWriter(file, appendToFile)) {
            fr.write(item.serializeToString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(T item) {
        addInternal(item, true);
    }

    public void clearAll() {
        try (FileWriter fr = new FileWriter(file)) {
            fr.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAll(Collection<T> list) {
        for (T item : list) {
            addInternal(item, true);
        }
    }
}
