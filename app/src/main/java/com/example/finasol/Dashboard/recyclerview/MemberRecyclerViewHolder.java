package com.example.finasol.Dashboard.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finasol.R;

public class MemberRecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView m_id;
    private TextView m_member;
    private TextView m_amount;
    private TextView m_date;
    private ConstraintLayout clMemberLayout;

    public MemberRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        m_id = itemView.findViewById(R.id.m_id);
        m_member = itemView.findViewById(R.id.m_member);
        m_amount = itemView.findViewById(R.id.m_amount);
        m_date = itemView.findViewById(R.id.m_date);
        clMemberLayout = itemView.findViewById(R.id.item_member_layout);
    }

    public TextView getM_id() {
        return m_id;
    }

    public TextView getM_member() {
        return m_member;
    }

    public TextView getM_amount() {
        return m_amount;
    }

    public TextView getM_date() {
        return m_date;
    }

    public ConstraintLayout getClMemberLayout() {
        return clMemberLayout;
    }
}
