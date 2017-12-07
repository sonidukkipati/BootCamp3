import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.post;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;


public class JsonTest {

    @Test
    public void getRequestFindCapital() throws JSONException {

        //make get request to fetch capital of norway
        Response resp = get("https://restcountries.eu/rest/v1/region/africa");
        Response resp2 = post("https://restcountries.eu/rest/v1/region/africa");
        //Fetching response in JSON
        JSONArray jsonResponse = new JSONArray(resp.asString());
     //   JSONArray jsonPost = new JSONArray(resp2.asString());

       for (int i=0; i<jsonResponse.length(); i++)
        { int j=i+1;
            //System.out.println(jsonResponse.getJSONObject(i).names().getString(i));
            System.out.println(jsonResponse.getJSONObject(1).getString(jsonResponse.getJSONObject(i).names().getString(j)));
        }

        //Fetching value of capital parameter
        String capital = jsonResponse.getJSONObject(0).getString("name");
        String Alpha2Code = jsonResponse.getJSONObject(0).getString("alpha2Code");
        String Alpha3Code = jsonResponse.getJSONObject(0).getString("alpha3Code");

        //Asserting of capital, Alpha2Code, Alpha3Code
        try {
            Assert.assertEquals(capital, "Algeria"); 
            System.out.println("Capital = " + capital );

            Assert.assertEquals(Alpha2Code, "DZ");
            System.out.println("Alpha2Code = " + Alpha2Code );

            Assert.assertEquals(Alpha3Code, "DZA");
            System.out.println("Alpha3Code = " + Alpha3Code );
        }
        catch (Throwable t) {
        org.testng.Assert.fail("expected and actual result do not match");

    }

}

}