package assignments;
import java.util.List;
public interface UserDao {
    void addUser(User user);
    List<User> list();
}
