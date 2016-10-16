package com.ghedeon.transitionbug;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.transition.Transition;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class TransitionListenerAdapter implements Transition.TransitionListener {
    @Override
    public void onTransitionStart(@NonNull final Transition transition) {
        // empty
    }

    @Override
    public void onTransitionEnd(@NonNull final Transition transition) {
        // empty
    }

    @Override
    public void onTransitionCancel(@NonNull final Transition transition) {
        // empty
    }

    @Override
    public void onTransitionPause(@NonNull final Transition transition) {
        // empty
    }

    @Override
    public void onTransitionResume(@NonNull final Transition transition) {
        // empty
    }
}
