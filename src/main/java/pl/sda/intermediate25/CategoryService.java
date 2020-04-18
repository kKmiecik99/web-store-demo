package pl.sda.intermediate25;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {

    private final CategoryDao categoryDao = CategoryDao.getInstance();

    public List<CategoryDto> findCategories(String categoryName) {
        if (categoryName == null) {
            throw new CategoryException("Category name is Null");
        }
        List<Category> categoryList = categoryDao.getCategories();
        List<CategoryDto> categoryDtoList = categoryList.stream()
                .map(category -> CategoryDto.toDto(category))
                .collect(Collectors.toList());
        markAsSelectedOrOpen(categoryName.trim(), categoryDtoList);
        return categoryDtoList;
    }

    private void markAsSelectedOrOpen(String categoryName, List<CategoryDto> categoryDtos) {
        categoryDtos.stream()
                .filter(categoryDto -> categoryDto.getCategoryName().toLowerCase().contains(categoryName.toLowerCase()))
                .peek(categoryDto -> categoryDto.changeState(true, true))
                .forEach(categoryDto -> markParentAsOpened(categoryDtos, categoryDto));
    }

    private void markParentAsOpened(List<CategoryDto> categoryDtos, CategoryDto category) {
        if (category.getParentId() == null) {
            return;
        }
        categoryDtos.stream()
                .filter(categoryDto -> categoryDto.getId().equals(category.getParentId()))
                .peek(categoryDto -> categoryDto.open())
                .forEach(categoryDto -> markParentAsOpened(categoryDtos, categoryDto));
    }

    private String cleanWhiteSpaces(String string) {
        return string.trim();
    }

}
