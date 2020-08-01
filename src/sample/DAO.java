package sample;

import java.sql.Connection;
import sample.connection.*;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    public abstract boolean insert(T obj);


    public abstract boolean delete(T obj);


    public abstract boolean update(T obj);
}