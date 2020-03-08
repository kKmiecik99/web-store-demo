package pl.sda.intermediate25;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    private Integer id;
    private String categoryName;
    private Integer depth;
    private Integer parentId;
}
