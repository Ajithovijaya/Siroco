package ajith_siroco.app.com.siroco.introduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ajith_siroco.app.com.siroco.Activities.ListPatientActivity;
import ajith_siroco.app.com.siroco.R;


public class IntroActivity extends AppCompatActivity {



    ViewPager viewPager;
    TextView btn_skip,btn_next;
    LinearLayout dotscontainer;
    ImageView[] dots;
    int dotscount;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager=(ViewPager)findViewById(R.id.viewpager_intro);
        dotscontainer=(LinearLayout)findViewById(R.id.linear);
        btn_skip=(TextView)findViewById(R.id.skip_intro);
        btn_next=(TextView)findViewById(R.id.next_intro);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dotscount-1==viewPager.getCurrentItem())
                {
                    Intent intent=new Intent(IntroActivity.this,ListPatientActivity.class);
                    startActivity(intent);
                    finish();
                }else
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
            }
        });

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(IntroActivity.this,ListPatientActivity.class);
                startActivity(intent);
                finish();
            }
        });





        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Intro1());
        adapter.addFrag(new Intro2());
        adapter.addFrag(new Intro3());
        viewPager.setAdapter(adapter);
        dotscount=adapter.getCount();
        dots=new ImageView[dotscount];

        for (int i=0;i<dotscount;i++)
        {

            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_dot));

            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,8,0,8);
            dotscontainer.addView(dots[i],params);


        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(viewPagerChangListener);
    }




    ViewPager.OnPageChangeListener viewPagerChangListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position==dotscount-1)
            {
                btn_next.setText("Done");
            }
            else
            {
                btn_next.setText("Next");
            }

            for (int i=0;i<dotscount;i++)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.inactive_dot));
            }
            dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    private class ViewPagerAdapter extends FragmentPagerAdapter {


        List<Fragment> mfrag_list=new ArrayList<>();



        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }



        public void addFrag(Fragment fragment) {
            mfrag_list.add(fragment);


        }

        @Override
        public Fragment getItem(int position) {
            return mfrag_list.get(position);
        }

        @Override
        public int getCount() {
            return mfrag_list.size();
        }
    }
}
