package dao;

import domain.Buyer;
import domain.BuyerDrink;
import domain.Drink;
import pool.C3P0DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDrinkDaoImpl implements main.java.dao.Dao<BuyerDrink, Integer[]> {
    @Override

    public List getAll() throws SQLException {
        List<BuyerDrink> drink_buyer = new ArrayList<>();
        String select = "SELECT * FROM drink_buyer;";
        try (Statement statement = C3P0DataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                BuyerDrink b = new BuyerDrink();
                b.setBuyer_id(resultSet.getInt("buyer_id"));
                b.setDrink_id(resultSet.getInt("drink_id"));
                drink_buyer.add(b);
            }
        }
        return drink_buyer;
    }

    @Override
    public BuyerDrink getByPK(Integer[] b_id_drink_id) throws SQLException {
        BuyerDrink buyerDrink = new BuyerDrink();
        String select = "SELECT buyer_id, drink_id FROM drink_buyer where buyer_id = ? and drink_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(select)) {
            statement.setInt(1, b_id_drink_id[1]);
            statement.setInt(1, b_id_drink_id[2]);
            ResultSet resultSet = statement.executeQuery(select);

            buyerDrink.setBuyer_id(resultSet.getInt("buyer_id"));
            buyerDrink.setDrink_id(resultSet.getInt("drink_id"));

            return buyerDrink;
        }
    }

    public List<Drink> getDrinksByBuyerId(Integer buyer_id) throws SQLException {
        List<Drink> buyerDrink = new ArrayList<>();
        String select = "SELECT drink_id, drink FROM drink_buyer left join coffeemachine on drink_id = drink_id where buyer_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(select)) {
            statement.setInt(1, buyer_id);
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Drink dr = new Drink();
                dr.setDrink_id(resultSet.getInt("drink_id"));
                dr.setDrink("drink");
                buyerDrink.add(dr);
            }
        }
        return buyerDrink;
    }

    public List<Buyer> getBuyersByDrinkId(Integer drink_id) throws SQLException {
        List<Buyer> buyers = new ArrayList<>();
        String select = "SELECT buyer_id, b_name FROM drink_buyer left join buyer on buyer_id = buyer_id where drink_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(select)) {
            statement.setInt(1, drink_id);
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Buyer b = new Buyer();
                b.setBuyer_id(resultSet.getInt("buyer_id"));
               b.setB_name(resultSet.getString("b_name"));
                buyers.add(b);
            }
        }
        return buyers;
    }

    @Override
    public void add(BuyerDrink buyerDrink) throws SQLException {
        String insert = "INSERT INTO drink_buyer (buyer_id, drink_id) VALUES (?, ?);";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setInt(1, buyerDrink.getBuyer_id());
            statement.setInt(2, buyerDrink.getDrink_id());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void update(BuyerDrink buyerDrink) throws SQLException {
        String insert = "Update drink_buyer SET buyer_id = ?, drink_id = ? where buyer_id = ? and drink_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setInt(1, buyerDrink.getBuyer_id());
            statement.setInt(2, buyerDrink.getDrink_id());
            statement.setInt(3, buyerDrink.getBuyer_id());
            statement.setInt(4, buyerDrink.getDrink_id());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void delete(BuyerDrink buyerDrink) throws SQLException {
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement("DELETE * FROM drink_buyer WHERE buyer_id = ? and drink_id = ?")) {
            statement.setInt(1, buyerDrink.getBuyer_id());
            statement.setInt(2, buyerDrink.getDrink_id());
            int result = statement.executeUpdate();
        }
    }
}
