package labs.lab2;

import java.math.BigDecimal;

public class IndustrialItem extends ShopItem {
    private ItemShippingCondition shippingCondition;
    private ItemLocation itemLocation;

    public IndustrialItem() {
        System.out.println("Визов конструктора IndustrialItem()");
    }

    public IndustrialItem(String name, BigDecimal price, int count, ItemShippingCondition shippingCondition, ItemLocation itemLocation) {
        super(name, price, count);
        this.shippingCondition = shippingCondition;
        this.itemLocation = itemLocation;
    }

    public IndustrialItem(IndustrialItem other) {
        this(other.getName(), other.getPrice(), other.getCount(), other.shippingCondition, other.itemLocation);
    }

    public ItemShippingCondition getShippingCondition() {
        return shippingCondition;
    }

    public void setShippingCondition(ItemShippingCondition shippingCondition) {
        this.shippingCondition = shippingCondition;
    }

    public ItemLocation getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(ItemLocation itemLocation) {
        this.itemLocation = itemLocation;
    }

    @Override
    public String alarm() {
        return shippingCondition.displayValue;
    }

    @Override
    public String toString() {
        return "IndustrialItem{" +
                "shippingCondition=" + shippingCondition +
                ", itemLocation=" + itemLocation +
                '}' + super.toString();
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        System.out.println("java finalizer called on base IndustrialItem");
        super.finalize();
    }
}
