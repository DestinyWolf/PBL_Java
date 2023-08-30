package dao;

import java.util.LinkedList;
import java.util.List

public interface Dao<T> {

    public T findById(Integer id);
    public void save(T obj);

    public void deleteById(Integer id);

    public void Update(T t, T old);

    public LinkedList<T> findAll();
}
