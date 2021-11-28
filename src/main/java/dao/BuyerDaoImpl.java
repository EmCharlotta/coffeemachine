package dao;

import domain.Buyer;
import domain.Drink;
import pool.C3P0DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDaoImpl implements main.java.dao.Dao<Buyer, Integer> {
    @Override
    public List getAll() throws SQLException {
        List<Buyer> buyers = new ArrayList<>();
        String select = "SELECT * FROM buyer;";
        try (Statement statement = C3P0DataSource.getConnection().createStatement()) {
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
    public Buyer getByPK(Integer i) throws SQLException {
        Buyer buyer = new Buyer();
        String select = "SELECT b_name FROM buyer where id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(select)) {
            statement.setInt(1, i);
            ResultSet resultSet = statement.executeQuery(select);

            buyer.setBuyer_id(i);
            buyer.setB_name(resultSet.getString("b_name"));
        }
        return buyer;
    }

    @Override
    public void add(Buyer buyer) throws SQLException {
        String insert = "INSERT INTO buyer (buyer_id, b_name) VALUES (?, ?);";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setInt(1, buyer.getBuyer_id());
            statement.setString(2, buyer.getB_name());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void update(Buyer buyer) throws SQLException {
        String insert = "Update buyer SET b_name = ? where buyer_id = ?;";
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement(insert)) {
            statement.setString(1, buyer.getB_name());
            statement.setInt(2, buyer.getBuyer_id());
            int res = statement.executeUpdate();
            System.out.println("res = " + res); // res = 1
        }
    }

    @Override
    public void delete(Buyer buyer) throws SQLException {
        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement("DELETE * FROM buyer WHERE id=?")) {
            statement.setInt(1, buyer.getBuyer_id());
            int result = statement.executeUpdate();
        }
    }

    public List<Buyer> getByNameAsc() throws SQLException {
        List<Buyer> buyers = new ArrayList<>();

        try (PreparedStatement statement = C3P0DataSource.getConnection().prepareStatement("SELECT * FROM buyer order by b_name asc"))
            {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Buyer b = new Buyer();
                    b.setBuyer_id(resultSet.getInt("buyer_id"));
                    b.setB_name(resultSet.getString("b_name"));
                    buyers.add(b);
                }
            }
            return buyers;
        }
    }
