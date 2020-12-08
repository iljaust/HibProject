package com.iljaust.hibirnate.repository;


import java.util.List;

public interface GenericRepository <T,ID>{
    T getById(ID id);
    T save(T t);
    T update(T t);
    List<T> getAll() ;
    void deleteById(ID id);
}
