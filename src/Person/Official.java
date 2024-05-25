package Person;

public class Official extends User{

    private double payRate;


    public Official(String name, String email, String password, UserDatabase userDatabase) {
        super(name, email, password, userDatabase, UserType.OFFICIAL);
    }
}
