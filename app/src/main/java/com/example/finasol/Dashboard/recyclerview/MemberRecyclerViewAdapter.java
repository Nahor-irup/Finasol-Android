package com.example.finasol.Dashboard.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finasol.R;
import com.example.finasol.db.Member;
import com.example.finasol.db.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MemberRecyclerViewAdapter extends RecyclerView.Adapter<MemberRecyclerViewHolder> {
    private Context context;
    private List<Member> memberList;

    public MemberRecyclerViewAdapter(Context context, List<Member> memberList) {
        this.context = context;
        this.memberList = memberList;
    }

    @NonNull
    @Override
    public MemberRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_member_layout,parent,false);

        return new MemberRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberRecyclerViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.getM_id().setText(String.valueOf(member.Id));
        holder.getM_member().setText(member.Member);
        holder.getM_amount().setText(member.Amount);
        holder.getM_date().setText(member.Date);

        holder.getClMemberLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Item at"+holder.getAdapterPosition()+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public void searchDataList(ArrayList<Member> searchList){
        memberList = searchList;
        notifyDataSetChanged();
    }
}
