package ajith_siroco.app.com.siroco.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import ajith_siroco.app.com.siroco.R;
import ajith_siroco.app.com.siroco.introduction.IntroActivity;
import ajith_siroco.app.com.siroco.introduction.Pref;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btn_logIn;
    Pref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btn_logIn=(ImageView)findViewById(R.id.log_in);
        pref=new Pref(getApplicationContext());
        btn_logIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.log_in:

                if (!pref.isFirsttime())
                {
                    pref.setFirstTime();
                    Intent intent=new Intent(LogInActivity.this,IntroActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(LogInActivity.this,ListPatientActivity.class);
                    startActivity(intent);
                }

                break;

        }
    }
}
