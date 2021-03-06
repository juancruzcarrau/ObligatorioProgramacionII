package TADs;

public interface Lista<T> {

    void add(T value);

    void remove(int position);

    Object get(int position);

    Boolean find(T value);

}