package com.example.project_impl;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class Adapter_debit extends FirebaseRecyclerAdapter<model,Adapter_debit.myViewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter_debit(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewholder holder, final int position, @NonNull model model) {
        holder.amount1.setText(model.getAmount());
        holder.description1.setText(model.getDescription());
        holder.location1.setText(model.getLocation());
        holder.receipt1.setText(model.getReceipt());
        holder.priority.setText(model.getPriority());
        Log.d("Date",model.getDate());
        holder.date.setText(model.getDate());
        holder.type.setText(model.getType());
        holder.recurring_status.setText(model.getRecurring_Status());



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.amount1.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup_debit))
                        .setExpanded(true,1200)
                        .create();

                View view1=dialogPlus.getHolderView();
                EditText update_amount=view1.findViewById(R.id.update_amount);
                EditText update_description=view1.findViewById(R.id.update_description);
                EditText update_location=view1.findViewById(R.id.update_location);
                EditText update_receipt=view1.findViewById(R.id.update_receipt);
                EditText update_priority=view1.findViewById(R.id.update_priority);
                EditText update_date=view1.findViewById(R.id.update_date);
                EditText update_type=view1.findViewById(R.id.update_type);
                EditText update_recurring_status=view1.findViewById(R.id.update_recurring_state);
                Button update=view1.findViewById(R.id.debit_update_button);

                update_amount.setText(model.getAmount());
                update_description.setText(model.getDescription());
                update_location.setText(model.getLocation());
                update_receipt.setText(model.getReceipt());
                update_priority.setText(model.getPriority());
                update_date.setText(model.getDate());
                update_type.setText(model.getType());
                update_recurring_status.setText(model.getRecurring_Status());

                dialogPlus.show();
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("Amount",update_amount.getText().toString());
                        map.put("Description",update_description.getText().toString());
                        map.put("Location",update_location.getText().toString());
                        map.put("Receipt",update_receipt.getText().toString());
                        map.put("Priority",update_priority.getText().toString());
                        map.put("Date",update_date.getText().toString());
                        map.put("Type",update_type.getText().toString());
                        map.put("Recurring_Status",update_recurring_status.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("debit_details")
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.amount1.getContext(), R.string.up_sucess_message, Toast.LENGTH_SHORT).show();

                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.amount1.getContext(), R.string.up_unsuccess_message, Toast.LENGTH_SHORT).show();

                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.amount1.getContext());
                builder.setTitle(R.string.delete_message);

                builder.setMessage(R.string.undo_message);
                builder.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("debit_details")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.amount1.getContext(), "cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_debit,parent,false);
        return new myViewholder(view);

    }

    class myViewholder extends RecyclerView.ViewHolder{


        TextView amount1,description1,location1,receipt1,priority,type,date,recurring_status;
        ImageButton edit,delete;

        public myViewholder(@NonNull View itemView) {
            super(itemView);

            amount1=(TextView)itemView.findViewById(R.id.brief);
            description1=(TextView)itemView.findViewById(R.id.descrip234);
            location1=(TextView)itemView.findViewById(R.id.loc123);
            receipt1=(TextView)itemView.findViewById(R.id.rec123);
            priority = (TextView) itemView.findViewById(R.id.priority);
            type = (TextView)itemView.findViewById(R.id.remainder_type);
            date = (TextView)itemView.findViewById(R.id.cal);
            recurring_status = (TextView)itemView.findViewById(R.id.recurring) ;
            edit=(ImageButton)itemView.findViewById(R.id.edit167);
            delete=(ImageButton)itemView.findViewById(R.id.delete178);

        }
    }


}
