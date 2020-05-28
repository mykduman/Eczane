package com.example.eczane;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;




public class MainActivity extends AppCompatActivity {
    HttpHandler sh = new HttpHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class HttpHandler {

        private static final String TAG = HttpHandler.class.getSimpleName();

        public HttpHandler() {
        }
        public String makeServiceCall(String reqUrl) {
            String response = null;
            try {
                URL url = new URL(reqUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("https://api.collectapi.com/health/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara");
                // read the response
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(("https://api.collectapi.com/health/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara"));
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException: " + e.getMessage());
            } catch (ProtocolException e) {
                Log.e(TAG, "ProtocolException: " + e.getMessage());
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
            return response;
        }
        HttpResponse<String> response = Unirest.get("https://api.collectapi.com/health/dutyPharmacy?ilce=%C3%87ankaya&il=Ankara")
                .header("content-type", "application/json")
                .header("authorization", "apikey your_token")
                .asString();
}
}