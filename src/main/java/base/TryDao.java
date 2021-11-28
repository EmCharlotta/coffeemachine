package base;

import domain.Drink;
import dao.DrinkDaoImpl;

public class TryDao {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DrinkDaoImpl dDao = new DrinkDaoImpl();
        try {
            dDao.add(new Drink(1, "cappuchino", 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

