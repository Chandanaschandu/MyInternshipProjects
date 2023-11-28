import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Expense> expenses = new ArrayList<>();
    private static final Map<String, Double> categoryTotals = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewExpenseSummaries();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nExpense Tracker Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Expense Summaries");
        System.out.println("4. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }
    //Adding expenses using addexpense method
    private static void addExpense() {
        System.out.println("\nAdd Expense:");
        System.out.print("Description: ");
        String description = input.next();

        System.out.print("Amount: ");
        double amount = input.nextDouble();

        System.out.print("Category: ");
        String category = input.next();

        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);

        // Update category totals
        categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);

        System.out.println("Expense added successfully!");
    }
// View expense prints the added expenses
    public static void viewExpenses() {
        System.out.println("\nExpenses:");
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }
//sum of expenses
    public static void viewExpenseSummaries() {
        System.out.println("\nExpense Summaries:");
        if (categoryTotals.isEmpty()) {
            System.out.println("No expense summaries available.");
        } else {
            for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
                System.out.println("Category: " + entry.getKey() + ", Total: " + entry.getValue());
            }
        }
    }

    // Expense class to represent individual expenses
    public static class Expense {
        private String description;
        private double amount;
        private String category;

        public Expense(String description, double amount, String category) {
            this.description = description;
            this.amount = amount;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Description: " + description + ", Amount: " + amount + ", Category: " + category;
        }
    }
}
