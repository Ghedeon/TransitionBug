package com.ghedeon.transitionbug;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .add(android.R.id.content, FragmentA.newInstance())
                .commit();
    }
}
