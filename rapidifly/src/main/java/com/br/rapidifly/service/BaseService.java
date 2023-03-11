package com.br.rapidifly.service;

import java.util.List;

public interface BaseService<E, ID>{

    E save(E e);

    E update(E e, ID id);

    void delete(ID id);

    E findById(ID id);

    List<E> findAll();

    void validate(E e);
}
