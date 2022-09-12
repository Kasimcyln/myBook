package com.kasimkartal866.mybookmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {
    private TextView tvSelect;
    private Button btnAddBook;
    private Button btnMyList;
    private Button btnAllList;
    private Button btnLogOut;
    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        initView();
        onClickMethods();

        if (getIntent().getExtras() != null) {
            String name = getIntent().getStringExtra(G.USER_NAME_INTENT_KEY);
            if (name != null) {
                tvWelcome.setText("Welcome " + name);
            }
        }

    }

    public void initView() {
        btnAddBook = findViewById(R.id.btnAddBook);
        btnMyList = findViewById(R.id.btnMyList);
        btnAllList = findViewById(R.id.btnAllList);
        btnLogOut = findViewById(R.id.btnLoOut);
        tvSelect = findViewById(R.id.tvSelect);
        tvWelcome = findViewById(R.id.tvWelcome);
    }


    public void onClickMethods () {

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, AddBookActivity.class);
                startActivity(intent);


            }
        });

        btnMyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, MyListActivity.class);
                startActivity(intent);

            }
        });

        btnAllList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPageActivity.this, AllListActivity.class);
                startActivity(intent);

            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPref.getInstance().clearUserDate();
                Intent intent =new Intent(MainPageActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
