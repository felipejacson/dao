package java.com.skip.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DefaultDAO<T> {

    List<T> execute(String sql) throws SQLException;

    List<T> select(T obj) throws SQLException;

    boolean insert(T obj) throws SQLException;

    boolean update(T obj) throws SQLException;

    boolean delete(Long id) throws SQLException;

}