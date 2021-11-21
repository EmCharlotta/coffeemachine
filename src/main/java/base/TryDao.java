package base;

import domain.Drink;
import dao.DrinkDao;

public class TryDao {

    public static void main(String[] args) {
        DrinkDao dDao = new DrinkDao();
        try {
            dDao.add(new Drink(1, "cappuchino", 100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

