package labs.lab4;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // -----------------------------------------
        ShopItem baseShopItem = new ShopItem("base shop item", BigDecimal.valueOf(0.1d), 10);
        ShopItem industrialItem = new IndustrialItem("industrial item", BigDecimal.valueOf(12.3d), 10, ItemShippingCondition.DO_NOT_CANT, ItemLocation.IN_SELLING_ROOM);
        // -----------------------------------------
        System.out.println("-------------");
        System.out.println("ShopItem       alarm " + baseShopItem.alarm());
        System.out.println("IndustrialItem alarm " + industrialItem.alarm());
    }
}

