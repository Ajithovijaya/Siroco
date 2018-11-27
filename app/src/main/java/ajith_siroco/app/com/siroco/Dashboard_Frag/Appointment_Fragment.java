package ajith_siroco.app.com.siroco.Dashboard_Frag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.Fragments.CalendarFragment;
import ajith_siroco.app.com.siroco.Fragments.ListFragment;
import ajith_siroco.app.com.siroco.R;

public class Appointment_Fragment extends Fragment implements View.OnClickListener {


    Toolbar toolbar;
    LinearLayout btn_calender,btn_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_appointment,container,false);
        toolbar=(Toolbar)view.findViewById(R.id.tool_appoint);

        ((DashBoardActivity) getActivity()).setSupportActionBar(toolbar);
        ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("Appointments");
        ((DashBoardActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    btn_calender=(LinearLayout)view.findViewById(R.id.btn_show_cal);
    btn_list=(LinearLayout)view.findViewById(R.id.btn_listview);

    btn_list.setOnClickListener(this);
    btn_calender.setOnClickListener(this);

        btn_calender.setSelected(true);
        btn_list.setSelected(false);
        changeFrag(CalendarFragment.newInstance());

    }



    void changeFrag(Fragment fragment)
    {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.appointment_container,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.btn_show_cal:
                btn_calender.setSelected(true);
                btn_list.setSelected(false);
                changeFrag(CalendarFragment.newInstance());
                break;

            case R.id.btn_listview:
                btn_list.setSelected(true);
                btn_calender.setSelected(false);
                changeFrag(ListFragment.newInstance());
                break;
        }


    }
}
