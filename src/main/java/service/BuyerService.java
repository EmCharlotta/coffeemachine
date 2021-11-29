package service;

import dao.BuyerDaoImpl;
import domain.Buyer;

import java.sql.SQLException;
import java.util.List;

public class BuyerService implements Service<Buyer, Integer> {

    BuyerDaoImpl buyerDao = new BuyerDaoImpl();

    @Override
    public List<Buyer> getAll() throws SQLException {
        return buyerDao.getAll();
    }

    @Override
    public Buyer getByPK(Integer integer) throws SQLException {
        return buyerDao.getByPK(integer);
    }

    @Override
    public void add(Buyer entity) throws SQLException {
        buyerDao.add(entity);
    }

    @Override
    public void update(Buyer entity) throws SQLException {
buyerDao.update(entity);
    }

    @Override
    public void delete(Buyer entity) throws SQLException {
buyerDao.delete(entity);
    }
}
