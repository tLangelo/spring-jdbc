package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

public interface CRUDInterface <T>{
    // (C)reate
    public boolean create(T entity);

    //(R)ead
    public T getSingleEntityById(int id);
    public List<T> getAllEntities();
    List<T> getEntitiesByIDs(int id);

    //(U)pdate
    public boolean update(T entity);

    //(D)elete
    public boolean deleteById(int id);

}
