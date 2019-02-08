package SymbolTable;

public class BinarySeachSymbolTable<Key, Value>  {
    public void put(Key key, Value value) {

    }

//
//    public Value get(Key key) {
//        if (isEmpty()) return null;
//        int i = rank(key);
//        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
//        else return null;
//    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Iterable keys() {
        return null;
    }

//    private int rank(Key key){
//        int low = 0, high = N-1;
//        while(low <= high){
//            int mid = low + (high - low) / 2;
//            int cmp = key.compareTo(keys[mid]);
//            if (cmp < 0) high = mid -1;
//            else if (cmp > 0) low = mid + 1;
//            else if (cmp == 0) return mid;
//        }
//        return low;
//    }
}
