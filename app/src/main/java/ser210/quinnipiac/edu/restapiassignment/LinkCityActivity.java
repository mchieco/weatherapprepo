package ser210.quinnipiac.edu.restapiassignment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ShareActionProvider;

/**
 * Created by mattc on 4/5/2018.
 */
public class LinkCityActivity extends Activity {
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private MainFragment mFragment;
    private ShareActionProvider shareActionProvider;
    @Override
    //creates the view and then puts the fragment into the view
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_city);
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.linkcityact, new LinkCityFragment());
        mFragmentTransaction.commit();
    }
}
