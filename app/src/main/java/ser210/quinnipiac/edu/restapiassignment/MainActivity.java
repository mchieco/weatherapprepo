package ser210.quinnipiac.edu.restapiassignment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.provider.FontsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;

/**
 * Created by mattc on 3/6/18.
 * Main Class that contains the backend for the first screen
 */
public class MainActivity extends Activity {
    private static int backgroundnum;
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private MainFragment mFragment;
    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragmaincontainer, new MainFragment());
        mFragmentTransaction.commit();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        setIntent("Get the Weather App! Download today:D");
        return super.onCreateOptionsMenu(menu);
    }
    private void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }
    public static int backgroundCheck() {
        if (MainActivity.getBackgroundnum() == 0) {
            return R.drawable.cloudss;
        } else if (MainActivity.getBackgroundnum() == 1) {
            return R.drawable.sunnybackground;
        } else if (MainActivity.getBackgroundnum() == 2) {
            return R.drawable.snowbackground;
        } return R.drawable.cloudss;
    }

    public static void setBackgroundnum(int num) {
        backgroundnum = num;
    }

    public static int getBackgroundnum() {
        return backgroundnum;
    }

}
