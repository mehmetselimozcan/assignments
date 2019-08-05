package example;

import wait.User;

import javax.ejb.Remote;

@Remote
public interface RemoteOne {
    User getUserByName(String username);
    void updateUser(User user);
}
