import java.util.*;

public class Expense
{
    String ExpenseId;
    String Description;
    double Amount;
    User PaidBy;
    List<User> SharedWith;
    public Expense(String e,String d,double amount,User paidBy,List<User> sharedwith)
    {
        this.ExpenseId = e;
        this.Description = d;
        this.Amount = amount;
        this.PaidBy= paidBy;
        this.SharedWith = sharedwith;
    }
    public String getExpenseId()
    {
        return this.ExpenseId;
    }
    public String getDescription()
    {
        return this.Description;
    }
    public void setDescription(String des)
    {
        this.Description = des;
    }
    public void setAmount(double amount)
    {
        this.Amount = amount;
    }
    public double getAmount()
    {
        return this.Amount;
    }
    public User getPaidBy()
    {
        return this.PaidBy;
    }
    public List<User> getSharedWith()
    {
        return this.SharedWith;
    }
}
