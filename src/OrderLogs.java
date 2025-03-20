import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class OrderLogs {
    private Deque<String> orderLogs;

    public OrderLogs() {
        this.orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println(orderLogs.peek());
        } else {
            System.out.println("The log is empty.");
        }
    }

    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        }
        return null;
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    private void displayOrderLogs() {
        for (String log : orderLogs) {
            System.out.println(log);
        }
    }

    public void handleLogs() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose what you want to do with order logs:");
                System.out.println("1. Display all the logs");
                System.out.println("2. Display the most recent logs");
                System.out.println("3. Remove a log entry");
                System.out.println("4. Remove all log entries");
                System.out.println("5. Check if the log is completely empty");
                System.out.print("Enter your choice (1– 5): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        displayOrderLogs();
                        break;
                    case 2:
                        mostRecentLogEntry();
                        break;
                    case 3:
                        if (!orderLogsEmpty()) {
                            System.out.println("Removed log: " + getOrderLog());
                        } else {
                            System.out.println("The log is empty.");
                        }
                        break;
                    case 4:
                        removeAllLogEntries();
                        System.out.println("All log entries removed.");
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
}

class PizzaOrderQueue {
    private Queue<String> pizzaOrders;

    public PizzaOrderQueue() {
        this.pizzaOrders = new LinkedList<>();
    }

    public void addOrder(String order) {
        pizzaOrders.add(order);
        System.out.println("Order added: " + order);
    }

    private String processNextOrder() {
        if (!pizzaOrders.isEmpty()) {
            return pizzaOrders.poll();
        }
        return null;
    }

    private void displayAllOrders() {
        if (pizzaOrders.isEmpty()) {
            System.out.println("There are no orders in the queue.");
        } else {
            for (String order : pizzaOrders) {
                System.out.println(order);
            }
        }
    }

    private boolean isQueueEmpty() {
        return pizzaOrders.isEmpty();
    }

    public void handleOrders() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Choose what you want to do with pizza orders:");
                System.out.println("1. Add a new order");
                System.out.println("2. Process the next order");
                System.out.println("3. Display all orders");
                System.out.println("4. Check if the order queue is empty");
                System.out.print("Enter your choice (1– 4): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter the order details: ");
                        String order = scanner.nextLine();
                        addOrder(order);
                        break;
                    case 2:
                        if (!isQueueEmpty()) {
                            System.out.println("Processing order: " + processNextOrder());
                        } else {
                            System.out.println("There are no orders in the queue.");
                        }
                        break;
                    case 3:
                        displayAllOrders();
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
}

