package com.pslyp.appf1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pslyp.appf1.myapplication.model.InExMoney;

public class Income extends AppCompatActivity {

    private Button submit;
    private EditText detail, money;

    private DBHelper database;
    private InExMoney iem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        initialize();
    }

    @Override
    public void onBackPressed() {super.onBackPressed();
        Intent main = new Intent(Income.this, MainActivity.class);
        startActivity(main);
        finish();
    }

    private void initialize() {
        iem = new InExMoney();

        submit = (Button) findViewById(R.id.submitButton);
        detail = (EditText) findViewById(R.id.detailsEditText);
        money = (EditText) findViewById(R.id.moneyEditText);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iem.setPicture(R.drawable.ic_income);
                iem.setDetails(detail.getText().toString());
                iem.setMoney(Integer.parseInt(money.getText().toString()));
                iem.setType("in");

                database.addMoney(iem);

                Intent main = new Intent(Income.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        });

    }
}
