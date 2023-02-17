package com.example.finasol.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finasol.R;
import com.example.finasol.db.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateTransactionActivity extends AppCompatActivity {
    private TextView txtBoxUpdateMember;
    private TextView txtBoxUpdateAmount;
    private TextView txtBoxUpdateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_transaction);


        txtBoxUpdateMember = findViewById(R.id.txtBoxUpdateMember);
        txtBoxUpdateAmount = findViewById(R.id.txtBoxUpdateAmount);
        txtBoxUpdateDate = findViewById(R.id.txtBoxUpdateDate);

        Bundle bundle = getIntent().getExtras();
        Transaction transaction = (Transaction) bundle.getSerializable("transaction_data");
        if(transaction!=null){
            txtBoxUpdateMember.setText(transaction.getMember());
            txtBoxUpdateAmount.setText(transaction.getAmount());
            if(transaction.Date!=null){
                txtBoxUpdateDate.setText(transaction.getDate());
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String currentDate = sdf.format(new Date());
                txtBoxUpdateDate.setText(currentDate);
            }
        }
    }
}