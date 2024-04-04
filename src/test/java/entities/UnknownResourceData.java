package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class UnknownResourceData {
    private int id;
    private String name;
    private int year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
