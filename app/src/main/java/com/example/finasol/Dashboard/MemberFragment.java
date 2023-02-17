package com.example.finasol.Dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finasol.Dashboard.recyclerview.MemberRecyclerViewAdapter;
import com.example.finasol.Dashboard.recyclerview.TransactionRecyclerViewAdapter;
import com.example.finasol.R;
import com.example.finasol.db.Member;
import com.example.finasol.db.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment {

    private MemberRecyclerViewAdapter adapter;
    private RecyclerView memberRecycleView;
    private List<Member> memberList;
    private SearchView searchView;

    public static MemberFragment newInstance() {
        MemberFragment fragment = new MemberFragment();
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
        View view = inflater.inflate(R.layout.fragment_member, container, false);
        memberRecycleView = view.findViewById(R.id.recycler_view_member);
        searchView = view.findViewById(R.id.searchMember);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpMemberRecyclerView();
    }

    public void setUpMemberRecyclerView(){
        adapter = new MemberRecyclerViewAdapter(
                requireActivity(),getMemberList()
        );
        memberRecycleView.setAdapter(adapter);
        memberRecycleView.setLayoutManager(new LinearLayoutManager(requireActivity()));

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
    }

    private List<Member> getMemberList(){
        memberList = new ArrayList<>();

        Member m1 = new Member();
        m1.Id = memberList.size()+1;
        m1.Member = "G521";
        m1.Amount = "126563";
        m1.Date = "2020/2/11";
        memberList.add(m1);

        Member m2 = new Member();
        m2.Id = memberList.size()+1;
        m2.Member = "G321";
        m2.Amount = "1263";
        m2.Date = "2020/2/11";
        memberList.add(m2);

        Member m3 = new Member();
        m3.Id = memberList.size()+1;
        m3.Member = "G821";
        m3.Amount = "126563";
        m3.Date = "2020/2/11";
        memberList.add(m3);

        return memberList;
    }

    public void searchList(String text) {
        ArrayList<Member> searchList = new ArrayList<>();
        for (Member member : memberList) {
            if (member.Member.toLowerCase().contains(text.toLowerCase())) {
                searchList.add(member);
            }
        }
        adapter.searchDataList(searchList);
    }
}