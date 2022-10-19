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

public class Adapter extends FirebaseRecyclerAdapter<model,Adapter.myViewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewholder holder, final int position, @NonNull model model) {
        holder.amount.setText(model.getAmount());
        holder.describtion.setText(model.getDescription());
        holder.location.setText(model.getLocation());
        holder.reciept.setText(model.getReceipt());


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.amount.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                View view1=dialogPlus.getHolderView();
                EditText amount=view1.findViewById(R.id.edname);
                EditText describtion=view1.findViewById(R.id.eddescribtion);
                EditText location=view1.findViewById(R.id.edloc);
                EditText reciept=view1.findViewById(R.id.edrec);
                Button update=view1.findViewById(R.id.btn_update);

                amount.setText(model.getAmount());
                describtion.setText(model.getDescription());
                location.setText(model.getLocation());
                reciept.setText(model.getReceipt());

                dialogPlus.show();
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("Amount",amount.getText().toString());
                        map.put("Describtion",describtion.getText().toString());
                        map.put("Location",location.getText().toString());
                        map.put("Reciept",reciept.getText().toString());


                        FirebaseDatabase.getInstance().getReference().child("details")
                                .child(getRef(holder.getAdapterPosition()).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.amount.getContext(), R.string.up_sucess_message, Toast.LENGTH_SHORT).show();

                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.amount.getContext(), R.string.up_unsuccess_message, Toast.LENGTH_SHORT).show();

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
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.amount.getContext());
                builder.setTitle(R.string.delete_message);

                builder.setMessage(R.string.undo_message);
                builder.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("details")
                                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.amount.getContext(), "cancelled", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_items,parent,false);
        return new myViewholder(view);

    }

    class myViewholder extends RecyclerView.ViewHolder{


        TextView amount,describtion,location,reciept;
        Button edit,delete;

        public myViewholder(@NonNull View itemView) {
            super(itemView);

            amount=(TextView)itemView.findViewById(R.id.amount);
            describtion=(TextView)itemView.findViewById(R.id.des);
            location=(TextView)itemView.findViewById(R.id.loc);
            reciept=(TextView)itemView.findViewById(R.id.rec);
            edit=(Button)itemView.findViewById(R.id.btn_edit);
            delete=(Button)itemView.findViewById(R.id.btn_del);

        }
    }


}
