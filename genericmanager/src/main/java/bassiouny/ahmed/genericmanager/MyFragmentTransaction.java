package bassiouny.ahmed.genericmanager;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MyFragmentTransaction {

    public static void open(AppCompatActivity activity, Fragment fragment, @IdRes int idRes, String tag) {

        FragmentTransaction transaction = activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(idRes, fragment);
        if (tag != null)
            transaction.addToBackStack(tag);
        transaction.commit();
    }
}
