package apiEngine.model.project.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
//@ToString
public class UserResponse {

    private int id;
    private boolean enabled;
    private String type;
    private double opacity;
    private int duration;
    private int intCount;
    private int intCount2;
    private int intCount3;
    private int intCount4;
    private int intCount5;
    private int intCount6;
    private int intCount7;
    private boolean closeButton;
    private boolean firstLogin;
    private int intCount8;


}
