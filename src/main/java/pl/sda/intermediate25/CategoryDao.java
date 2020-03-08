package pl.sda.intermediate25;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDao {

    private static CategoryDao instance;

    private List<Category> categories = new ArrayList<>();

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

    private List<Category> prepareCategories(){
        List<String> lines = readLinesFromFile();
        lines.stream()
                .map(line -> buildCategory(line));
        return null;
    }

    private Object buildCategory(String line) {
//        Category category=new Category();

        return null;
    }


    private List<String> readLinesFromFile (){
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
