package apiEngine.model.project.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
//@NoArgsConstructor
@ToString
public class User {

    private Boolean enabled;
    private List<UserDataParams> userDataParams = null;
    private String type;
    private Action action;
    private Double doubleT;
    private Integer integerI;
    private Integer integerCount1;
    private Integer integerCount2;
    private Integer integerCount3;
    private Integer integerCount4;
    private Integer integerCount5;
    private Integer integerCount6;
    private Integer integerCount7;
    private Boolean closeButton;
    private Boolean firstLogin;
    private String name;
    private long longDate1;
    private long longDate2;
    private Integer priority;
    private String string1;


    //---------------------Campaign
    public static String url = "";
    public static String web = "";
    public static String tablet = "";
    public static String dWeb = "";
    public static String dMobile = "";
    public static String android = "";
    public static String ios = "";
    public static String iosM = "";
    public static String en = "en";
    public static String de = "de";
    public static String ar = "ar";
    //----------------------Action
    public static String ex = "";
    public static String ac = "";


    public static User jsonCreateCampaign() {
        //Create JSON body
        List<UserDataParams> campaignDataParams = new ArrayList<>();
        campaignDataParams.add(new UserDataParams(web, en, url, null, null));
        campaignDataParams.add(new UserDataParams(tablet, en, url, null, null));
        campaignDataParams.add(new UserDataParams(dWeb, en, url, null, null));
        campaignDataParams.add(new UserDataParams(dMobile, en, url, null, null));
        campaignDataParams.add(new UserDataParams(android, en, url, null, null));
        campaignDataParams.add(new UserDataParams(ios, en, url, null, null));
        campaignDataParams.add(new UserDataParams(iosM, en, url, null, null));

        var action = Action.builder()
                .type(ex)
                .url(ac)
                .build();
        var campaign = User.builder()
                .enabled(true)
                .userDataParams(campaignDataParams)
                .type("")
                .action(action)
                .doubleT(1.0)
                .integerI(0)
                .integerCount1(0)
                .integerCount2(0)
                .integerCount3(0)
                .integerCount4(0)
                .integerCount5(0)
                .integerCount6(0)
                .integerCount7(0)
                .closeButton(true)
                .firstLogin(false)
                .name("")
                .longDate1(0)
                .longDate2(0)
                .priority(0)
                .string1("")
                .build();
        return campaign;
    }


    public static User updateCampaignJson() {
        //Create JSON body
        List<UserDataParams> userDataParams = new ArrayList<>();
        userDataParams.add(new UserDataParams(web, en, url, null, null));
        userDataParams.add(new UserDataParams(tablet, en, url, null, null));
        userDataParams.add(new UserDataParams(dWeb, en, url, null, null));
        userDataParams.add(new UserDataParams(dMobile, en, url, null, null));
        userDataParams.add(new UserDataParams(dMobile, en, url, null, null));
        userDataParams.add(new UserDataParams(ios, en, url, null, null));
        userDataParams.add(new UserDataParams(iosM, en, url, null, null));
        var action = Action.builder()
                .type(ex)
                .url(ac)
                .build();

        var campaign = User.builder()
                .enabled(true)
                .userDataParams(userDataParams)
                .type("ALL")
                .action(action)
                .doubleT(50.0)
                .integerI(30000)
                .integerCount1(1)
                .integerCount2(1000)
                .integerCount3(0)
                .integerCount4(0)
                .integerCount5(0)
                .integerCount6(0)
                .integerCount7(0)
                .closeButton(true)
                .firstLogin(false)
                .name("test")
                .longDate1(1588579466643L)
                .longDate2(1588579467789L)
                .priority(5)
                .string1("IMAGE")
                .build();
        return campaign;
    }


}
