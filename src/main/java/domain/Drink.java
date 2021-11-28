package domain;

public class Drink {
    private int drink_id;
    private String drink;
    private int price;

    public Drink(int drink_id, String drink, int price) {
        this.drink_id = drink_id;
        this.drink = drink;
        this.price = price;
    }

    public Drink() {
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Drink{" +
                "drink_id=" + drink_id +
                ", drink='" + drink + '\'' +
                ", price=" + price +
                '}';
    }
}
