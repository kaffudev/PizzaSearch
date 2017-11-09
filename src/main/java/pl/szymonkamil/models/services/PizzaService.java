package pl.szymonkamil.models.services;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.szymonkamil.models.utils.Config;
import pl.szymonkamil.models.utils.HttpUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PizzaService {


    private static PizzaService ourInstance = new PizzaService();

    public static PizzaService getPizzaService(){return ourInstance;}

    private List<PizzaObserver> observers;

    private PizzaService() {
        observers = new ArrayList<>();
    }

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void registerObserver(PizzaObserver observer){
        observers.add(observer);
    }

    public void notifyObservers(PizzaModel model){
        for (PizzaObserver observer : observers) {
            observer.onPizzaUpdate(model);
        }
    }


    public void makeCall(String city){
        executorService.execute(()->
            parseJsonData(HttpUtils.makeHttpRequest(Config.APP_URL+city+"&key="+Config.APP_ID)));

    }

    private void parseJsonData(String text) {

        JSONObject root = new JSONObject(text);

        JSONArray results = root.getJSONArray("results");

        JSONObject restaurant;

        double rating;
        double maxrating = 0;

        String adress = "";
        String name = "";

        for (int i = 0; i < results.length(); i++){

            restaurant = results.getJSONObject(i);

            rating = restaurant.getDouble("rating");

            if (rating>maxrating){
                maxrating = rating;
                adress = restaurant.getString("formatted_address");
                name = restaurant.getString("name");
            }

        }
        PizzaModel pizzaModel = new PizzaModel(adress,maxrating,name);



        notifyObservers(pizzaModel);









    }
}
