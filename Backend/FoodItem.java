package Backend;

public class FoodItem {
    private int price, quantity;
    private String name;

// Init Block 
    {
        this.quantity = 0;
    }

// Constructor
    FoodItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

// Getter Methods
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

// Setter Methods
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
