package ajith_siroco.app.com.siroco.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ajith_siroco.app.com.siroco.R;


public class InsuranceFragment extends Fragment {

    public InsuranceFragment() {
        // Required empty public constructor
    }



    public static InsuranceFragment newInstance()
    {
        InsuranceFragment fragment=new InsuranceFragment();
        Bundle arg=new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insurance, container, false);
    }






}
