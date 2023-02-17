package com.example.finasol.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finasol.R;
import com.example.finasol.db.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddTransactionActivity extends AppCompatActivity {

    private TextView txtBoxMember;
    private TextView txtBoxAmount;
    private TextView txtBoxDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        txtBoxMember = findViewById(R.id.txtBoxMember);
        txtBoxAmount = findViewById(R.id.txtBoxAmount);
        txtBoxDate = findViewById(R.id.txtBoxDate);


    }
}