package p1.daos;

import java.sql.SQLException;
import java.util.List;

public interface DataSourceCRUD<T> {
    void create(T t);
    T read(int id);
    List<T> readALL();
    void update(T t, Integer i);
    void delete(int id);
}
