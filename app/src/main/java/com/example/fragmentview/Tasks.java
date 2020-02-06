package com.example.fragmentview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentview.Retrofit.NetworkService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tasks extends Fragment {
    Context context;
    GoogleSignInClient mGoogleSignInClient;
    String personName;
    String personEmail;

    private OnFragmentInteractionListener mListener;
    ModelClass modelClass;
    ModelClassLoad modelClassLoad;
    TextView add_goals, reslovedtasks;
    EditText todaystask, obstaclesfacing, yourIdeas, awardsAppreciation;
    private ProgressBar spinner;

    public Tasks() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        spinner = view.findViewById(R.id.progressBar1);


        //google sign in information
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount accnt = GoogleSignIn.getLastSignedInAccount(getActivity());
        personName = accnt.getDisplayName();
        personEmail = accnt.getEmail();


        //push the layout up when keyboard appears
        Objects.requireNonNull(getActivity()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        //variable declaration
        add_goals = view.findViewById(R.id.add_goals);
        reslovedtasks = view.findViewById(R.id.resolved_tasks);
        todaystask = view.findViewById(R.id.toady_accomplishment);
        obstaclesfacing = view.findViewById(R.id.obstacles_facing);
        yourIdeas = view.findViewById(R.id.your_ideas);
        awardsAppreciation = view.findViewById(R.id.awards);


        Calendar calendar = Calendar.getInstance();
        CharSequence currentDate1 = android.text.format.DateFormat.format("MM/dd/yyyy", calendar);
        getdata(currentDate1.toString());
        {
            view.findViewById(R.id.progressBar1).setVisibility(View.GONE);
            view.findViewById(R.id.progressBar1).setVisibility(View.VISIBLE);
            String message = "Be patient while Loading";
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }


        view.findViewById(R.id.progressBar1).setVisibility(View.VISIBLE);
        view.findViewById(R.id.progressBar1).setVisibility(View.GONE);

        // for current date on toolbar
        String currentDate = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(calendar.getTime());

        //set the text in toolbar
        TextView mDate = view.findViewById(R.id.date);
        mDate.setText(currentDate);
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datepicker();
            }
        });

        Button btnsubmit_task = view.findViewById(R.id.btnsubmit_task);
        btnsubmit_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject tsk_data = new JsonObject();
                tsk_data.addProperty("appreciation", "");
                tsk_data.addProperty("delayedStatus", "false");
                tsk_data.addProperty("email", personEmail);
                tsk_data.addProperty("goalTomorrow", "");
                tsk_data.addProperty("innovationOrIdea", "");
                tsk_data.addProperty("message", "");
                tsk_data.addProperty("name", personName);
                tsk_data.addProperty("pendingObstucles", "");
                tsk_data.addProperty("ratedBy", "");
                tsk_data.addProperty("reviews", "0");
                tsk_data.addProperty("startDate", "01/02/2020");
                tsk_data.addProperty("taskCompletion", "true");
                tsk_data.addProperty("taskResolved", "");
                tsk_data.addProperty("taskToday", " ");
                tsk_data.addProperty("endDate", "02/05/2020");

                Call<JsonObject> call = NetworkService.getApiService(getActivity()).getCreateStatus(tsk_data);
                call.enqueue(new Callback<JsonObject>() {

                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        JsonObject rasp = response.body();
                        String message = rasp.get("message").getAsString();

                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
            }
        });

        return view;

    }

    //datepicker
    private void datepicker() {
        final TextView mDate = getView().findViewById(R.id.date);
        final Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DAY_OF_MONTH);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.Datepicker, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int date) {
                String dateString = month + " " + date + " " + year;


                mDate.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                CharSequence currentDate2 = android.text.format.DateFormat.format("MM/dd/yyyy", calendar1);
                getdata(currentDate2.toString());

                CharSequence dateCharSequence = android.text.format.DateFormat.format("MMM  d, yyyy", calendar1);
                mDate.setText(dateCharSequence);

            }
        }, YEAR, MONTH, DATE);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }


    private void getdata(String dateStr) {
        spinner.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
        String message = "Be patient while Loading";
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

        JsonObject load_status = new JsonObject();
        //calling current date

        load_status.addProperty("name", personName);
        load_status.addProperty("email", personEmail);
        load_status.addProperty("startDate", dateStr);


        Call<ModelClassLoad> call = NetworkService.getApiService(getActivity()).getModelclassLoad(load_status);
        call.enqueue(new Callback<ModelClassLoad>() {
            @Override
            public void onResponse(Call<ModelClassLoad> call, Response<ModelClassLoad> response) {
                try {
                    modelClassLoad = response.body();

                    add_goals.setText(modelClassLoad.getWeeklyGoals());

                    Log.e("WEEKLY GOAL", modelClassLoad.getWeeklyGoals());

                    try {
                        if (!modelClassLoad.getTaskToday().isEmpty()) {
                            todaystask.setText(modelClassLoad.getTaskToday());
                            Log.e("LOAD", modelClassLoad.getTaskToday());
                        } else {
                            todaystask.setText("Add Your Task");
                        }
                        //if loop for the tasks resolved
                        try {
//                            Calendar calendar= Calendar.getInstance();
//                            String dayOfWeek = DateFormat.getDateInstance(DateFormat.DAY_OF_WEEK_FIELD).format(calendar.getTime());
//
//                            if (dayOfWeek.equalsIgnoreCase(Satuday|Sunday))
                            if (!modelClassLoad.getTaskResolved().isEmpty()) {
                                Log.e("TASK RESOLVED", "you will get the message");
                                reslovedtasks.setText(modelClassLoad.getTaskResolved());
                            }

                        } catch (Exception q) {
                            reslovedtasks.setText("Need an update from Back End");


                        }
                        //if loop for the ideas
                        try {
                            if (!modelClassLoad.getInnovationOrIdea().isEmpty()) {
                                Log.e("IDEA", "you will get the ideas printed");
                                yourIdeas.setText(modelClassLoad.getInnovationOrIdea());
                            }
                        } catch (Exception w) {
                            yourIdeas.setText("Add Your Ideas/Innovation");
                        }


                        //if loop for Awards and appreciation
                        try {
                            if (!modelClassLoad.getAppreciation().isEmpty()) {
                                Log.e("Awards", "you will get awards printed");
                                awardsAppreciation.setText(modelClassLoad.getAppreciation());
                            }
                        } catch (Exception e) {
                            awardsAppreciation.setText("We are proud of YOU");
                        }
                        //if loop for obstacles
                        if (!modelClassLoad.getPendingObstucles().isEmpty()) {

                            Log.e("Obstacles", "you will get Obstacles printed");
                            obstaclesfacing.setText(modelClassLoad.getPendingObstucles());
                        } else {
                            obstaclesfacing.setText("Tell us if  you are worried");
                        }
                    } catch (Exception d) {
                        String message2 = "Today is a holiday";
                        Toast.makeText(getActivity(), message2, Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    String message1 = " problem occured while loading";
                    Toast.makeText(getActivity(), message1, Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ModelClassLoad> call, Throwable t) {
                Log.e("errorLoadAPI", t.toString());

            }
        });

        spinner.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.GONE);

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
