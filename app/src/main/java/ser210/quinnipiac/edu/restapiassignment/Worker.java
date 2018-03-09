package ser210.quinnipiac.edu.restapiassignment;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mattc on 3/6/18.
 * Worker class that takes does the API work
 */

public class Worker extends AsyncTask<String, String, String> {
    private MainActivity main;

    public Worker(MainActivity m) {
        main = m;
    }

    @Override
    //do in background through async task, to get the info from the API
    protected String doInBackground(String... strings) {
        String result;
        BufferedReader reader = null;
        HttpURLConnection urlConnection = null;

        if (strings[0].length() == 0) return null;

        try {
            URL url = new URL("https://simple-weather.p.mashape.com/weather?lat=" + strings[0] + "&lng=" + strings[1] + "&mashape-key=QlijkaYtjFmshRfBEls2ES0EyGCXp1TAKn5jsnXpCC1fzIjz3F");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream in = urlConnection.getInputStream();
            if (in == null) return null;
            reader = new BufferedReader(new InputStreamReader(in));
            String line;
            String msg = "";
            while ((line = reader.readLine()) != null) {
                msg += line + '\n';
            }
            if (msg.length() == 0) return null;
            return msg;
        } catch (Exception e) {
            Log.e("Exception e: ", e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (urlConnection != null)
                    urlConnection.disconnect();
            } catch (Exception e2) {
                Log.e("Exception e2: ", e2.getMessage());
            }
        }

        return "Weather API is having issues weathering your weather. Try again soon.";
    }

    @Override
    //After it goes through the do in background, it will do this
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //pass the string s into weather in main activity
        main.showWeather(s);
    }
}
