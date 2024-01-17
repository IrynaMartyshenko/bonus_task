package csv_parser.src.main.java.com.iryna.utils.formatters;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FormatterIterator<T> implements Iterable<String> {
    private Collection<T> items;
    private Formatter<T> formatter;

    private FormatterIterator(Collection<T> items) {
        this.items = items;
    }

    private FormatterIterator(Collection<T> items, Formatter<T> formatter) {
        this.items = items;
        this.formatter = formatter;
    }

    public static <T> FormatterIterator<T> create(Collection<T> items) {
        return new FormatterIterator<T>(items);
    }

    public static <T> FormatterIterator<T> create(Collection<T> items, Formatter<T> formatter) {
        return new FormatterIterator<T>(items, formatter);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private Iterator<T> itemIterator = items.iterator();

            @Override
            public boolean hasNext() {
                return itemIterator.hasNext();
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (formatter != null) {
                    return formatter.format(itemIterator.next());
                }

                return itemIterator.next().toString();
            }
        };
    }
}
