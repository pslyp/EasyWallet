package com.pslyp.appf1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Expense extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
