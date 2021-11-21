package domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int buyer_id;
    private String b_name;

    public Buyer(int buyer_id, String b_name) {
        this.buyer_id = buyer_id;
        this.b_name = b_name;
    }

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
    public String toString() {
        return "Buyer{" +
                "buyer_id=" + buyer_id +
                ", b_name='" + b_name + '\'' +
                '}';
    }
}
