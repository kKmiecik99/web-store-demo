package pl.sda.intermediate25.application;

import lombok.Builder;
import lombok.Getter;

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
                .state(new CategoryState())
                .build();
    }

    public void changeState(boolean open, boolean selected){
        state.setOpen(open);
        state.setSelected(selected);
    }

    public void open(){
        state.setOpen(true);
    }

}
