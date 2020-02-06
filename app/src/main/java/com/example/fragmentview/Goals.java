package com.example.fragmentview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fragmentview.Retrofit.NetworkService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Goals extends Fragment {
    GoogleSignInClient mGoogleSignInClient;
    String personName;
    String personEmail;

    private OnFragmentInteractionListener mListener;
    View view;
    private RecyclerView recyclerView;
    ModelClass modelClass;
    private List<ModelClass.Status> goalsData;




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


        //retrofit Json parsing
        JsonObject kpulse_data= new JsonObject();
        kpulse_data.addProperty("name",personName);
        kpulse_data.addProperty("email",personEmail);
        kpulse_data.addProperty("startDate","01/03/2020");
        kpulse_data.addProperty("endDate","02/05/2020");

        Call<ModelClass> call= NetworkService.getApiService(getActivity()).getModelclass(kpulse_data);
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                Log.e("response","response is being received");
                modelClass = response.body();

                GoalsAdapter adapter = new GoalsAdapter(getContext(),modelClass.getStatus());
                recyclerView.setAdapter(adapter);
                goalsData=new ArrayList<>();
            }
            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.e("error in respose",t.toString());


            }
        });



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
