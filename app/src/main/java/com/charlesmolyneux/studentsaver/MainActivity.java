package com.charlesmolyneux.studentsaver;

import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OutgoingsFragment.OnFragmentInteractionListener {
    String tag = "outgoingTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.manageBudgetFloatingButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OutgoingsFragment outgoingsFragment = new OutgoingsFragment();

                OutgoingsFragment outFrag = (OutgoingsFragment) getSupportFragmentManager().findFragmentByTag(tag);

                if (outFrag != null) {
                    getSupportFragmentManager().beginTransaction().remove(outFrag).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,outgoingsFragment,tag).commit();

                }




            }
        });
    }


}