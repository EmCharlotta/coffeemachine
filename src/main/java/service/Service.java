package service;

import domain.Drink;

import java.sql.SQLException;
import java.util.List;

public interface Service<T, PK> {
    List<T> getAll() throws SQLException;

    // получение записи по первичному ключу
    T getByPK(PK pk) throws SQLException;

    // добавление записи
    void add(T entity) throws SQLException;

    // обновление записи
    void update(T entity) throws SQLException;

    // удаление записи
    void delete(T entity) throws SQLException;
}
