package behavioral.iterator;

interface Aggregate<T> {
   Iterator<T> createIterator();
}
