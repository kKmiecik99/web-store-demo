package pl.sda.intermediate25.application;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category { //encja (entity)

    private Integer id;
    private String categoryName;
    private Integer depth;
    private Integer parentId;

}
