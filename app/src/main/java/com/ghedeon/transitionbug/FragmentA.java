package com.ghedeon.transitionbug;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.ChangeBounds;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment {

    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        final View imageA = rootView.findViewById(R.id.imageA);
        ViewCompat.setTransitionName(imageA, "transition");

        imageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final FragmentB fragmentB = FragmentB.newInstance();
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    final ChangeBounds changeBounds = new ChangeBounds();

                    // MAGIC!
//                    changeBounds.addListener(new TransitionListenerAdapter());

                    fragmentB.setSharedElementEnterTransition(changeBounds);
                }
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, fragmentB)
                        .addSharedElement(imageA, "transition")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

}
