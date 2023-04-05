package com.fpt.poly.lab.service;

import java.util.List;

public interface CommonService<T> {
    List<T> getAll();

    boolean add(T value);

    boolean update(T value);

    boolean delete(T value);

    T getOne(String id);


}
