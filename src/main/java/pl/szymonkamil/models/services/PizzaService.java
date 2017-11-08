package pl.szymonkamil.models.services;

import org.json.JSONObject;
import pl.szymonkamil.models.utils.Config;
import pl.szymonkamil.models.utils.HttpUtils;

public class PizzaService {


    void makeCall( String city){

        parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL+city+"@key="+Config.APP_ID));

    }

    private void parseJsonData(String text) {

        JSONObject root = new JSONObject(text);

        JSONObject main = root.getJSONObject("main");





    }
}
