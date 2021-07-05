package labs.lab1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    // java don't have tailrec, so no stack safe
    private static String readNonEmptyLine(String echoInput) {
        System.out.println(echoInput);
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine().trim();
        if (res.isEmpty()) {
            System.out.println("Empty input illegal");
            return readNonEmptyLine(echoInput);
        } else {
            return res;
        }
    }

    // java don't have tailrec, so no stack safe
    private static BigDecimal readBigDecimal(String echoInput) {
        String input = readNonEmptyLine(echoInput);
        try {
            return new BigDecimal(input);
        } catch (Throwable e) {
            System.out.println("Not valid input");
            return readBigDecimal(echoInput);
        }
    }

    // java don't have tailrec, so no stack safe
    private static int readInt(String echoInput) {
        String input = readNonEmptyLine(echoInput);
        try {
            return Integer.parseInt(input);
        } catch (Throwable e) {
            System.out.println("Not valid input");
            return readInt(echoInput);
        }
    }

    public static void main(String[] args) {
        ShopItemSupplier itemSupplier1 = new ShopItemSupplier();
        itemSupplier1.setCompanyName(readNonEmptyLine("Input Item Supplier company name")); // "SellWoodChair"
        itemSupplier1.setCountry(readNonEmptyLine("Input Item Supplier country")); // "Ukraine"
        itemSupplier1.setPhone(readNonEmptyLine("Input Item Supplier phone")); // "+380931234567"

        ShopItemSupplier itemSupplier2 = new ShopItemSupplier("SellWoodTable", "Ukraine", "+380937654321");
        ShopItemSupplier itemSupplier3 = new ShopItemSupplier(itemSupplier2);

        itemSupplier3.setCompanyName("SellWoodTable(Other)");

        // -----------------------------------------
        ShopItem item1 = new ShopItem();
        item1.setName(readNonEmptyLine("Input Item name")); // "wood chair"
        item1.setPrice(readBigDecimal("Input Item price")); // "350"
        item1.setCount(readInt("Input Item count")); // 10

        ShopItem item2 = new ShopItem("wood table", BigDecimal.valueOf(920d), 2);

        ShopItem item3 = new ShopItem(item2);
        item3.setName("wood table other");
        item3.setCount(4);

        // -----------------------------------------
        System.out.println("-------------");
        System.out.println("Item supplier 1 short toString " + itemSupplier1.toStringState());
        System.out.println("Item supplier 1       toString " + itemSupplier1);
        System.out.println("Item supplier 2 short toString " + itemSupplier2.toStringState());
        System.out.println("Item supplier 2       toString " + itemSupplier2);
        System.out.println("Item supplier 3 short toString " + itemSupplier3.toStringState());
        System.out.println("Item supplier 3       toString " + itemSupplier3);


        System.out.println("-------------");
        System.out.println("Item 1 short toString " + item1.toStringState());
        System.out.println("Item 1       toString " + item1);
        System.out.println("Item 2 short toString " + item2.toStringState());
        System.out.println("Item 2       toString " + item2);
        System.out.println("Item 3 short toString " + item3.toStringState());
        System.out.println("Item 3       toString " + item3);
    }
}

