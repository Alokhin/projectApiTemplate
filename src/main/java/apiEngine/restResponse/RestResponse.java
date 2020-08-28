package apiEngine.restResponse;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

public class RestResponse<T> implements IRestResponse<T>  {
    private T data;
    private Response response;
    private Exception e;

    public RestResponse(Class<T> t, Response response) {
        this.response = response;
        try{
            this.data = t.newInstance();
        }catch (Exception e){
            throw new RuntimeException("There should be a default constructor in the Response POJO");
        }
    }

    public String getContent() {
        return response.getBody().asString();
    }


    public int getStatusCode() {
        return response.getStatusCode();
    }



    public boolean isSuccessful() {
        int code = response.getStatusCode();
        if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
        return false;
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }


    public T getBody() {
        try {
            data = (T) response.getBody().as(data.getClass());
        }catch (Exception e) {
            this.e=e;
        }
        return data;
    }

    public Exception getException() {
        return e;
    }


    public void sizeJsonBody(Response response, int isEqualTo) {
        String responseBodyString = response.getBody().asString();
        System.out.println(responseBodyString);
        assertThat(from(responseBodyString).getList("$").size()).isEqualTo(isEqualTo);
    }

    public static List<String> customersIds(String... ids) {
        List<String> customersIds = new ArrayList<>();
        for (int i =0; i<ids.length; i++){
            customersIds.add(ids[i]);
        }
        return customersIds;
    }
}
