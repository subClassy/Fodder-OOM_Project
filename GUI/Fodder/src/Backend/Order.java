package Backend;
import java.util.ArrayList;

public class Order {
    private ArrayList<FoodItem> orderList;

    Order() {
        orderList = new ArrayList<FoodItem>();
        orderList.add(new FastFood("Hakka Noodles", 160));
        orderList.add(new FastFood("Golden Stir Fried Babycorn", 180));
        orderList.add(new FastFood("Chicken Masala", 250));
        orderList.add(new FastFood("Regular Pizza", 250));
        orderList.add(new FastFood("Continental Sizzler", 350));
        orderList.add(new NorthIndianFood("Chicken Butter Masala", 320));
        orderList.add(new NorthIndianFood("Kadhai Paneer", 250));
        orderList.add(new NorthIndianFood("Vegetable Jalfrezi", 220));
        orderList.add(new NorthIndianFood("Dal Makhani", 220));
        orderList.add(new NorthIndianFood("Butter Naan", 60));
        orderList.add(new SouthIndianFood("Masala Dosa", 145));
        orderList.add(new SouthIndianFood("Rava Masala Dosa", 165));
        orderList.add(new SouthIndianFood("Vegetable Uttapam", 160));
        orderList.add(new SouthIndianFood("Rava Idli", 125));
        orderList.add(new SouthIndianFood("Masala Vada", 130));
        orderList.add(new PunjabiFood("Sarson Saag", 140));
        orderList.add(new PunjabiFood("Kadi Pakoda", 100));
        orderList.add(new PunjabiFood("Punjabi Kheer", 150));
        orderList.add(new PunjabiFood("Cholle Bhature", 120));
        orderList.add(new PunjabiFood("Makki ki Roti", 30));
        orderList.add(new GujratiFood("Rasawala Bataka", 100));
        orderList.add(new GujratiFood("Khichdi", 90));
        orderList.add(new GujratiFood("Shrikhand", 150));
        orderList.add(new GujratiFood("Malpuva", 150));
        orderList.add(new GujratiFood("Besan Gatta", 125));
    }

    public ArrayList<FoodItem> getOrderList() {
        return orderList;
    }
}

class FastFood extends FoodItem {
    
    FastFood(String name, int price) {
        super(name, price);
    }
}

class NorthIndianFood extends FoodItem {
    
    NorthIndianFood(String name, int price) {
        super(name, price);
    }
}

class SouthIndianFood extends FoodItem {
    
    SouthIndianFood(String name, int price) {
        super(name, price);
    }
}

class PunjabiFood extends FoodItem {
    
    PunjabiFood(String name, int price) {
        super(name, price);
    }
}

class GujratiFood extends FoodItem {
    
    GujratiFood(String name, int price) {
        super(name, price);
    }
}
