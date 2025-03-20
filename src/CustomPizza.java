import java.util.ArrayList;
import java.util.Scanner;

public class CustomPizza {
    private double price;
    private String toppings;

    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomPizza{toppings='" + toppings + "', price=" + price + "}";
    }



    public void takeOrder() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you want to order a custom pizza? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                
            } else {
                StringBuilder customPizzaToppings = new StringBuilder();
                double customPizzaPrice = 0;
                boolean moreToppings = true;
                while (moreToppings) {
                    System.out.println("Choose a topping (e.g., pepperoni, mushrooms): ");
                    String topping = scanner.nextLine();
                    customPizzaToppings.append(topping).append(", ");
                    
                    customPizzaPrice += 1;
                    System.out.println("Do you want to add more toppings? (yes/no)");
                    String more = scanner.nextLine();
                    if (!more.equalsIgnoreCase("yes")) {
                        moreToppings = false;
                    }
                }
                if (customPizzaToppings.length() > 0) {
                    customPizzaToppings.delete(customPizzaToppings.length() - 2, customPizzaToppings.length());
                }
                CustomPizza customPizza = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
                customPizzas.add(customPizza);
            }
        }
    }

    public void displayCustomPizzas() {
        CustomPizza[] customPizzas = null;
                for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    public static void main(String[] args) {
        HandleOrders orderHandler = new HandleOrders();
        orderHandler.takeOrder();
        orderHandler.displayCustomPizzas();
    }
}
    
