package pl.sda.intermediate25.application;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserDao {

    final private List<User> usersCache = new ArrayList<>();

    public void addUser(User user) {
        usersCache.add(user);
        log.info("USER ADDED TO CACHE" + user.toString());
    }

    public boolean checkIfUserExists(RegistrationDto rsDto) {
        return usersCache.stream()
                .anyMatch(user -> user.getEMail().equalsIgnoreCase(rsDto.getEMail()));
    }

}
