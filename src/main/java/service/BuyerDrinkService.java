package service;

import dao.BuyerDrinkDaoImpl;
import domain.BuyerDrink;

import java.sql.SQLException;
import java.util.List;

public class BuyerDrinkService implements Service<BuyerDrink, Integer[]> {
    BuyerDrinkDaoImpl buyerDrinkDao = new BuyerDrinkDaoImpl();

    @Override
    public List<BuyerDrink> getAll() throws SQLException {
        return buyerDrinkDao.getAll();
    }

    @Override
    public BuyerDrink getByPK(Integer[] integers) throws SQLException {
        return buyerDrinkDao.getByPK(integers);
    }

    @Override
    public void add(BuyerDrink entity) throws SQLException {
        buyerDrinkDao.add(entity);
    }

    @Override
    public void update(BuyerDrink entity) throws SQLException {
        buyerDrinkDao.update(entity);
    }

    @Override
    public void delete(BuyerDrink entity) throws SQLException {
        buyerDrinkDao.delete(entity);
    }
}
