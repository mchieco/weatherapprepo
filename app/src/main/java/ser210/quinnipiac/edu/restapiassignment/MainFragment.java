package ser210.quinnipiac.edu.restapiassignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */

public class MainFragment extends Fragment {
    private LinearLayout ll;
    private String latout;
    private String longout;
    private DatabaseHelper myDB;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_main,
                container, false);
        setHasOptionsMenu(true);
        ll = (LinearLayout) view.findViewById(R.id.fragmain);
        ll.setBackgroundResource(MainActivity.backgroundCheck());
        if (getActivity().getIntent().hasExtra("favfrag")) {
            Intent intent = new Intent(getActivity(), FavoritesActivity.class);
            startActivity(intent);
        }
        ImageButton button = (ImageButton) view.findViewById(R.id.sunbutton);
        myDB = new DatabaseHelper(getContext());
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v = view;
                EditText etlat = (EditText) v.findViewById(R.id.latitude);
                latout = etlat.getText().toString();
                EditText etlong = (EditText) v.findViewById(R.id.longitude);
                longout = etlong.getText().toString();
                v.setEnabled(false);
                workerPower();
            }
        });
        return view;
    }

    public void workerPower() {
                new Worker(this).execute(latout,longout);

    }
    public void showWeather(String weather) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("weather", weather);
        startActivity(intent);
        ((ImageButton)getView().findViewById(R.id.sunbutton)).setEnabled(true);
    }

    public void onResume() {
        super.onResume();
        ll.setBackgroundResource(MainActivity.backgroundCheck());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                //Code to run when the settings item is clicked
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.displayfavorites:
                Intent intentfav = new Intent(getActivity(), FavoritesActivity.class);
                startActivity(intentfav);
                //Code to run when the display favorites is clicked
                return true;
            case R.id.addtofavorites:
                EditText etlat = (EditText) getView().findViewById(R.id.latitude);
                latout = etlat.getText().toString();
                EditText etlong = (EditText) getView().findViewById(R.id.longitude);
                longout = etlong.getText().toString();
                String newEntry = "Latitude  " +latout + "         " + "Longitude  " + longout;
                addData(newEntry);
                //Code to run when the display favorites is clicked
                return true;
            case R.id.linkcity:
                Intent intentlink = new Intent(getActivity(), LinkCityActivity.class);
                startActivity(intentlink);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(getActivity(), "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        }



    }


}
