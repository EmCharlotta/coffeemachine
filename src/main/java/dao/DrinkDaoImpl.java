package dao;

import domain.Drink;
import pool.C3P0DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrinkDaoImpl implements main.java.dao.Dao<Drink, Integer> {

    @Override
    public List<Drink> getAll() throws SQLException {
        List<Drink> drinks = new ArrayList<>();
        String select = "SELECT * FROM coffeemachine;";
        try (Statement statement = C3P0DataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                drinks.add(new Drink(resultSet.getInt("drink_id"),
                        resultSet.getString("drink"),
                        resultSet.getInt("price")));
            }
        }
        return drinks;
    }

    @Override
    public Drink getByPK(Integer i) throws SQLException {
        Drink drink = new Drink();
        String select = "SELECT drink FROM coffeemachine where id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(select)) {
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery(select);

            drink.setDrink_id(i);
            drink.setDrink(resultSet.getString("drink"));
            drink.setPrice(resultSet.getInt("price"));
        }
        System.out.println("In the database by id =" + i + " drink = " + drink);
        return drink;
    }

    @Override
    public void add(Drink drink) throws SQLException {
        String insert = "INSERT INTO coffeemachine (drink_id, drink, price) VALUES (?, ?, ?);";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setInt(1, drink.getDrink_id());
            statement.setString(2, drink.getDrink());
            statement.setInt(3, drink.getPrice());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void update(Drink drink) throws SQLException {
        String insert = "Update coffeemachine SET Drink = ?, Price = ? where drink_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setString(1, drink.getDrink());
            statement.setInt(2, drink.getPrice());
            statement.setInt(3, drink.getDrink_id());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void delete(Drink drink) throws SQLException {
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement("DELETE * FROM coffeemachine WHERE id=?")) {
            statement.setInt(1, drink.getDrink_id());
            int result = statement.executeUpdate();
        }
    }

    public List<Drink> getByPriceLess(Integer price) throws SQLException {
        List<Drink> drinks = new ArrayList<>();

        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement("SELECT * FROM coffeemachine WHERE price <?")) {
            statement.setInt(1, price);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                drinks.add(new Drink(resultSet.getInt("drink_id"),
                        resultSet.getString("drink"),
                        resultSet.getInt("price")));
            }
        }
        return drinks;
    }
}


