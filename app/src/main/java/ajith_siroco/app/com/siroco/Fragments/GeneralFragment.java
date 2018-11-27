package ajith_siroco.app.com.siroco.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ajith_siroco.app.com.siroco.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralFragment extends Fragment {


    public static GeneralFragment newInstance()
    {
        GeneralFragment fragment=new GeneralFragment();
        Bundle arg=new Bundle();
        fragment.setArguments(arg);
        return fragment;
    }

    public GeneralFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_general, container, false);
    }

}
