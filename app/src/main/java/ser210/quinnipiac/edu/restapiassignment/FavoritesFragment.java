package ser210.quinnipiac.edu.restapiassignment;


import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mattc on 4/5/2018.
 */
public class FavoritesFragment extends ListFragment{
    private ArrayAdapter listAdapter;
    private DatabaseHelper myDB;
    private View v;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    //creates fragment with the view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_favorites, container, false);
        return v;
    }

    //when the activity is created, it puts all the contents in the view
    public void onActivityCreated(Bundle sid) {
        super.onActivityCreated(sid);
        myDB = new DatabaseHelper(getContext());
        ListView listView = (ListView) v.findViewById(android.R.id.list);


        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();


        if(data.getCount() == 0) {
            Toast.makeText(getActivity(), "No data enetered!", Toast.LENGTH_LONG).show();
        }else {
            while(data.moveToNext()) {
                theList.add(data.getString(1));
                listAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);

            }
        }


    }

}
