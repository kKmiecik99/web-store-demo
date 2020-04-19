package pl.sda.intermediate25;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.sda.intermediate25.application.CategoryDto;
import pl.sda.intermediate25.application.CategoryException;
import pl.sda.intermediate25.application.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    CategoryService cs = new CategoryService();

    @ParameterizedTest
    @ValueSource(strings = {"Książki","książki", " książki", "książki "})
    void shouldReturnProperCategory(String category) {
        //given
        String categoryForTest = category;
        //when
        List<CategoryDto> categories = cs.findCategories(categoryForTest);
        //then
        CategoryDto categoryDto1 = categories.stream()
                .filter(categoryDto -> categoryDto.getId().equals(1))
                .findFirst()
                .orElse(null);
        assertEquals(categoryDto1.getState().isOpen(), true);
        assertTrue(categoryDto1.getState().isSelected());
    }

    @Test
    void shouldThrow() {
        String categoryForTest = null;
        assertThrows(CategoryException.class, () -> cs.findCategories(categoryForTest));
    }

    @Test
    void shouldReturnSelectedAndOpened() {
        String categoryForTest = "Klasa";
        String[] array = {"Klasa pierwsza", "Klasa druga"};
        List<CategoryDto> categories = cs.findCategories(categoryForTest);
        List<CategoryDto> result = categories.stream()
                .filter(categoryDto -> categoryDto.getState().isOpen())
                .collect(Collectors.toList());

        List<String> resultTwo = result.stream()
                .filter(categoryDto -> categoryDto.getState().isSelected())
                .map(el -> el.getCategoryName())
                .collect(Collectors.toList());

        assertEquals(result.size(), 4);
        assertArrayEquals(resultTwo.toArray(), array);
    }

    @Test
    void shouldFindCategoryWithLowerCase(){
    }

}