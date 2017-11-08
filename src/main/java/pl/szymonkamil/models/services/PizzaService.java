package pl.szymonkamil.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.szymonkamil.models.utils.Config;
import pl.szymonkamil.models.utils.HttpUtils;

public class PizzaService {

    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getPizzaService(){return ourInstance;}


    public void makeCall( String city){

        parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL+city+"&key="+Config.APP_ID));

    }

    private void parseJsonData(String text) {

        JSONObject root = new JSONObject(text);

        JSONArray results = root.getJSONArray("results");

        JSONObject restaurant;

        double rating;

        double maxrating = 0;

        for (int i = 0; i< results.length(); i++){

            restaurant = results.getJSONObject(i);

            rating = restaurant.getDouble("rating");
            

            if (rating>maxrating){
                maxrating = rating;
            }


        }
        System.out.println(maxrating);

        //kom









    }
}
