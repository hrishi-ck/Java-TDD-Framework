package framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Settings {
    public JSONObject getEnvironment(){
        FileReader reader = null;
        try {
            reader = new FileReader("src/main/resources/environment.json");
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
