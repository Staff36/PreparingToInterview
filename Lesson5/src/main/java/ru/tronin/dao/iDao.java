package ru.tronin.dao;

import java.util.List;

public interface iDao<T> {
    T getEntityById(Long id);

    List<T> getAllEntities();

    void saveOrUpdateEntity(T t);

    void deleteEntity(T t);

    void deleteEntityById(Long id);

    void saveAll(List<T> ts);
}
