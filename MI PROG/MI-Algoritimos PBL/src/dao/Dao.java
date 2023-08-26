package dao;

import java.util.LinkedList;

public interface Dao<T> {

    public T findById(Integer id);
    public void save(Object obj);

    public void deleteById();

    public void Update(T t);

    public LinkedList<T> findAll();
}
