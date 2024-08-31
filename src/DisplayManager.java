import java.util.*;

public class DisplayManager {
    public void showUserBalances(User user, ExpenseManager expenseManager) {
        Map<String, Double> balances = expenseManager.getUserBalances(user);
        if (balances.isEmpty()) {
            System.out.println(user.getName() + " has no balances.");
            return;
        }

        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            System.out.println(user.getName() + " owes " + entry.getValue() + " to User ID: " + entry.getKey());
        }
    }
}