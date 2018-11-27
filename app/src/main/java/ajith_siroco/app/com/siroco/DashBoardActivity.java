package ajith_siroco.app.com.siroco;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;

import ajith_siroco.app.com.siroco.Dashboard_Frag.Appointment_Fragment;
import ajith_siroco.app.com.siroco.Dashboard_Frag.Home_Frgament;
import ajith_siroco.app.com.siroco.Dashboard_Frag.Message_Fragment;
import ajith_siroco.app.com.siroco.R;

public class DashBoardActivity extends AppCompatActivity {
    ViewPager viewPager;
    Home_Frgament home_frgament=Home_Frgament.newInstance();
    Appointment_Fragment appointment_fragment=new Appointment_Fragment();
    Message_Fragment message_fragment=new Message_Fragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(home_frgament);
                    return true;
                case R.id.navigation_appointment:
                    changeFragment(appointment_fragment);

                    return true;
                case R.id.navigation_message:

                    changeFragment(message_fragment);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        changeFragment(new Home_Frgament());
    }

    void changeFragment(final Fragment fragment)
    {
                FragmentManager fragmentManager=getSupportFragmentManager();

                // to change all sub fragments from stack
                fragmentManager.popBackStack("stack",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_container,fragment);
                fragmentTransaction.commit();


    }


}
