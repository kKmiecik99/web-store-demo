package pl.sda.intermediate25;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.intermediate25.application.Category;
import pl.sda.intermediate25.application.CategoryDao;

import java.util.List;

class CategoryDaoTest {

    CategoryDao categoryDao = CategoryDao.getInstance();


    @Test
    void shouldProperlyPopulateParentIds() {
        int expectedParentId = 4;
        int childId = 6;

        List<Category> categories = categoryDao.getCategories();
        Category category = categories.stream()
                .filter(c -> c.getId().equals(childId))
                .findFirst()
                .orElseThrow(() -> new AssertionError());

        Assertions.assertEquals(expectedParentId, category.getParentId());
    }

    @Test
    void shouldProperlyPopulateParentIds2() {
        int expectedParentId = 4;
        int childId = 6;
        List<Category> categories = categoryDao.getCategories();
        Category category = categories.stream()
                .filter(c -> c.getId().equals(childId))
                .findFirst()
                .orElseThrow(() -> new AssertionError());

        Assertions.assertEquals(expectedParentId, category.getParentId());
    }

}
