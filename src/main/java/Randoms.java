import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected final Random random = new Random();
    private final Iterator<Integer> iterator;

    public Randoms(int min, int max) {
        iterator = new EndlessIterator(min, max);
    }

    @Override
    public Iterator<Integer> iterator() {
        return iterator;
    }

    private class EndlessIterator implements Iterator<Integer> {
        final int min;
        final int max;

        private EndlessIterator(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return random.nextInt(max + 1 - min) + min;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}