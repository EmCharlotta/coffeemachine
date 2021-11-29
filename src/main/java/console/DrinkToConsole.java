package console;

import domain.Drink;
import service.DrinkService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DrinkToConsole {
    public static void main(String[] args) throws SQLException {
        DrinkService drinkService = new DrinkService();
        Scanner scan = new Scanner(System.in);
        System.out.println("If you want to input data, write 'input', if you want to get data, write 'get'," +
                " 'update' for data update and 'delete' to delete");
        String data = scan.next().toLowerCase();
        switch (data) {
            case "input": {
                System.out.println("If you want to input drink, please input id, name and price");
                Drink drink = new Drink();
                drink.setDrink_id(scan.nextInt());
                System.out.println(drink);
                String name = scan.next();
                drink.setDrink(name);
                System.out.println(drink);
                Integer price = scan.nextInt();
                drink.setPrice(price);
                System.out.println(drink);
                drinkService.add(drink);
                break;
            }
            case "get": {
                System.out.println("If you want to get drink, please input id, if you want to get all drinks, input 'all'");
                break;
            }
            case "update": {
                System.out.println("If you want to update, please input id, name and price");
                break;
            }
            case"delete":{
                System.out.println("If you want to delete, please input id, name and price");
            }

        }

    }
}
