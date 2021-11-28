package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer {
    private int buyer_id;
    private String b_name;

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return buyer_id == buyer.buyer_id &&
                Objects.equals(b_name, buyer.b_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer_id, b_name);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyer_id=" + buyer_id +
                ", b_name='" + b_name + '\'' +
                '}';
    }
}
