package pl.sda.intermediate25;

import lombok.*;

@Data
public class Category {

    private Integer id;
    private String categoryName;
    private Integer depth;
    private Integer parentId;
}
