package com.kasimkartal866.mybookmedia;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kasimkartal866.mybookmedia.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final ArrayList<User> data;

    public UserAdapter(ArrayList<User> data) {
        this.data = data;
    }

    public UserAdapter() {
        this.data = new ArrayList<User>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User user = data.get(position);
        holder.binding.recyclerViewTextView.setText(user.bookName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), AddBookActivity.class);
                intent.putExtra(G.USER_ACTIVITY_INFO, G.USER_ACTIVITY_INFO_OLD);
                intent.putExtra(G.USER_ACTIVITY_INFO_USERID, data.get(holder.getAdapterPosition()).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerRowBinding binding;

        public ViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void submitList(List<User> users) {
        this.data.clear();
        this.data.addAll(users);
        this.notifyDataSetChanged();
    }
}