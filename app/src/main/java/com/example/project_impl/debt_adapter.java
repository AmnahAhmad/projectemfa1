package com.example.project_impl;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class debt_adapter extends FirebaseRecyclerAdapter<model,debt_adapter.myViewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public debt_adapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewholder holder, int position, @NonNull model model) {
        holder.debt_amount.setText(model.getDebt_Amount());
        holder.debt_describtion.setText(model.getDebt_Description());
        holder.debt_date.setText(model.getDate());
        holder.debt_reciept.setText(model.getDebt_Receipt());


    }


    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.debt_main_item,parent,false);
        return new myViewholder(view);

    }

    class myViewholder extends RecyclerView.ViewHolder{


        TextView debt_amount,debt_describtion,debt_date,debt_reciept;


        public myViewholder(@NonNull View itemView) {
            super(itemView);

            debt_amount=(TextView)itemView.findViewById(R.id.debt_in_amount1);
            debt_describtion=(TextView)itemView.findViewById(R.id.debt_in_des1);
            debt_date=(TextView)itemView.findViewById(R.id.debt_in_date1);
            debt_reciept=(TextView)itemView.findViewById(R.id.debt_in_receipt1);


        }
    }


}
