import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

// CustomPizza类，用于表示定制披萨
class CustomPizza {
    // 披萨配料
    private String toppings;
    // 披萨价格
    private double price;

    // 构造函数
    public CustomPizza(String toppings, double price) {
        this.toppings = toppings;
        this.price = price;
    }

    // 获取配料的getter方法
    public String getToppings() {
        return toppings;
    }

    // 设置配料的setter方法
    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    // 获取价格的getter方法
    public double getPrice() {
        return price;
    }

    // 设置价格的setter方法
    public void setPrice(double price) {
        this.price = price;
    }

    // 重写toString方法，方便打印披萨信息
    @Override
    public String toString() {
        return "CustomPizza{" +
                "toppings='" + toppings + '\'' +
                ", price=" + price +
                '}';
    }
}

// HandleOrders类，用于处理订单相关操作
class HandleOrders {
    // 存储定制披萨的ArrayList
    ArrayList<CustomPizza> customPizzas = new ArrayList<>();

    // 显示所有定制披萨的方法
    public void displayCustomPizzas() {
        for (CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }
}

// OrderLogs类，用于处理订单日志的栈操作
class OrderLogs {
    // 存储订单日志的栈
    private Deque<String> orderLogs;

    // 构造函数，初始化栈
    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    // 添加订单日志的方法
    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    // 显示最近订单日志的方法
    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println("Most recent log entry: " + orderLogs.peek());
        } else {
            System.out.println("The log is empty.");
        }
    }

    // 获取并移除最上面订单日志的方法
    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        } else {
            System.out.println("The log is empty.");
            return null;
        }
    }

    // 移除所有订单日志的方法
    private void removeAllLogEntries() {
        orderLogs.clear();
        System.out.println("All log entries removed.");
    }

    // 检查订单日志是否为空的方法
    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    // 处理订单日志操作的方法
    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.print("Enter your choice (1 - 5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(orderLogs);
                    break;
                case 2:
                    mostRecentLogEntry();
                    break;
                case 3:
                    getOrderLog();
                    break;
                case 4:
                    removeAllLogEntries();
                    break;
                case 5:
                    if (orderLogsEmpty()) {
                        System.out.println("The log is completely empty");
                    } else {
                        System.out.println("The log is not completely empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

// PizzaOrderQueue类，用于处理披萨订单队列操作
class PizzaOrderQueue {
    // 存储披萨订单的队列
    private Queue<String> orderQueue;

    // 构造函数，初始化队列
    public PizzaOrderQueue() {
        orderQueue = new ArrayDeque<>();
    }

    // 添加披萨订单到队列的方法
    public void addOrder(String order) {
        orderQueue.add(order);
    }

    // 显示队列头部订单（即最早的订单）的方法
    private void displayNextOrder() {
        if (!orderQueue.isEmpty()) {
            System.out.println("Next order in queue: " + orderQueue.peek());
        } else {
            System.out.println("The order queue is empty.");
        }
    }

    // 移除并返回队列头部订单的方法
    private String processOrder() {
        if (!orderQueue.isEmpty()) {
            return orderQueue.poll();
        } else {
            System.out.println("The order queue is empty.");
            return null;
        }
    }

    // 检查订单队列是否为空的方法
    private boolean isQueueEmpty() {
        return orderQueue.isEmpty();
    }

    // 处理订单队列操作的方法
    public void handleQueue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with the order queue:");
            System.out.println("1. Add an order");
            System.out.println("2. Display the next order");
            System.out.println("3. Process an order");
            System.out.println("4. Check if the queue is empty");
            System.out.print("Enter your choice (1 - 4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the order details: ");
                    scanner.nextLine(); 
                    String order = scanner.nextLine();
                    addOrder(order);
                    break;
                case 2:
                    displayNextOrder();
                    break;
                case 3:
                    processOrder();
                    break;
                case 4:
                    if (isQueueEmpty()) {
                        System.out.println("The order queue is empty");
                    } else {
                        System.out.println("The order queue is not empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
