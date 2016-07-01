package com.charlesmolyneux.studentsaver;

import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OutgoingsFragment.OnFragmentInteractionListener, SummaryFragment.OnSummaryFragmentInterface{
    String tag = "outgoingTag";
    String sumTag = "sumTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.manageBudgetFloatingButton);

        final SummaryFragment summaryFragment = new SummaryFragment();
        getSupportFragmentManager().beginTransaction().add(summaryFragment,sumTag).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    OutgoingsFragment outgoingsFragment = new OutgoingsFragment();
                    OutgoingsFragment outFrag = (OutgoingsFragment) getSupportFragmentManager().findFragmentByTag(tag);

                    if (outFrag != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,summaryFragment,sumTag).commit();

                    }
                    else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragement_container,outgoingsFragment,tag).commit();
                    }




                }
            });
        }
    }


}