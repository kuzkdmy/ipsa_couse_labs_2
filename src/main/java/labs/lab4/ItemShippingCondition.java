package labs.lab4;

public enum ItemShippingCondition {
    CAUTION("обережно"),
    DO_NOT_CANT("не кантувати");

    final String displayValue;

    ItemShippingCondition(String displayValue) {
        this.displayValue = displayValue;
    }
}
