package labs.lab2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static labs.lab2.ItemLocation.IN_SELLING_ROOM;
import static labs.lab2.ItemShippingCondition.DO_NOT_CANT;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime createdAt = now.minusDays(3);
        LocalDateTime invalid = now.minusDays(1);
        LocalDateTime valid = now.plusMonths(1);

        // -----------------------------------------
        System.out.println("-------------");
        new FoodItem();
        // -----------------------------------------
        ShopItem baseShopItem = new ShopItem("base shop item", BigDecimal.valueOf(0.1d), 10);
        ShopItem foodItemValid = new FoodItem("food item 1", BigDecimal.valueOf(1.1d), 1, createdAt, valid);
        ShopItem foodItemInvalid = new FoodItem("food item 2", BigDecimal.valueOf(2.2d), 2, createdAt, invalid);
        ShopItem industrialItem = new IndustrialItem("industrial item", BigDecimal.valueOf(12.3d), 10, DO_NOT_CANT, IN_SELLING_ROOM);
        // -----------------------------------------
        System.out.println("-------------");
        System.out.println("ShopItem                   toString " + baseShopItem);
        System.out.println("FoodItem (valid by date)   toString " + foodItemValid);
        System.out.println("FoodItem (invalid by date) toString " + foodItemInvalid);
        System.out.println("IndustrialItem             toString " + industrialItem);
    }
}

