package SymbolTable;

public interface iSymbolTable<Key, Value> {

    void put (Key key,  Value value);
    void get (Key key);
    void delete (Key key);

    boolean contains (Key key);
    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
