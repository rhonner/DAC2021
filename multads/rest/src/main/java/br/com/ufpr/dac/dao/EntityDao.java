package br.com.ufpr.dac.dao;

import java.util.List;

public interface EntityDao<T> {

    int inserir(T entity);

    void alterar(T entity);

    void excluir(T entity);
    
    void excluir(List<T> entity);
        
}
