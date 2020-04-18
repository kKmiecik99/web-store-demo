package pl.sda.intermediate25;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class CategoryDto { //DTO: Data Transfer Object

    private Integer id;
    private String categoryName;
    private Integer parentId;
    private CategoryState state;

    public static CategoryDto toDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .parentId(category.getParentId())
                .build();
    }

    public void changeState(boolean open, boolean selected){

    }

}
