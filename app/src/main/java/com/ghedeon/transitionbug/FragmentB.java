package com.ghedeon.transitionbug;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {

    private View imageB;

    public FragmentB() {
        // Required empty public constructor
    }

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        imageB = rootView.findViewById(R.id.imageB);
        ViewCompat.setTransitionName(imageB, "transition");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final Transition transition = (Transition) getSharedElementEnterTransition();
            if (transition != null) {
                transition.addListener(new TransitionListenerAdapter() {
                    @Override
                    public void onTransitionEnd(@NonNull final Transition transition) {
                        imageB.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }

        return rootView;
    }

}
