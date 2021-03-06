package com.example.fragmentview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentview.Retrofit.NetworkService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Goals extends Fragment {
    GoogleSignInClient mGoogleSignInClient;
    String personName;
    String personEmail;
    TextView weeklyGoals;
    Button btn_weeklysubmit;

    private OnFragmentInteractionListener mListener;
    View view;
    private RecyclerView recyclerView;
    ModelClass modelClass;
    ModelClass.Status status;
    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    private List<ModelClass.Status> goalsData = new ArrayList<>();

    public Goals() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_goals, container, false);
        recyclerView = view.findViewById(R.id._recyclerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Google sign in options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount accnt = GoogleSignIn.getLastSignedInAccount(getActivity());
        personName = accnt.getDisplayName();
        personEmail = accnt.getEmail();

        //set current date
        Calendar calendar = Calendar.getInstance();
        String currentDatee = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());
        TextView nDate = view.findViewById(R.id.date);
        nDate.setText(currentDatee);

        CharSequence currentDate1 = android.text.format.DateFormat.format("MM/dd/yyyy", calendar);
        Log.e("DATE FORMAT", currentDate1.toString());
        //retrofit Json parsing
        JsonObject kpulse_data = new JsonObject();
        kpulse_data.addProperty("name", personName);
        kpulse_data.addProperty("email", personEmail);
        kpulse_data.addProperty("startDate", "01/02/2020");
        kpulse_data.addProperty("endDate", currentDate1.toString());
        Call<ModelClass> call = NetworkService.getApiService(getActivity()).getModelclass(kpulse_data);
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                modelClass = response.body();

                GoalsAdapter adapter = new GoalsAdapter(getContext(), modelClass.getStatus());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.e("error in response for Goals", t.toString());


            }
        });
        Button btn_weeklysubmit = view.findViewById(R.id.btnsubmit_task);
//        btn_weeklysubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JsonObject goals_data = new JsonObject();
//
//                goals_data.addProperty("date","02/10/2020");
//
//
//            }
//        });
//
//
//                Log.e("SORT", "getting into loop");
//        try {
//            Log.e("SORTING", "In try catch");
//            Collections.sort(goalsData, new Comparator<ModelClass.Status>() {
//                DateFormat format = new SimpleDateFormat("MM/dd/yyy");
//
//                @Override
//                public int compare(ModelClass.Status o1, ModelClass.Status o2) {
//
//                    try {
//                        Log.e("SORTED", "sorting is done");
//
//                        return format.parse(o1.getStartDate()).compareTo(format.parse(o2.getStartDate()));
//
//                    } catch (ParseException e) {
//                        Log.e("CaTch ERROR", e.toString());
//                        throw new IllegalArgumentException(e);
//                    }
//                }
//            });
//        } catch (Exception t) {
//            Log.e("CATCH ERROR", t.toString());
//        }

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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
