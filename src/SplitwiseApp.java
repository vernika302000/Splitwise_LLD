import java.util.*;

public class SplitwiseApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        DisplayManager displayManager = new DisplayManager();
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scn = new Scanner(System.in);

        System.out.println("Please enter the number of users: ");
        int n = scn.nextInt();
        scn.nextLine();  // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of user " + (i + 1) + ":");
            String name = scn.nextLine();
            System.out.println("Enter the emailId of user " + (i + 1) + ":");
            String email = scn.nextLine();
            String userId = "user" + (i + 1);  // Use user-friendly ID
            User user = new User(userId, name, email);
            userManager.addUser(user);
        }

        String choice;
        do {
            System.out.println("Press 1 to add an expense, 2 to display the balance of any user, or 'q' to quit:");
            choice = scn.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Please enter the description of the expense:");
                    String desc = scn.nextLine();
                    System.out.println("Please enter the amount paid:");
                    double amount = scn.nextDouble();
                    scn.nextLine();  // Consume newline
                    System.out.println("Please enter your user id:");
                    String paidBy = scn.nextLine();

                    System.out.println("Please enter the number of users you want to share the expense with:");
                    int x = scn.nextInt();
                    scn.nextLine();  // Consume newline
                    List<User> shared = new ArrayList<>();

                    for (int i = 0; i < x; i++) {
                        System.out.println("Enter the user id of user " + (i + 1) + ":");
                        String id = scn.nextLine();
                        User userX = userManager.getUserById(id);
                        if (userX != null) {
                            shared.add(userX);
                        } else {
                            System.out.println("User with id " + id + " not found.");
                        }
                    }

                    Expense expenseX = new Expense(expenseManager.getLastExpenseId(), desc, amount, userManager.getUserById(paidBy), shared);
                    expenseManager.addExpense(expenseX);
                    System.out.println("Expense added successfully!");
                    break;

                case "2":
                    System.out.println("Enter the user id to display balances:");
                    String userId = scn.nextLine();
                    User user = userManager.getUserById(userId);
                    if (user != null) {
                        displayManager.showUserBalances(user, expenseManager);
                    } else {
                        System.out.println("User with id " + userId + " not found.");
                    }
                    break;

                case "q":
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!choice.equals("q"));

        scn.close();
    }
}
