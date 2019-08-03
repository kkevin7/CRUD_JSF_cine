
package com.study.primefaces.model;

import java.util.List;

public interface AbstractInterface<T> {
    boolean create(T entity);
    
    boolean edit(T entity);
    
    boolean remove(T entity);
    
    List<T> findAll();
    
    List<T> findRange(int first, int pagesize);
    
    int count();

}
