package com.charlesmolyneux.studentsaver;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddPaymentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddPaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPaymentFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public AddPaymentFragment() {
        // Required empty public constructor
    }

    public static AddPaymentFragment newInstance(String param1, String param2) {
        AddPaymentFragment fragment = new AddPaymentFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_expenditure, container, false);

        Resources resources = getResources();

        Button addPaymentButton = (Button) view.findViewById(R.id.addPaymentButton);
        final TextView dateSelectedLabel = (TextView) view.findViewById(R.id.dateSelectedTextView);

        final Spinner expenseCategory = (Spinner) view.findViewById(R.id.categoryEditText);
        ArrayAdapter<String> expenseCatStringArray = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                resources.getStringArray(R.array.category));
        expenseCategory.setAdapter(expenseCatStringArray);


        final Spinner expenseOrIncome = (Spinner) view.findViewById(R.id.expenseOrIncomeEditText);
        ArrayAdapter<String> costOrIncomeStringArray = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                resources.getStringArray(R.array.expenseOrIncome));
        expenseOrIncome.setAdapter(costOrIncomeStringArray);

        final EditText inputAmount = (EditText) view.findViewById(R.id.expenseAmountEditText);
        inputAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              /*  String amountStr = s.toString();
                if (amountStr.endsWith("p")) {
                    amountStr = amountStr.substring(0,amountStr.length()-1);
                }
                if (amountStr.startsWith("£")) {
                    amountStr = amountStr.substring(1,amountStr.length());
                }

                inputAmount.removeTextChangedListener(this);

                Double amount = Double.parseDouble(amountStr);
                if ( amount >= .99) {
                    amountStr = "£" + amountStr;
                } else {
                    amountStr = amountStr + "p";
                }
                inputAmount.setText(amountStr);
                inputAmount.addTextChangedListener(this);
*/
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        }); //Work in Progress

        final Spinner billPeriod = (Spinner) view.findViewById(R.id.billPeriodSpinner);
        ArrayAdapter<String> billPeriodStringArray = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                resources.getStringArray(R.array.billPeriodStringArray));
        billPeriod.setAdapter(billPeriodStringArray);

        Button setDateButton = (Button) view.findViewById(R.id.selectDateButton);
        setDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerFragment(v);
            }
        });

        addPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDB_PaymentSaving mDbHelper = new SQLiteDB_PaymentSaving(getActivity());


                String pType = expenseOrIncome.getSelectedItem().toString();
                String pCat = expenseCategory.getSelectedItem().toString();
                String pAmount = inputAmount.getText().toString();
                String pOccurs = billPeriod.getSelectedItem().toString();
                String pDate = dateSelectedLabel.getText().toString();

                // Gets the data repository in write mode
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(SQLiteDB_PaymentSaving.PAYMENT_TYPE, pType);
                values.put(SQLiteDB_PaymentSaving.PAYMENT_CATEGORY, pCat);
                values.put(SQLiteDB_PaymentSaving.PAYMENT_AMOUNT, pAmount);
                values.put(SQLiteDB_PaymentSaving.PAYMENT_OCCURS, pOccurs);
                values.put(SQLiteDB_PaymentSaving.PAYMENT_DATE, pDate);

               //True is successfully inserted into the SQLite DB.
               boolean t =  mDbHelper.insertPayment(pType,pCat,pAmount,pOccurs,pDate);

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void showDatePickerFragment(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getActivity().getFragmentManager(), "datePicker");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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



    public interface OnFragmentInteractionListener {
    }
}
