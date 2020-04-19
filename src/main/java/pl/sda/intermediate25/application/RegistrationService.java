package pl.sda.intermediate25.application;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class RegistrationService {

    UserDao userDao = new UserDao();

    public void register(RegistrationDto registrationDto) throws UserExistsException {
        if (userDao.checkIfUserExists(registrationDto)) {
            throw new UserExistsException(registrationDto.getEMail());
        }
        User user = User.builder()
                .uuid(UUID.randomUUID())
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .eMail(registrationDto.getEMail())
                .passwordHash(DigestUtils.sha512Hex(registrationDto.getPassword()))
                .city(registrationDto.getCity())
                .country(registrationDto.getCountry())
                .zipCode(registrationDto.getZipCode())
                .street(registrationDto.getStreet())
                .birthDate(registrationDto.getBirthDate())
                .phone(registrationDto.getPhone())
                .build();

        userDao.addUser(user);

    }
}
