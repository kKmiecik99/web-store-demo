package pl.sda.intermediate25.application;

public class UserExistsException extends Exception {

    UserExistsException(String email) {
        super("User already exists" + email);
    }
}
