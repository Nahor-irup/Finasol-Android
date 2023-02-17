package com.example.finasol.Dashboard.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finasol.R;
import com.example.finasol.db.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecyclerViewAdapter extends RecyclerView.Adapter<TransactionRecyclerViewHolder> {

    private Context context;
    private List<Transaction> transactionList;
    private ITransactionAdapterListener listener;

    public TransactionRecyclerViewAdapter(Context context, List<Transaction> transactionList, ITransactionAdapterListener listener) {
        this.context = context;
        this.transactionList = transactionList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TransactionRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_transaction_layout,parent,false);

        return new TransactionRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionRecyclerViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.getT_id().setText(String.valueOf(transaction.Id));
        holder.getT_member().setText(transaction.Member);
        holder.getT_amount().setText(transaction.Amount);
        holder.getT_date().setText(transaction.Date);

        holder.getClRootLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "Item at"+holder.getAdapterPosition()+" clicked", Toast.LENGTH_SHORT).show();
                listener.onItemClicked(transaction);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public void searchDataList(ArrayList<Transaction> searchList){
        transactionList = searchList;
        notifyDataSetChanged();
    }

    public interface ITransactionAdapterListener{
        void onItemClicked(Transaction transaction);
    }
}
