package pl.sda.intermediate25.application;


import java.util.List;
import java.util.Map;

public class ApplicationController {

    private final CategoryService categoryService = new CategoryService();
    private final RegistrationValidator registrationValidator = new RegistrationValidator();
    private final RegistrationService registrationService = new RegistrationService();

    public void categoriesPage(String input) {
        List<CategoryDto> categories = categoryService.findCategories(input);
    }

    public void register(RegistrationDto registrationDto) {
        Map<String, String> validatedResultMap = registrationValidator.validateUserRegistration(registrationDto);
        if(validatedResultMap.isEmpty()){
            try {
                registrationService.register(registrationDto);
            } catch (UserExistsException e) {
                e.printStackTrace();
            }
        }
    }
}
