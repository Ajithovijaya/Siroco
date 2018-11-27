package ajith_siroco.app.com.siroco.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClinicalInfoFragment extends Fragment {


    Toolbar toolbar;

    public ClinicalInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_clinical_info, container, false);
        toolbar=(Toolbar)view.findViewById(R.id.tool_clinic);

        ((DashBoardActivity)getActivity()).setSupportActionBar(toolbar);
        ((DashBoardActivity)getActivity()).getSupportActionBar().setTitle("Clinical info");
        ((DashBoardActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);
        return view;
    }

    public static Fragment newInstance() {
        ClinicalInfoFragment fragment=new ClinicalInfoFragment();
        Bundle arg=new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }
}
