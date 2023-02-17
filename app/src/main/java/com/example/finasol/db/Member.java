package com.example.finasol.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="transaction")
public class Member {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    @ColumnInfo(name = "member")
    public String Member;

    @ColumnInfo(name = "amount")
    public String Amount;

    @ColumnInfo(name = "date")
    public String Date;

    public Member() {
    }

    public Member(int id, String member, String amount, String date) {
        Id = id;
        Member = member;
        Amount = amount;
        Date = date;
    }

    public int getId() {
        return Id;
    }

    public String getMember() {
        return Member;
    }

    public String getAmount() {
        return Amount;
    }

    public String getDate() {
        return Date;
    }
}
