package apiEngine.model.project.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@NoArgsConstructor
//@ToString
public class Users {

    List<String> users;
}
