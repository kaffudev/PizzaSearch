package pl.szymonkamil.models.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
    public static String makeHttpRequest(String url){

        try {
            URL urlClass = new URL(url);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
