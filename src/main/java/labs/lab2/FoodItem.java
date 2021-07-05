package labs.lab2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FoodItem extends ShopItem {
    private LocalDateTime createdAt;
    private LocalDateTime validTill;

    public FoodItem() {
        System.out.println("Визов конструктора FoodItem()");
    }

    public FoodItem(String name, BigDecimal price, int count, LocalDateTime createdAt, LocalDateTime validTill) {
        super(name, price, count);
        this.createdAt = createdAt;
        this.validTill = validTill;
    }

    public FoodItem(FoodItem other) {
        this(other.getName(), other.getPrice(), other.getCount(), other.createdAt, other.validTill);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDateTime validTill) {
        this.validTill = validTill;
    }

    @Override
    public String alarm() {
        // not pure function, bad programming style
        if (LocalDateTime.now().isAfter(validTill)) {
            return "товар непридатний для споживання";
        } else {
            return "товар придатний для споживання";
        }
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "createdAt=" + createdAt +
                ", validTill=" + validTill +
                '}' + super.toString();
    }
}
