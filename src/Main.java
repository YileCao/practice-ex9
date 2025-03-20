import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HandleOrders handleOrders = new HandleOrders();
        OrderLogs orderLogs = new OrderLogs();
        PizzaOrderQueue pizzaOrderQueue = new PizzaOrderQueue();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Order a custom pizza");
            System.out.println("2. Display custom pizzas");
            System.out.println("3. Handle order logs");
            System.out.println("4. Handle pizza order queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1 - 5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter pizza toppings: ");
                    scanner.nextLine(); 
                    String toppings = scanner.nextLine();
                    System.out.print("Enter pizza price: ");
                    double price = scanner.nextDouble();
                    CustomPizza customPizza = new CustomPizza(toppings, price);
                    handleOrders.customPizzas.add(customPizza);
                    break;
                case 2:
                    handleOrders.displayCustomPizzas();
                    break;
                case 3:
                    orderLogs.handleLogs();
                    break;
                case 4:
                    pizzaOrderQueue.handleQueue();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}