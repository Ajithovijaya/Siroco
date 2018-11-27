package ajith_siroco.app.com.siroco.introduction;

import android.content.Context;
import android.content.SharedPreferences;

public class Pref {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public Pref(Context context)
    {
        sharedPreferences=context.getSharedPreferences("Intro",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }


    public void setFirstTime()
    {
        editor.putBoolean("isfirst",true);
        editor.commit();

    }

    public boolean isFirsttime()
    {
       return sharedPreferences.getBoolean("isfirst",false);
    }


}
