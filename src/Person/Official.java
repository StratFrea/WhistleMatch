package Person;

public class Official extends User{

    private Integer payRate;

    public Official(String name, String email, String password, UserDatabase userDatabase) {
        super(name, email, password, userDatabase);
    }
}
