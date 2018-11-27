package ajith_siroco.app.com.siroco.Dashboard_Frag;



import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ajith_siroco.app.com.siroco.DashBoardActivity;
import ajith_siroco.app.com.siroco.Fragments.ClinicalInfoFragment;
import ajith_siroco.app.com.siroco.Fragments.PatientDetails_Fragment;
import ajith_siroco.app.com.siroco.R;

public class Home_Frgament extends Fragment implements View.OnClickListener,FragmentManager.OnBackStackChangedListener {

    CardView details,clinic;
    View movingFragmentView;
    int backstacount;

    Toolbar toolbar;

    public static Home_Frgament newInstance()
    {
        Home_Frgament frgament=new Home_Frgament();
        Bundle arg=new Bundle();
        frgament.setArguments(arg);
        return frgament;

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragent_home,container,false);
        toolbar=(Toolbar)view.findViewById(R.id.tool_home);
        ((DashBoardActivity) getActivity()).setSupportActionBar(toolbar);
        ((DashBoardActivity) getActivity()).getSupportActionBar().setTitle("");
//        ((DashBoardActivity) getActivity()).getSupportActionBar().
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        details=(CardView)view.findViewById(R.id.btn_details);
        clinic=(CardView)view.findViewById(R.id.btn_clinical);
        details.setOnClickListener(this);
        clinic.setOnClickListener(this);
    }

    private void changefrag(final Fragment fragment) {
        Animator.AnimatorListener  listener=new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fragcommit(fragment);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        };

        slidBack(listener);
    }



    void fragcommit(Fragment fragment)    {
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentManager.addOnBackStackChangedListener(this);
        fragmentTransaction.setCustomAnimations(R.anim.slide_left_out, 0,0,R.anim.slide_right_out);

        fragmentTransaction.replace(R.id.frag_container,fragment);
        fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.addToBackStack("stack");
        fragmentTransaction.commit();
    }




    private void slidBack(Animator.AnimatorListener listener) {
        movingFragmentView = getView();
        ObjectAnimator movingFragmentAnimator=ObjectAnimator.ofFloat(movingFragmentView,"translationX",0 , -50);
        movingFragmentAnimator.setDuration(1000);
        ObjectAnimator darkHoverViewAnimator = ObjectAnimator.ofFloat(movingFragmentView, "alpha",0);
        darkHoverViewAnimator.setStartDelay(1000);
        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator,darkHoverViewAnimator);
        s.addListener(listener);
        s.start();
    }



    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.btn_details:
                changefrag(PatientDetails_Fragment.newInstance());
                break;
            case R.id.btn_clinical:
                changefrag(ClinicalInfoFragment.newInstance());
                break;

        }
    }



    private void slidForward() {
        Log.e("Test", "Slid forward: Return to back" );
        movingFragmentView = getView();
        ObjectAnimator darkHoverViewAnimator = ObjectAnimator.ofFloat(movingFragmentView, "alpha",1);
        ObjectAnimator movingFragmentAnimator=ObjectAnimator.ofFloat(movingFragmentView,"translationX",-50 , 0);
        movingFragmentAnimator.setDuration(1000);
        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator,darkHoverViewAnimator);
        s.start();
    }



    @Override
    public void onBackStackChanged() {
        if (getFragmentManager()!=null) {
            backstacount = getFragmentManager().getBackStackEntryCount();
            if (backstacount == 0) {
                slidForward();
            }
        }
    }
}
