package com.example.finasol.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.SearchView;

import com.example.finasol.Dashboard.recyclerview.TransactionRecyclerViewAdapter;
import com.example.finasol.R;
import com.example.finasol.db.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionFragment extends Fragment implements TransactionRecyclerViewAdapter.ITransactionAdapterListener{
    private TransactionRecyclerViewAdapter adapter;
    private RecyclerView transactionRecycleView;
    private List<Transaction> transactionList;
    private SearchView searchView;
    private Button btnNewTransaction;

    public static TransactionFragment newInstance() {
        TransactionFragment fragment = new TransactionFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        transactionRecycleView = view.findViewById(R.id.recycler_view_transaction);
        searchView = view.findViewById(R.id.search);
        btnNewTransaction = view.findViewById(R.id.btnNewTransaction);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpTransactionRecyclerView();
    }

    public void setUpTransactionRecyclerView(){
        adapter = new TransactionRecyclerViewAdapter(requireActivity(),getTransactionList(),this);
        transactionRecycleView.setAdapter(adapter);
        transactionRecycleView.setLayoutManager(new LinearLayoutManager(requireActivity()));

//        search bar action
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

//        button new transaction click action
        btnNewTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(),AddTransactionActivity.class);
                startActivity(intent);
            }
        });
    }


    private List<Transaction> getTransactionList(){
        transactionList = new ArrayList<>();

        Transaction t1 = new Transaction();
        t1.Id = transactionList.size()+1;
        t1.Member = "G321";
        t1.Amount = "126563";
        t1.Date = "2020/2/11";
        transactionList.add(t1);

        Transaction t2 = new Transaction();
        t2.Id = transactionList.size()+1;
        t2.Member = "M1201";
        t2.Amount = "111";
        t2.Date = "2020/2/11";
        transactionList.add(t2);

        Transaction t3 = new Transaction();
        t3.Id = transactionList.size()+1;
        t3.Member = "C0001";
        t3.Amount = "123123";
        t3.Date = "2020/2/11";
        transactionList.add(t3);

        return transactionList;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1001) {
            //add product
            if (resultCode == 2001) {
                //add success
//                Toast.makeText(requireActivity(), "success 2001", Toast.LENGTH_SHORT).show();
            } else {
                //add failed
//                Toast.makeText(requireActivity(), "failed 2001", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == 1002) {
            //detail page
            if (resultCode == 2002) {
//                Toast.makeText(requireActivity(), "202 image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClicked(Transaction transaction) {
        Intent intent = new Intent(requireActivity(), UpdateTransactionActivity.class);
        intent.putExtra("transaction_data", transaction);
        startActivityForResult(intent, 1002);
    }


    public void searchList(String text) {
        ArrayList<Transaction> searchList = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if (transaction.Member.toLowerCase().contains(text.toLowerCase())) {
                searchList.add(transaction);
            }
        }
        adapter.searchDataList(searchList);
    }
}