package pl.sda.intermediate25;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

    private final CategoryDao categoryDao = CategoryDao.getInstance();

    public List<CategoryDto> findCategories(String categoryName) {
        List<Category> categoryList = categoryDao.getCategories();
        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(category -> CategoryDto.toDto(category))
                .collect(Collectors.toList());

        return null;
    }

    public void addCategory(String categoryName) {
    }

    private void markAsSelectedOrOpen(String categoryName, List<CategoryDto> categoryDtos){
        List<CategoryDto> matchedDtoList = categoryDtos.stream()
                .filter(categoryDto -> categoryDto.getCategoryName().contains(categoryName))
//                .peek(categoryDto -> categoryDto)
                .collect(Collectors.toList());


    }

}
