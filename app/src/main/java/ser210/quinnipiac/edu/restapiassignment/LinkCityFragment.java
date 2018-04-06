package ser210.quinnipiac.edu.restapiassignment;


import android.content.Intent;
import android.net.MailTo;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by mattc on 4/5/2018.
 */
public class LinkCityFragment extends Fragment {
    private LinearLayout ll;
    private String cityout;
    private String latout;
    private String longout;
    private DatabaseHelper myDB;

    public LinkCityFragment() {
        // Required empty public constructor
    }

    //Create the link fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_link_city, container, false);
        ll = (LinearLayout) view.findViewById(R.id.linkedlayout);
        ll.setBackgroundResource(MainActivity.backgroundCheck());
        myDB = new DatabaseHelper(getContext());
        Button button = (Button) view.findViewById(R.id.linkbutton);

        //onclick puts it all in database moves back to home screen
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v = view;
                EditText etcity = (EditText) view.findViewById(R.id.linktext);
                cityout = etcity.getText().toString();
                EditText etlat = (EditText) view.findViewById(R.id.lattext);
                latout = etlat.getText().toString();
                EditText etlong = (EditText) view.findViewById(R.id.longtext);
                longout = etlong.getText().toString();
                String newEntry = "City  " + cityout + "      " + "Latitude  " +latout + "         " + "Longitude  " + longout;
                addData(newEntry);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                v.setEnabled(false);
            }
        });
        return view;
    }
    public void addData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(getActivity(), "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        }



    }



}
