package Person;

public class Assignor extends User{

    public Assignor(String name, String email, String password, UserDatabase userDatabase) {
        super(name, email, password, userDatabase, UserType.ASSIGNOR);
    }
}
