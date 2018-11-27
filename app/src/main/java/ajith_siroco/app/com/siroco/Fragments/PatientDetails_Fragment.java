package ajith_siroco.app.com.siroco.Fragments;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import ajith_siroco.app.com.siroco.Activities.EditActivity;
import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.R;


public class PatientDetails_Fragment extends Fragment implements View.OnClickListener {

 Toolbar toolbar;

 LinearLayout btn_general,btn_insurance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_patientdetails,container,false);
        toolbar=(Toolbar)view.findViewById(R.id.tool_details);
            ((DashBoardActivity) getActivity()).setSupportActionBar(toolbar);
            ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("Patiant Text");
            ((DashBoardActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setHasOptionsMenu(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Back", Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack();

                }
            });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_general=(LinearLayout)view.findViewById(R.id.btn_generalde);
        btn_insurance=(LinearLayout)view.findViewById(R.id.btn_insurance);
        btn_general.setOnClickListener(this);
        btn_insurance.setOnClickListener(this);


        btn_general.setSelected(true);
        btn_insurance.setSelected(false);
        changeFrag(GeneralFragment.newInstance());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        }


    public static Fragment newInstance() {
        PatientDetails_Fragment fragment=new PatientDetails_Fragment();
        Bundle arg=new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_generalde:
                btn_general.setSelected(true);
                btn_insurance.setSelected(false);
                changeFrag(GeneralFragment.newInstance());
                break;
            case R.id.btn_insurance:
                btn_general.setSelected(false);
                btn_insurance.setSelected(true);
            changeFrag(InsuranceFragment.newInstance());
            break;
        }

    }

    private void changeFrag(Fragment fragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.details_container,fragment);;
        fragmentTransaction.commit();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.detailsmenu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.editdetails:
                Intent intent = new Intent(getActivity(), EditActivity.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }
}
