import java.util.*;

public class ExpenseManager
{
    public List<Expense> expenses;
    public Map<String , Map<String,Double>> userBalances;
    public ExpenseManager()
    {
        expenses = new ArrayList<>();
        userBalances = new HashMap<>();
    }
    public void addExpense(Expense expense)
    {
        expenses.add(expense);
        updateBalances(expense);
    }
    public void updateBalances(Expense expense)
    {
        double share = expense.getAmount()/expense.getSharedWith().size();
        for(User user : expense.SharedWith)
        {
            if (!user.getUserId().equals(expense.getPaidBy().getUserId())) {
                userBalances.computeIfAbsent(user.getUserId(), k -> new HashMap<>())
                        .merge(expense.getPaidBy().getUserId(), share, Double::sum);
            }
        }
    }
    public Map<String, Double> getUserBalances(User user) {
        return userBalances.getOrDefault(user.getUserId(), new HashMap<>());
    }
    public String getLastExpenseId()
    {
        return String.valueOf(expenses.size()+1);
    }
}
