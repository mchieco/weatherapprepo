package ser210.quinnipiac.edu.restapiassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by mattc on 3/6/18.
 * Main Class that contains the backend for the first screen
 */
public class MainActivity extends AppCompatActivity {
    private String latout;
    private String longout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when the button is clicked, it takes the info from the inputs and sends them to the worker
    protected void onSunClick(View view) {
        EditText etlat = (EditText) findViewById(R.id.latitude);
        latout = etlat.getText().toString();
        EditText etlong = (EditText) findViewById(R.id.longitude);
        longout = etlong.getText().toString();
        view.setEnabled(false);
        //create worker and execute with the parameters
        new Worker(this).execute(latout,longout);
    }
    //take the weather from the worker and move it through intent to next screen
    public void showWeather(String weather) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("weather", weather);
        startActivity(intent);
        ((ImageButton)findViewById(R.id.sunbutton)).setEnabled(true);
    }
}
