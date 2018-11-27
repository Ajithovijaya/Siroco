package ajith_siroco.app.com.siroco.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.R;

public class ListPatientActivity extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);
        next=(Button)findViewById(R.id.test);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListPatientActivity.this,DashBoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
