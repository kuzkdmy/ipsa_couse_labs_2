package labs.lab4.lab2;

import java.math.BigDecimal;

public class IndustrialItem extends ShopItem {
    private ItemShippingCondition shippingCondition;
    private ItemLocation itemLocation;

    public IndustrialItem(String name, BigDecimal price, int count, ItemShippingCondition shippingCondition, ItemLocation itemLocation) {
        super(name, price, count);
        this.shippingCondition = shippingCondition;
        this.itemLocation = itemLocation;
    }

    @Override
    public String alarm() {
        return "Child alarm: " + shippingCondition.displayValue + " " + super.alarm();
    }

}
