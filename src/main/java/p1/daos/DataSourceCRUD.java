package p1.daos;

import java.util.List;

public interface DataSourceCRUD<T> {
    void create(T t);
    T read(int id);
    List<T> readALL();
    void update(T t);
    void delete(int id);
}
