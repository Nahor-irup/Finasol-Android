package com.example.finasol.Dashboard.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finasol.R;

public class TransactionRecyclerViewHolder extends RecyclerView.ViewHolder {

    private final TextView t_id;
    private final TextView t_member;
    private final TextView t_amount;
    private final TextView t_date;
    private final ConstraintLayout clRootLayout;

    public TransactionRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        t_id = itemView.findViewById(R.id.t_id);
        t_member = itemView.findViewById(R.id.t_member);
        t_amount = itemView.findViewById(R.id.t_amount);
        t_date = itemView.findViewById(R.id.t_date);
        clRootLayout = itemView.findViewById(R.id.item_transaction_layout);
    }

    public TextView getT_id() {
        return t_id;
    }

    public TextView getT_member() {
        return t_member;
    }

    public TextView getT_amount() {
        return t_amount;
    }

    public TextView getT_date() {
        return t_date;
    }

    public ConstraintLayout getClRootLayout() {
        return clRootLayout;
    }
}
