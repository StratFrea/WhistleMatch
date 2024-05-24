package Person;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User {
    private String name;
    private String email;
    private String hashedPassword;
    private Integer userID;
    private UserType type;

    public enum UserType {
        OFFICIAL,
        ASSIGNOR,
        ADMIN
    };

    public User(String name, String email, String password, UserDatabase userDatabase, UserType type){
        this.name = name;
        this.email = email;
        this.hashedPassword = hashPassword(password);
        this.userID = userDatabase.generateUserID();
    }

    /**
     * Gets name of user
     * @return String name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets email of user
     * @return String email of user
     */
    public String getEmail() {
        return email;
    }

    public Integer getUserID() {
        return userID;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
    public UserType getType() {return type;}

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashedPassword(String hashedPassword) {this.hashedPassword = hashedPassword;}
    public void setType(UserType type) {this.type = type;}
    

    /**
     * Hashes the password using SHA-256
     * @param password password to hash
     * @return hashed password
     */
    private String hashPassword(String password) {
        StringBuilder hexString;
        try {
            // Sets digest to SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Hashes the password into byte array
            byte[] bytePassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            // Converts byte array to hexadecimal string
            hexString = new StringBuilder(2 * bytePassword.length);
            for (byte b : bytePassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hexString.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
