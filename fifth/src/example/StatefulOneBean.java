package example;

import wait.User;

import javax.ejb.Stateful;

@Stateful(name = "StatefulOneEJB")
public class StatefulOneBean implements RemoteOne{
    public StatefulOneBean() {
    }

    @Override
    public User getUserByName(String username) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}
