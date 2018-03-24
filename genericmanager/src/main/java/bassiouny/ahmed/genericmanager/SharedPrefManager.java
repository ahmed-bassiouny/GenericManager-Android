package bassiouny.ahmed.genericmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

/**
 * Created by bassiouny on 24/03/18.
 */

public class SharedPrefManager {
    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor ;

    public static void init(Context context,String sharedPrefName) {
        if (sharedPref == null) {
            sharedPref = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
            editor = sharedPref.edit();
        }
    }
    public static void setString(@NonNull String key,@NonNull String val){
        editor.putString(key, val);
        editor.apply();
    }
    public static String getString(@NonNull String key){
        return sharedPref.getString(key, "");
    }
    public static void setInteger(@NonNull String key, int val){
        editor.putInt(key, val);
        editor.apply();
    }
    public static int getInteger(@NonNull String key){
        return sharedPref.getInt(key,0);
    }
    public static void setBoolean(@NonNull String key, boolean val){
        editor.putBoolean(key, val);
        editor.apply();
    }
    public static boolean getBoolean(@NonNull String key){
        return sharedPref.getBoolean(key, false);
    }
    public static void setFloat(@NonNull String key, float val){
        editor.putFloat(key, val);
        editor.apply();
    }
    public static float getFloat(@NonNull String key){
        return sharedPref.getFloat(key, 0);
    }
    public static void setLong(@NonNull String key, long val){
        editor.putLong(key, val);
        editor.apply();
    }
    public static long getLong(@NonNull String key){
        return sharedPref.getLong(key, 0);
    }
    public static <T>  void setObject(@NonNull String key,@NonNull Class<T> t){
        Gson gson = new Gson();
        editor.putString(key,gson.toJson(t));
        editor.apply();
    }
    public static <T> T getObject(@NonNull String key,Class<T> t){
        Gson gson = new Gson();
        String json = sharedPref.getString(key, "");
        return gson.fromJson(json, t);
    }
}
