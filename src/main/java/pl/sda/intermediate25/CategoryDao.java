package pl.sda.intermediate25;

import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CategoryDao {

    private static CategoryDao instance;
    @Getter
    private List<Category> categories = prepareCategories();

    private CategoryDao() {
    }

    public static CategoryDao getInstance() {
        if (instance == null) {
            synchronized (CategoryDao.class) {
                if (instance == null) {
                    instance = new CategoryDao();
                }
            }
        }
        return instance;
    }

    private List<Category> prepareCategories() {
        AtomicInteger counterForId = new AtomicInteger(1);
        List<String> lines = readLinesFromFile();
        List<Category> innerCategories = lines.stream()
                .map(line -> buildCategory(line, counterForId.getAndIncrement()))
                .collect(Collectors.toList());
        Map<Integer, List<Category>> categoriesMap = generateCategoryTree(innerCategories);
        populateParentId(categoriesMap, 1); //nie obslugujemy poziomu 0, ponieważ Integer domyślnie jest nullem
        return innerCategories;
    }

    private void populateParentId(Map<Integer, List<Category>> categoriesMap, int currentDepth) {
        if (!categoriesMap.containsKey(currentDepth)) {
            return;
        }
        List<Category> childrenList = categoriesMap.get(currentDepth);
        List<Category> potentialParentList = categoriesMap.get(currentDepth - 1);
        for (Category child : childrenList) {
            Integer parentId = potentialParentList.stream()
                    .map(p -> p.getId())
                    .filter(id -> id < child.getId())
                    .sorted(Comparator.reverseOrder())
                    .findFirst()
                    .orElse(null);
            child.setParentId(parentId);
        }
        populateParentId(categoriesMap, currentDepth + 1);
    }

    private Map<Integer, List<Category>> generateCategoryTree(List<Category> list) {
        return list.stream()
                .collect(Collectors.groupingBy(e -> e.getDepth()));
    }


    private Category buildCategory(String line, int counter) {
        Category category = Category.builder()
                .id(counter)
                .categoryName(line.trim())
                .depth(spaceCounter(line))
                .build();
        return category;
    }

    private Integer spaceCounter(String line) {
        if (!line.startsWith(" ")) {
            return 0;
        }
        String[] split = line.split("\\S+");
        return split[0].length();
    }


    private List<String> readLinesFromFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("kategorie.txt");
        try {
            return Files.readAllLines(Paths.get(url.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
