package apiEngine.model.project.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
public class UserDataParams {

    private String device;
    private String lang;
    private String url;
    private Object version;
    private String bannerText;



}
