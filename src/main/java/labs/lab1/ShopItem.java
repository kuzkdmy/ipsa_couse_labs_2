package labs.lab1;

import java.math.BigDecimal;

public class ShopItem {
    private String name;
    private BigDecimal price;
    private int count;

    public ShopItem() {
    }

    public ShopItem(String name, BigDecimal price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public ShopItem(ShopItem other) {
        this.name = other.name;
        this.price = other.price;
        this.count = other.count;
    }

    public ShopItem withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toStringState() {
        return "name='" + name + '\'' + ", price=" + price + ", count=" + count;
    }

    @Override
    public String toString() {
        return "ShopItem{" + "name='" + name + '\'' + '}';
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        System.out.println("java finalizer called on " + this);
        super.finalize();
    }
}
