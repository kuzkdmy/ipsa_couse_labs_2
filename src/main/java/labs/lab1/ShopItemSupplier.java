package labs.lab1;

public class ShopItemSupplier {
    private String companyName;
    private String country;
    private String phone;

    public ShopItemSupplier() {
    }

    public ShopItemSupplier(String companyName, String country, String phone) {
        this.companyName = companyName;
        this.country = country;
        this.phone = phone;
    }

    public ShopItemSupplier(ShopItemSupplier other) {
        this.companyName = other.companyName;
        this.country = other.country;
        this.phone = other.phone;
    }

    public ShopItemSupplier withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toStringState() {
        return "companyName='" + companyName + '\'' + ", country='" + country + '\'' + ", phone='" + phone + '\'';
    }

    @Override
    public String toString() {
        return "ShopItemSupplier{companyName='" + companyName + '\'' + '}';
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        System.out.println("java finalizer called on " + this);
        super.finalize();
    }
}
