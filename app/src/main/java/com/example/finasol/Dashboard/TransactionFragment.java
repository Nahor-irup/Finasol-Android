package com.example.finasol.Dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.finasol.Dashboard.recyclerview.TransactionRecyclerViewAdapter;
import com.example.finasol.R;
import com.example.finasol.db.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionFragment extends Fragment {
    private TransactionRecyclerViewAdapter adapter;
    private RecyclerView transactionRecycleView;
    private List<Transaction> transactionList;
    private SearchView searchView;

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

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpTransactionRecyclerView();
    }

    public void setUpTransactionRecyclerView(){
        adapter = new TransactionRecyclerViewAdapter(
                requireActivity(),getTransactionList()
        );
        transactionRecycleView.setAdapter(adapter);
        transactionRecycleView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return false;
            }
        });
    }

    private List<Transaction> getTransactionList(){
        transactionList = new ArrayList<>();

        Transaction t1 = new Transaction();
        t1.Id = "1";
        t1.Member = "G0001";
        t1.Amount = "126563";
        t1.Date = "2020/2/11";
        transactionList.add(t1);

        Transaction t2 = new Transaction();
        t2.Id = "2";
        t2.Member = "G0001";
        t2.Amount = "111";
        t2.Date = "2020/2/11";
        transactionList.add(t2);

        Transaction t3 = new Transaction();
        t3.Id = "3";
        t3.Member = "G0001";
        t3.Amount = "123123";
        t3.Date = "2020/2/11";
        transactionList.add(t3);

        return transactionList;
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