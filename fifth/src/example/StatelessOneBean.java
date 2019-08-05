package example;

import wait.User;

import javax.ejb.Stateless;

@Stateless(name = "StatelessOneEJB")
public class StatelessOneBean implements RemoteOne{
    public StatelessOneBean() {
    }

    @Override
    public User getUserByName(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
