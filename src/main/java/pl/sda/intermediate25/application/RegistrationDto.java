package pl.sda.intermediate25.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String city;
    private String country;
    private String zipCode;
    private String street;
    private String birthDate;
    private String phone;
    private boolean preferEmails;

}
