package Person;

import Assignments.Game;

import java.util.ArrayList;

/**
 * This class is used to store all the users in the system.
 */
public class UserDatabase {
    private final ArrayList<User> users;
    private Integer userIDCounter;

    public UserDatabase() {
        users = new ArrayList<User>();
        userIDCounter = 0;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(Integer userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public void removeUser(Integer userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                users.remove(user);
                return;
            }
        }
        throw new IllegalArgumentException("User not found");
    }

    public Integer generateUserID() {
        return userIDCounter++;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void clearUsers() {
        users.clear();
    }

    @Override
    public String toString() {
        return "UserDatabase{" +
                "users=" + users +
                '}';
    }
}
