package com.charlesmolyneux.studentsaver;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//Fragment shows ListView of all outgoing / incoming for the selected time period.
//Selecting ListView will allow you to view more detail
public class SummaryFragment extends Fragment {
    ArrayList<String> tList = new ArrayList<>();


    private OnSummaryFragmentInterface mListener;
    private ArrayList<PaymentClass> paymentClasses;

    public SummaryFragment() {
        // Required empty public constructor
    }

    public static SummaryFragment newInstance(String param1, String param2) {
        SummaryFragment fragment = new SummaryFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        SQLiteDB_PaymentSaving mDbHelper = new SQLiteDB_PaymentSaving(getActivity());

        if (mDbHelper.numberOfRows() > 0) {
            paymentClasses = mDbHelper.getAllCotacts();

            //expenseAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,tList);

            ListView expenseSummaryListView = (ListView) view.findViewById(R.id.expenseSummaryListView);
            expenseSummaryListView.setAdapter(new PaymentListViewAdapter(getActivity(), paymentClasses));
        }

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSummaryFragmentInterface) {
            mListener = (OnSummaryFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnSummaryFragmentInterface {

    }
}
