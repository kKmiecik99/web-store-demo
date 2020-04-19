package pl.sda.intermediate25.application;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

    private final String firstNameRegex = "^[A-Z]{1}[a-z]{2,}$";
    private final String lastNameRegex = "^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$";
    private final String birthDayRegex = "^(19|20)[0-9]{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";

    public Map<String, String> validateUserRegistration(RegistrationDto registrationDto) {
        final Map<String, String> validatedMap = new HashMap<>();
        if (registrationDto.getFirstName() == null || !registrationDto.getFirstName().matches(firstNameRegex)) {
            validatedMap.put("firstNameValRes", "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe");
        }
        if (registrationDto.getLastName() == null || !registrationDto.getLastName().matches(lastNameRegex)) {
            validatedMap.put("lastNameValRes", "Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe" +
                    "    + dopuszczenie \"-\" i drugiego członu z dużej litery\n");
        }
        if (registrationDto.getBirthDate() == null || !registrationDto.getBirthDate().matches(birthDayRegex)) {
            validatedMap.put("birthDateValRes", "Zły format. Data urodzin powinna być podana w formacie RRRR-MM-DD");
        }
        return validatedMap;
    }


    /*
    * Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe.
    Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe
    + dopuszczenie "-" i drugiego członu z dużej litery
    Zły format. Kod pocztowy powinien mieć format 12-345.
    Podanie nazwy kraju jest wymagane.
    Podanie nazwy ulicy jest wymagane.
    Zły format. Data urodzin powinna być podana w formacie RRRR-MM-DD
    Zły format. Numer PESEL powinien składać się z 11 cyfr.
    Zły format adresu email
    Hasło jest wymagane. Musi zawierać od 10 do 20 znaków.
    Minimum jedna duża, jedna mała litera i jedna cyfra.
    Zły format. Numer telefonu powinien składać się z 9 cyfr.
    -> możliwa opcja z "+48" na początku",
    xxx xxx xxx (spacje) lub xxx-xxx-xxx
    +48 123123123
    +48 123-123-123
    123123123
    123-123-123
    Collapse

*/

}
