import java.util.*;
public class User
{
    String userId;
    String Name;
    String Email;
    public User(String id,String name,String email)
    {
        this.userId = id;
        this.Name = name;
        this.Email = email;
    }
    public String getUserId()
    {
        return userId;
    }
    public String getName()
    {
        return Name;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setName(String name)
    {
        this.Name = name;
    }
    public void setEmail(String email)
    {
        this.Email = email;
    }
}
