package ser210.quinnipiac.edu.restapiassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mattc on 3/6/18.
 * The back end second screen that is displayed
 */

public class DetailActivity extends AppCompatActivity {
    private String weatherinfo;
    @Override
    //sets the text view to the weather from the intent
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView iv = (ImageView) findViewById(R.id.weatherimage);
        TextView tw = (TextView) findViewById(R.id.weatherinfo);
        weatherinfo = getIntent().getStringExtra("weather");
        tw.setText(weatherinfo);
        if (weatherinfo.contains("Cloudy")) {
            iv.setImageResource(R.drawable.clouds);
        } else if (weatherinfo.contains("Sunny")) {
            iv.setImageResource(R.drawable.sunpic);
        } else if (weatherinfo.contains("Snow")) {
            iv.setImageResource(R.drawable.snowpic);
        } else if (weatherinfo.contains("Rain")) {
            iv.setImageResource(R.drawable.rainpic);
        } else if (weatherinfo.contains("Showers")) {
            iv.setImageResource(R.drawable.rainpic);
        } else if (weatherinfo.contains("Unknown weather")) {
            iv.setImageResource(R.drawable.shrugpic);
        }
     }
}
