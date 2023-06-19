package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Settings {
    public JSONObject getEnvironment(){
        try{FileReader reader = new FileReader("src/main/resources/environment.json");
        JSONParser jsonParser = new JSONParser();
        JSONObject object = (JSONObject) jsonParser.parse(reader);
        return (JSONObject) object;
         } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
        }
    

    public  String getUsername() throws JSONException, IOException, ParseException{
        JSONObject username = (JSONObject)getEnvironment().get("salesforce");
        return (String) username.get("username");
    }

     public  String getPassword() throws JSONException, IOException, ParseException{
        JSONObject username = (JSONObject)getEnvironment().get("salesforce");
        return (String) username.get("password");
    }

}
