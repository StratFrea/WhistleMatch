import Person.*;
import IO.*;

public class Main {

    public static void main(String[] args) {
        // Create a new UserDatabase
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUser(new Official("John Doe", "jdoe@mail.com", "password", userDatabase));
        userDatabase.addUser(new Assignor("Jane Doe", "janedoe@mail.com", "password", userDatabase));


        // Save the UserDatabase to a file
        FileIO.saveUsers("users.csv", userDatabase);
        userDatabase.clearUsers();
        FileIO.loadUsers("users.csv", userDatabase);
        System.out.println(userDatabase);

    }
}
