import java.util.*;

public class UserManager
{
    public List<User> users;
    public UserManager()
    {
        users = new ArrayList<>();
    }
    public void addUser(User user)
    {
        users.add(user);
    }
    public User getUserById(String userId)
    {
        for(User user : users)
        {
            if(user.getUserId().equals(userId))
                return user;
        }
        return null;
    }
}
