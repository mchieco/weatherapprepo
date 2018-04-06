package ser210.quinnipiac.edu.restapiassignment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by mattc on 4/5/2018.
 */
public class DetailFragment extends Fragment {
    private String weatherinfo;
    private View thisview;
    private LinearLayout ll;
    public DetailFragment() {
        // Required empty public constructor
    }

    //creates the view and changes the picture based on the weather
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        ll = (LinearLayout) v.findViewById(R.id.fragdeat);
        ll.setBackgroundResource(MainActivity.backgroundCheck());
        ImageView iv = (ImageView) v.findViewById(R.id.weatherimage);
        TextView tw = (TextView) v.findViewById(R.id.weatherinfo);
        weatherinfo = getActivity().getIntent().getStringExtra("weather");
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
        return v;
    }

}
