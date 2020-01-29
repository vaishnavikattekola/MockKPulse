package com.example.fragmentview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.MyViewHolder>{
 Context mContext;
    List<ModelClass>goalsData;

    public GoalsAdapter(Context mContext, List<ModelClass> goalsData) {
        this.mContext = mContext;
        this.goalsData = goalsData;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
       view = LayoutInflater.from(mContext).inflate(R.layout.goals_list,parent,false);
       MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.goals_text.setText(goalsData.get(position).getToday_goals());

    }

    @Override
    public int getItemCount() {
        return goalsData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView goals_text;
        private Layout linear_layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            goals_text = itemView.findViewById(R.id.goals);
//            linear_layout =itemView.findViewById(R.layout.fragment_goals);
//            update_btn=itemView.findViewById(R.id.btn_updateGoal);

        }
    }
}
