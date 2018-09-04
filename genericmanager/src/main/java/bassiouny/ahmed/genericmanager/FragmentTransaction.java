package bassiouny.ahmed.genericmanager;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class FragmentTransaction {

    public static void open(AppCompatActivity activity, Fragment fragment, @IdRes int idRes, String tag){
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(idRes, fragment)
                .addToBackStack(tag)
                .commit();
    }
}
