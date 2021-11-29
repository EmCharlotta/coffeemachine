package service;

import dao.DrinkDaoImpl;
import domain.Drink;

import java.sql.SQLException;
import java.util.List;

public class DrinkService implements Service<Drink, Integer> {
    DrinkDaoImpl drinkDao = new DrinkDaoImpl();


    @Override
    public List<Drink> getAll() throws SQLException {
        return drinkDao.getAll();
    }

    @Override
    public Drink getByPK(Integer drink_id) throws SQLException {
        return drinkDao.getByPK(drink_id);
    }

    @Override
    public void add(Drink drink) throws SQLException {
        drinkDao.add(drink);
    }

    @Override
    public void update(Drink drink) throws SQLException {
        drinkDao.update(drink);
    }

    @Override
    public void delete(Drink drink) throws SQLException {
        drinkDao.delete(drink);
    }
}
