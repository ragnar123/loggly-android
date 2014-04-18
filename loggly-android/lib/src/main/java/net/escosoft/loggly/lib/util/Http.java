package net.escosoft.loggly.lib.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Victor on 18/04/2014.
 */
public class Http {

    public static boolean doPost(String url, Map<String, String> attributes) {

        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            //Iterate for all the attributes.
            Iterator<Map.Entry<String, String>> it = attributes.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> mapEntry = it.next();
                nameValuePairs.add(new BasicNameValuePair(mapEntry.getKey(), mapEntry.getValue()));
            }

            //Add them to the request.
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            return true;
        } catch (ClientProtocolException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}
