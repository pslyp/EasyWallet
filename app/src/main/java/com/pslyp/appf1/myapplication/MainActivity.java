package com.pslyp.appf1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.pslyp.appf1.myapplication.adapter.moneyListAdapter;
import com.pslyp.appf1.myapplication.model.InExMoney;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<InExMoney> IEMoney;
    private moneyListAdapter adapter;
    private DBHelper db;
    private InExMoney mm;

    private Button income, expense;
    private ListView mListView;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        IEMoney = new ArrayList<>();
        db = new DBHelper(this);

        mListView = (ListView) findViewById(R.id.listView);
        title = (TextView) findViewById(R.id.titleTextView);
        income =  (Button) findViewById(R.id.inButton);
        expense = (Button) findViewById(R.id.exButton);

        addData();
        IEMoney = db.getList();

        adapter = new moneyListAdapter(this, R.layout.item, IEMoney);
        mListView.setAdapter(adapter);

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent income = new Intent(MainActivity.this, Income.class);
                startActivity(income);
                finish();
            }
        });

        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent expense = new Intent(MainActivity.this, Expense.class);
                startActivity(expense);
                finish();
            }
        });
    }

    private void addData() {
        mm = new InExMoney();

        mm.setPicture(R.drawable.ic_income);
        mm.setDetails("คุณพ่อให้เงิน");
        mm.setMoney(8000);
        mm.setType("in");

        db.addMoney(mm);
    }
}
