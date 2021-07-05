package labs.lab4;

import java.math.BigDecimal;

public class ShopItem {
    private String name;
    private BigDecimal price;
    private int count;

    public ShopItem(String name, BigDecimal price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String alarm() {
        return "Parent alarm: " + name;
    }
}
