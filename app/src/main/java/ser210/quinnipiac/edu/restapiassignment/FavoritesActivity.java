package ser210.quinnipiac.edu.restapiassignment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mattc on 4/5/2018.
 */
public class FavoritesActivity extends Activity {

    private DatabaseHelper myDB;
    private LinearLayout ll;
    private ArrayAdapter listAdapter;
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    @Override
    //puts the fragment into the activity and changes the background picture
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        myDB = new DatabaseHelper(this);
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragfavcont, new FavoritesFragment());
        mFragmentTransaction.commit();
        ll = (LinearLayout) findViewById(R.id.favlayout);
        ll.setBackgroundResource(MainActivity.backgroundCheck());
    }


    //when the button is clicked, delete all the data
    public void onDeleteClick(View v) {
        myDB.deleteData();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("favfrag", "Sports");
        startActivity(intent);
    }
}
