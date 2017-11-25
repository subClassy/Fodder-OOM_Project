package Backend;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Customer {
    private String name;
    private String email;
    private ArrayList<FoodItem> cart = new Order().getOrderList();


    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void updateCart(ArrayList<Integer> updatedOrder) {
        for (int i = 0; i < cart.size(); i++) {
            cart.get(i).setQuantity(updatedOrder.get(i));
        }
    }

    public ArrayList<FoodItem> getCart() {
        return cart.stream()
                .filter(p -> p.getQuantity() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (FoodItem item : cart) {
            totalPrice = totalPrice + (item.getPrice() * item.getQuantity());
        }

        return totalPrice;
    }

    public double getTaxedPrice() {
        int totalPrice = getTotalPrice();
        return ((double) totalPrice + (0.18 * totalPrice));
    }
    
    public String getTax() {
        return String.format("%.2f", 0.18 * getTotalPrice());
    }
}
