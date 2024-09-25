package service;

import java.util.List;

public interface MyInterfaceService<T> {
    void deleteObject(int id);
    List<T> getAllObject();
    void addObject(T t);
    T findById(int id);
    void updateObject(T t);
}
