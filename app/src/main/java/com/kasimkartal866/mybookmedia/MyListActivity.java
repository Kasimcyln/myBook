package com.kasimkartal866.mybookmedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.kasimkartal866.mybookmedia.databinding.ActivityMyListBinding;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    private ActivityMyListBinding binding;
    UserAdapter userAdapter;
    ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        userAdapter = new UserAdapter();
        binding.recyclerView.setAdapter(userAdapter);
    }

    @Override
    protected void onResume() {
        RoomExecutor executor = new RoomExecutor((View.OnClickListener) this);
        List<User> users = executor.getUsers();
        userAdapter.submitList(users);
        super.onResume();
    }


}