package pl.sda.intermediate25.application;


import java.util.List;

public class ApplicationController {

    private final CategoryService categoryService = new CategoryService();

    public void categoriesPage(String input) {
        List<CategoryDto> categories = categoryService.findCategories(input);
    }
}
