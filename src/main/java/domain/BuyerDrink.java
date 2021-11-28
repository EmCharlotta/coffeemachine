package domain;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class BuyerDrink {
    private int drink_id;
    private int buyer_id;

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerDrink that = (BuyerDrink) o;
        return drink_id == that.drink_id &&
                buyer_id == that.buyer_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(drink_id, buyer_id);
    }

    @Override
    public String toString() {
        return "BuyerDrink{" +
                "drink_id=" + drink_id +
                ", buyer_id=" + buyer_id +
                '}';
    }
}
