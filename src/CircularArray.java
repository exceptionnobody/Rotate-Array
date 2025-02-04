import java.util.Iterator;


public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    @SuppressWarnings("unchecked")
    public CircularArray(int size) {
        items = (T[]) new Object[size]; // we could declare items like a List<T> and
                                        // in the constructor do: items = new ArrayList<>();
    }

    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int _current = -1;

        public CircularArrayIterator() { }

        @Override
        public boolean hasNext() {
            System.out.println("hasNext");
            return _current < items.length - 1;
        }

        @Override
        public T next() {
            System.out.println("next");

            _current++;
            return items[convert(_current)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported by CircularArray");
        }
    }
}