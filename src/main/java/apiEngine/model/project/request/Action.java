package apiEngine.model.project.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter @Setter
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@NoArgsConstructor
@ToString
public class Action {

    private String type;
    private String url;
}
