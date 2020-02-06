package com.example.fragmentview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DateFormat.Field;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Formatter;

public class Overview extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Overview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        Calendar calendar= Calendar.getInstance();
        CharSequence currentDate=android.text.format.DateFormat.format("MMMM",calendar);
//        String currentDate=
//                DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());
        TextView mDate=view.findViewById(R.id.date);
        mDate.setText(currentDate);

        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date_picker();
            }
        });

        return view;
    }



    private void date_picker() {
        final TextView mDate= getView().findViewById(R.id.date);
        final Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.Datepicker,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int date) {
                String dateString = month + " " + date +" "+ year;
                mDate.setText(dateString);
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR,year);
                calendar1.set(Calendar.MONTH,month);
                calendar1.set(Calendar.DATE,date);

                CharSequence dateCharSequence = android.text.format.DateFormat.format("MMMM",calendar1);
                mDate.setText(dateCharSequence);

            }
        },YEAR,MONTH,DATE);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
